package com.bakhishli.clickbuy.product.service.product.dto.request;

import com.bakhishli.clickbuy.product.domain.enums.MoneyType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Data
@Builder
public class ProductRequestDto {
    private String id;
    private String name;
    private String description;
    private String features;
    private BigDecimal available;
    private HashMap<MoneyType, BigDecimal> price;
    private List<String> images;
    private String companyId;
    private String categoryId;

}
