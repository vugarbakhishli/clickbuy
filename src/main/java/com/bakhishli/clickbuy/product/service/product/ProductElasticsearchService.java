package com.bakhishli.clickbuy.product.service.product;

import com.bakhishli.clickbuy.product.domain.Product;
import com.bakhishli.clickbuy.product.domain.elasticsearch.ProductElasticsearch;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductElasticsearchService {
    Mono<ProductElasticsearch> create(Product product);
    Flux<ProductElasticsearch> findAll();
}
