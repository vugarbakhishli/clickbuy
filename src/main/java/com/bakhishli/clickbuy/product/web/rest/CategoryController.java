package com.bakhishli.clickbuy.product.web.rest;

import com.bakhishli.clickbuy.product.service.category.dto.response.CategoryResponseDto;
import com.bakhishli.clickbuy.product.service.category.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @GetMapping
    public Flux<CategoryResponseDto> getAll(){
        return categoryService.getAll();
    }


}
