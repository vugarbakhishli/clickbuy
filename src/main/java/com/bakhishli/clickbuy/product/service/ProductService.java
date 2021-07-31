package com.bakhishli.clickbuy.product.service;

import com.bakhishli.clickbuy.product.service.dto.request.ProductRequestDto;
import com.bakhishli.clickbuy.product.service.dto.response.ProductResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResponseDto crete (ProductRequestDto productRequestDto);
    List<ProductResponseDto> getByPaging(Pageable pageable);
}
