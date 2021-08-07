package com.bakhishli.clickbuy.product.service.category.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponseDto {
    private String id;
    private String name;
}
