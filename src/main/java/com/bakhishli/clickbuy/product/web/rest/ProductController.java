package com.bakhishli.clickbuy.product.web.rest;

import com.bakhishli.clickbuy.product.service.product.dto.response.ProductResponseDto;
import com.bakhishli.clickbuy.product.service.product.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @GetMapping
    public Flux<ProductResponseDto> getAllProduct(){
        return productService.getAll();
    }
}
