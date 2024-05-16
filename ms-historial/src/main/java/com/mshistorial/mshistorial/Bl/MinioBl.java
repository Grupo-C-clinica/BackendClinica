package com.mshistorial.mshistorial.Bl;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class MinioBl {
    @Autowired
    private MinioClient minioClient;

    public MultipartFile getFile(String bucketName, String objectName) {
        try {
            // Crear un objeto GetObjectArgs con el bucketName y objectName
            GetObjectArgs getObjectArgs = GetObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .build();

            // Obtener el objeto desde MinIO como InputStream
            InputStream inputStream = minioClient.getObject(getObjectArgs);

            // Convertir InputStream a byte[]
            byte[] bytes = IOUtils.toByteArray(inputStream);

            // Devolver un CustomMultipartFile con el nombre del objeto y los bytes
            return new CustomMultipartFile(bytes, objectName);
        } catch (MinioException | IOException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
