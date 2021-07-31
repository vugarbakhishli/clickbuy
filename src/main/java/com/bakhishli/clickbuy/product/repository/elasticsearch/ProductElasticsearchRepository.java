package com.bakhishli.clickbuy.product.repository.elasticsearch;

import com.bakhishli.clickbuy.product.domain.elasticsearch.ProductElasticsearch;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductElasticsearchRepository extends ReactiveElasticsearchRepository<ProductElasticsearch, String> {
}
