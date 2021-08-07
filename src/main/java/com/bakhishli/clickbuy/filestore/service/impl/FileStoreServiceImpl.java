package com.bakhishli.clickbuy.filestore.service.impl;

import com.bakhishli.clickbuy.filestore.service.FileStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Mono;

import java.io.File;
import java.nio.file.Files;

@Service
@RequiredArgsConstructor
public class FileStoreServiceImpl implements FileStoreService {
    @Override
    public Mono<byte[]> getImage(String id) throws Exception {
        File file = ResourceUtils.getFile("classpath:docs/image.jpg");
        return Mono.just(Files.readAllBytes(file.toPath()));
    }
}
