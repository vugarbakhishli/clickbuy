package com.bakhishli.clickbuy.product.domain.category;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
@Data
@Builder
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    private String id;
    private String name;
    private String code;
}
