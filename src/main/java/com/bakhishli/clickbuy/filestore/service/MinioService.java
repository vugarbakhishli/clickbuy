package com.bakhishli.clickbuy.filestore.service;

import java.io.File;
import java.io.InputStream;

public interface MinioService {
    void create(String id, String contentType, InputStream inputStream) throws Exception;
    void delete(String id);
    byte[] getById(String id);
}
