package com.bakhishli.clickbuy.product.service.product.impl;

import com.bakhishli.clickbuy.product.domain.Product;
import com.bakhishli.clickbuy.product.domain.category.Category;
import com.bakhishli.clickbuy.product.domain.elasticsearch.CategoryElasticsearch;
import com.bakhishli.clickbuy.product.domain.elasticsearch.CompanyElasticsearch;
import com.bakhishli.clickbuy.product.domain.elasticsearch.ProductElasticsearch;
import com.bakhishli.clickbuy.product.repository.elasticsearch.ProductElasticsearchRepository;
import com.bakhishli.clickbuy.product.service.category.impl.CategoryServiceImpl;
import com.bakhishli.clickbuy.product.service.product.ProductElasticsearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductElasticsearchServiceImpl implements ProductElasticsearchService {

    private final ProductElasticsearchRepository productElasticsearchRepository;
    private final CategoryServiceImpl categoryService;

    @Override
    public Mono<ProductElasticsearch> create(Product product) {
        ProductElasticsearch product1 = new ProductElasticsearch();
        product1.setActive(product.getActive());
        product1.setName(product.getName());
        product1.setFeatures(product.getFeatures());
        product1.setPrice(product.getPrice());
        product1.setCode(product.getCode());
        product1.setDescription(product.getDescription());
        // TODO -> get company name and code
        product1.setSeller(CompanyElasticsearch.builder().id(product.getId()).name("Test").build());
        product1.setCategory(getProductCategory(product.getCategoryId()));
        return productElasticsearchRepository.save(product1);
    }

    private CategoryElasticsearch getProductCategory(String categoryId) {
        Category category = categoryService.getById(categoryId);
        return CategoryElasticsearch.builder()
                .id(category.getId())
                .name(category.getName())
                .code(category.getCode()).build();
    }

    @Override
    public Flux<ProductElasticsearch> findAll() {
        return productElasticsearchRepository.findAll();
    }
}
