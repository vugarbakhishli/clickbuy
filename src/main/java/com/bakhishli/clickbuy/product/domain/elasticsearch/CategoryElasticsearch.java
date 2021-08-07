package com.bakhishli.clickbuy.product.domain.elasticsearch;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class CategoryElasticsearch {

    @Id
    private String id;
    private String name;
    private String code;
}
