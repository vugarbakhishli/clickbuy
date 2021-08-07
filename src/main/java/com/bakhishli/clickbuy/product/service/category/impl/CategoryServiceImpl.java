package com.bakhishli.clickbuy.product.service.category.impl;

import com.bakhishli.clickbuy.product.domain.category.Category;
import com.bakhishli.clickbuy.product.repository.mongo.category.CategoryRepository;
import com.bakhishli.clickbuy.product.service.category.CategoryService;
import com.bakhishli.clickbuy.product.service.category.dto.request.CategoryRequestDto;
import com.bakhishli.clickbuy.product.service.category.dto.response.CategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Flux<CategoryResponseDto> getAll() {
        return categoryRepository.findAll().map(this::mapToDto);
    }

    @Override
    public Category getById(String id) {
        return categoryRepository.findById(id).block();
    }

    @Override
    public CategoryResponseDto create(CategoryRequestDto categoryRequestDto) {
        Category category = Category.builder()
                .code("P" + categoryRequestDto.getName().charAt(0))
                .name(categoryRequestDto.getName())
                .build();
        return mapToDto(categoryRepository.save(category).block());
    }

    private CategoryResponseDto mapToDto(Category category){
        if(category == null){
            return null;
        }
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName()).build();
    }
}
