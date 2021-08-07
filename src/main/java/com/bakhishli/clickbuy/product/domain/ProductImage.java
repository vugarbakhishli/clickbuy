package com.bakhishli.clickbuy.product.domain;

import com.bakhishli.clickbuy.product.domain.enums.ImageType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
    private ImageType imageType;
    private String url;
}
