package com.bakhishli.clickbuy.product.domain.elasticsearch;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyElasticsearch {
    private String id;
    private String name;
    private String code;
}
