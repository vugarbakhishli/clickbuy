package com.bakhishli.clickbuy.product.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "product" )
@EqualsAndHashCode(of = "id")
public class Product {
    private String id;
    private String name;
    private String description;
    private String code;
    private String companyId;
    private String features;
    private List<ProductImage> image;
    private String categoryId;
    private Boolean active;

}
