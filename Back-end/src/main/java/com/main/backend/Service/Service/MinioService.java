package com.main.backend.Service.Service;

import com.main.backend.Domain.Upload;
import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.MinioException;
import io.minio.messages.Item;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MinioService {
    private final MinioClient minioClient;
    private static final String BUCKET_NAME = "test1";
    private static final String END_POINT = "http://localhost:9900";

    public MinioService() throws MinioException {
        minioClient = MinioClient.builder()
                .endpoint(END_POINT)
                .credentials("vCow8ZXxeznbEKryftld", "xiH0BlJKiJFTVEPl3uhOrzdpBySpK1bSV3qdOZlv")
                .build();
    }

    public List<String> getAllImageUrls() {
        List<String> imageUrls = new ArrayList<>();
        try {
            Iterable<Result<Item>> results = minioClient.listObjects(
                    ListObjectsArgs.builder().bucket(BUCKET_NAME).recursive(true).build());

            for (Result<Item> result : results) {
                Item item = result.get();
                String objectName = item.objectName();
                String imageUrl = END_POINT + "/" + BUCKET_NAME + "/" + objectName;
                imageUrls.add(imageUrl);
            }
        } catch (MinioException | InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

        return imageUrls;
    }

    public void uploadImage(Upload upload) {
        try {
            minioClient.uploadObject(
                    io.minio.UploadObjectArgs.builder()
                            .bucket(BUCKET_NAME)
                            .object(upload.getObjectName())
                            .filename(upload.getFilePath())
                            .build());
        } catch (MinioException | InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }
}