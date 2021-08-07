package com.bakhishli.clickbuy.product.domain.elasticsearch;

import com.bakhishli.clickbuy.product.domain.enums.MoneyType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.HashMap;

@Data
@Document(indexName = "product")
@EqualsAndHashCode(of = "id")
public class ProductElasticsearch {
    private String id;
    private String name;
    private String description;
    private String code;
    private CompanyElasticsearch seller;
    private String features;
    private HashMap<MoneyType, BigDecimal> price;
    private String currencySymbol;
    private CategoryElasticsearch category;
    private Boolean active;
}
