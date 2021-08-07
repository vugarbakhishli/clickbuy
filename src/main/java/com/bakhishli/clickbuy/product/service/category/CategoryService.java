package com.bakhishli.clickbuy.product.service.category;

import com.bakhishli.clickbuy.product.domain.category.Category;
import com.bakhishli.clickbuy.product.service.category.dto.request.CategoryRequestDto;
import com.bakhishli.clickbuy.product.service.category.dto.response.CategoryResponseDto;
import reactor.core.publisher.Flux;

public interface CategoryService {
   Flux<CategoryResponseDto> getAll();
   Category getById(String id);
   CategoryResponseDto create(CategoryRequestDto categoryRequestDto);
}
