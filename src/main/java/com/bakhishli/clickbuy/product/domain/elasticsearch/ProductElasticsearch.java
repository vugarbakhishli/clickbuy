package com.bakhishli.clickbuy.product.domain.elasticsearch;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "product")
@EqualsAndHashCode(of = "id")
public class ProductElasticsearch {
    private String id;
    private String name;
    private String description;
    private String code;
    private CompanyElasticsearch companyId;
    private String features;
    private CategoryElasticsearch categoryId;
    private Boolean active;
}
