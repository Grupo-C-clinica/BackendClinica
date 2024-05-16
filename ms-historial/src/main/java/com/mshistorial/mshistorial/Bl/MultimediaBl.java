package com.mshistorial.mshistorial.Bl;

import com.mshistorial.mshistorial.Dao.MultimediaRepository;
import com.mshistorial.mshistorial.Dto.MultimediaDto;
import com.mshistorial.mshistorial.Entity.Historial;
import com.mshistorial.mshistorial.Entity.Multimedia;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.StatObjectArgs;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
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

    private String bucketName = "software";

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
                                .object(multimediaName.trim()) // Cambio aquí: usa solo el nombre del archivo original
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
    public List<MultipartFileDto> findAllByHistorialId(Integer historialId) {
        List<Multimedia> multimediaList = multimediaRepository.findAllByHistorialId(historialId);
        if (multimediaList.isEmpty()) {
            System.err.println("No se encontraron archivos multimedia para el historialId: " + historialId);
        }
        List<MultipartFileDto> multipartFiles = new ArrayList<>();
        for (Multimedia multimediaEntity : multimediaList) {
            try {
                String objectName = multimediaEntity.getMultimedia().trim(); // Eliminar espacios en blanco
                System.out.println("Procesando archivo: " + objectName);

                // Verificar si el archivo existe en MinIO
                StatObjectArgs statObjectArgs = StatObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build();
                minioClient.statObject(statObjectArgs);
                System.out.println("Archivo encontrado en MinIO: " + objectName);

                // Obtener el archivo desde MinIO
                GetObjectArgs getObjectArgs = GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build();
                InputStream inputStream = minioClient.getObject(getObjectArgs);

                // Convertir InputStream a byte[]
                byte[] bytes = inputStream.readAllBytes();
                inputStream.close();
                System.out.println("Archivo obtenido y convertido: " + objectName);

                // Crear MultipartFileDto y añadirlo a la lista
                MultipartFileDto fileDto = new MultipartFileDto(
                        multimediaEntity.getMultimedia(), // Usamos el nombre del archivo como nombre en el DTO
                        multimediaEntity.getMultimedia(), // Usamos el nombre del archivo original como originalFilename en el DTO
                        "application/octet-stream", // Puedes ajustar el tipo de contenido según tus necesidades
                        bytes.length, // Tamaño del archivo
                        bytes // Bytes del archivo
                );
                multipartFiles.add(fileDto);
            } catch (MinioException e) {
                System.err.println("Error en MinIO al obtener el archivo: " + multimediaEntity.getMultimedia() + ", Error: " + e.getMessage());
                continue;
            } catch (IOException e) {
                System.err.println("Error de IO al obtener el archivo: " + multimediaEntity.getMultimedia() + ", Error: " + e.getMessage());
                continue;
            } catch (NoSuchAlgorithmException | InvalidKeyException e) {
                System.err.println("Error de seguridad al obtener el archivo: " + multimediaEntity.getMultimedia() + ", Error: " + e.getMessage());
                continue;
            }
        }
        System.out.println("Total de archivos obtenidos: " + multipartFiles.size());
        return multipartFiles;
    }


}
