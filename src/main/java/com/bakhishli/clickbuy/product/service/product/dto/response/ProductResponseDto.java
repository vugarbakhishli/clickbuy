package com.bakhishli.clickbuy.product.service.product.dto.response;

import com.bakhishli.clickbuy.product.domain.enums.MoneyType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;

@Data
@Builder
public class ProductResponseDto {
    private String id;
    private String image;
    private String name;
    private String description;
    private ProductSellerResponseDto seller;
    private String features;
    private Integer available;
    private Boolean freeDelivery;
    private String deliveryIn;
    private BigDecimal price;
    private String currencySymbol;
    private String categoryId;


}
