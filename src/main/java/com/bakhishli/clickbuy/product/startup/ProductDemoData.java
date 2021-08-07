package com.bakhishli.clickbuy.product.startup;

import com.bakhishli.clickbuy.product.domain.enums.MoneyType;
import com.bakhishli.clickbuy.product.repository.elasticsearch.ProductElasticsearchRepository;
import com.bakhishli.clickbuy.product.service.category.dto.request.CategoryRequestDto;
import com.bakhishli.clickbuy.product.service.category.dto.response.CategoryResponseDto;
import com.bakhishli.clickbuy.product.service.category.impl.CategoryServiceImpl;
import com.bakhishli.clickbuy.product.service.product.dto.request.ProductRequestDto;
import com.bakhishli.clickbuy.product.service.product.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.common.collect.List;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.stream.IntStream;

import static java.util.UUID.randomUUID;

@Component
@RequiredArgsConstructor
public class ProductDemoData {
    private final ProductServiceImpl productService;
    private final CategoryServiceImpl categoryService;
    private final ProductElasticsearchRepository productElasticsearchRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate(){
        Long countOfData = productService.count().block();
        assert countOfData != null;
        if(countOfData.equals(0L)){

            productElasticsearchRepository.deleteAll().block();

            CategoryResponseDto electronic = categoryService.create(CategoryRequestDto.builder().name("Electronic").build());
            CategoryResponseDto smartphone = categoryService.create(CategoryRequestDto.builder().name("Smartphone").build());


            IntStream.range(0,15).forEach(product -> {
                HashMap<MoneyType, BigDecimal> price = new HashMap<>(){{
                    put(MoneyType.USD, BigDecimal.valueOf((product + 1) *5));
                    put(MoneyType.EUR, BigDecimal.valueOf((product + 1) *4));
                }};
                productService.crete(ProductRequestDto.builder()
                                .categoryId(smartphone.getId())
                                .id(randomUUID().toString())
                                .description("Product description " + product)
                                .price(price)
                                .companyId(randomUUID().toString())
                                .name("Product name " + product)
                                .features("<li>Black Color</li> <li>Aluminium case</li> <li>3 years warranty</li>")
                                .images(List.of("https://cdn.alloallo.media/catalog/product/apple/iphone/iphone-x/iphone-x-space-gray.jpg"))
                                .build());
            });
        }
    }
}
