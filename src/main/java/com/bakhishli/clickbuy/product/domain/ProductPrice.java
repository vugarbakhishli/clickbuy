package com.bakhishli.clickbuy.product.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document(collection = "product_price" )
@EqualsAndHashCode(of = "id")
public class ProductPrice {
    private String id;
    private String productId;
    private String money;
    private BigDecimal price;
}
