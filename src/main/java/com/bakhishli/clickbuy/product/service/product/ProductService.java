package com.bakhishli.clickbuy.product.service.product;

import com.bakhishli.clickbuy.product.domain.elasticsearch.ProductElasticsearch;
import com.bakhishli.clickbuy.product.service.product.dto.request.ProductRequestDto;
import com.bakhishli.clickbuy.product.service.product.dto.response.ProductResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    ProductResponseDto crete (ProductRequestDto productRequestDto);
    Flux<ProductResponseDto> getAll();
    Mono<Long> count();
    ProductResponseDto mapToDto(ProductElasticsearch productElasticsearch);
}
