package com.bakhishli.clickbuy.filestore.service.impl;

import com.bakhishli.clickbuy.filestore.config.S3ConfigProperties;
import com.bakhishli.clickbuy.filestore.service.MinioService;
import io.minio.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;

@Slf4j
@Service
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {

    private final MinioClient minioClient;
    private final S3ConfigProperties s3ConfigProperties;

    @Override
    public void create(String id, String contentType, InputStream inputStream){
        try{
            var putObject = PutObjectArgs.builder()
                    .object(id)
                    .contentType(contentType)
                    .stream(inputStream, inputStream.available(), -1)
                    .bucket(s3ConfigProperties.getClickbuyBucket())
                    .build();
            minioClient.putObject(putObject);
        }catch (Exception e){
            log.error("Put objectArgs error ", e);
        }

    }

    @Override
    public void delete(String id) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .object(id)
                    .bucket(s3ConfigProperties.getClickbuyBucket())
                    .build());
        }catch (Exception e){
            log.error("Delete objectArgs error", e);
        }
    }

    @Override
    public byte[] getById(String id) {
        try {
            return minioClient.getObject(GetObjectArgs.builder()
                    .object(id)
                    .bucket(s3ConfigProperties.getClickbuyBucket())
                    .build()).readAllBytes();
        }catch (Exception e){
            log.error("Delete objectArgs error", e);
        }
        return new byte[0];
    }
}
