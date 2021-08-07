package com.bakhishli.clickbuy.product.service.product.impl;

import com.bakhishli.clickbuy.product.service.product.ProductImageService;
import org.springframework.stereotype.Service;


@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Override
    public String getProductMainImage(String id) {
        return "https://cdn1.sportngin.com/attachments/photo/cd3f-145811221/jva_logo-01__1__large.jpg";
    }
}
