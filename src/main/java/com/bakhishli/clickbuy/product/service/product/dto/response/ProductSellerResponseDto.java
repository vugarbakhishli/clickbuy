package com.bakhishli.clickbuy.product.service.product.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSellerResponseDto {
    private String id;
    private String name;
}
