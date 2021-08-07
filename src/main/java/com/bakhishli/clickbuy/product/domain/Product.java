package com.bakhishli.clickbuy.product.domain;

import com.bakhishli.clickbuy.product.domain.enums.MoneyType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Data
@Document(collection = "product" )
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    private String id;

    private String name;
    private String description;
    private String code;
    private String companyId;
    private String features;
    private List<ProductImage> image;
    private HashMap<MoneyType, BigDecimal> price;
    private String categoryId;
    private Boolean active;

}
