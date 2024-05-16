package com.mshistorial.mshistorial.Bl;

import com.mshistorial.mshistorial.Dao.MultimediaRepository;
import com.mshistorial.mshistorial.Dto.MultimediaDto;
import com.mshistorial.mshistorial.Entity.Historial;
import com.mshistorial.mshistorial.Entity.Multimedia;
import io.minio.MinioClient;
import io.minio.StatObjectArgs;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MultimediaBl {

    @Autowired
    private MultimediaRepository multimediaRepository;

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private MinioBl minioService;

    String bucketName = "software";

    //Crear multimeda de un hostorial
    public void createMultimedia(Integer historialId, List<MultipartFile> multimedia){
        for (MultipartFile multimediaDto : multimedia){
            try {
                Multimedia multimediaEntity = new Multimedia();
                Historial historial = new Historial();
                historial.setIdHistorial(historialId);
                multimediaEntity.setHistorial(historial);
                String multimediaName = multimediaDto.getOriginalFilename();
                // Sube el archivo a Minio
                minioClient.putObject(
                        io.minio.PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object(multimediaName) // Cambio aquí: usa solo el nombre del archivo original
                                .stream(multimediaDto.getInputStream(), multimediaDto.getSize(), -1)
                                .build()
                );
                multimediaEntity.setMultimedia(multimediaName);
                multimediaEntity.setStatus(true);
                multimediaRepository.save(multimediaEntity);
            } catch (MinioException | IOException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Mostrar multimedia de un historial
    public List<MultipartFile> findAllByHistorialId(Integer historialId) {
        List<Multimedia> multimediaList = multimediaRepository.findAllByHistorialId(historialId);
        List<MultipartFile> multipartFiles = new ArrayList<>();
        for (Multimedia multimediaEntity : multimediaList) {
            try {
                // Verificar si el archivo existe en MinIO
                StatObjectArgs statObjectArgs = StatObjectArgs.builder()
                        .bucket(bucketName)
                        .object(multimediaEntity.getMultimedia())
                        .build();
                minioClient.statObject(statObjectArgs);

                // Si no se lanza una excepción, el archivo existe
                // Obtener el archivo desde MinIO y añadirlo a la lista
                MultipartFile file = minioService.getFile(bucketName, multimediaEntity.getMultimedia());
                multipartFiles.add(file);
            } catch (MinioException | IOException | IllegalArgumentException e) {
                // La excepción IllegalArgumentException se lanza si el objeto no existe
                // Puedes manejarla aquí o simplemente omitir este archivo y continuar con los demás
                continue; // Omitir este archivo y continuar con el siguiente
            } catch (NoSuchAlgorithmException | InvalidKeyException e) {
                // Manejar otras excepciones aquí si es necesario
                throw new RuntimeException(e);
            }
        }
        return multipartFiles;
    }


}
