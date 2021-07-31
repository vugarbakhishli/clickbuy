package com.bakhishli.clickbuy.product.service.impl;

import com.bakhishli.clickbuy.product.service.ProductService;
import com.bakhishli.clickbuy.product.service.dto.request.ProductRequestDto;
import com.bakhishli.clickbuy.product.service.dto.response.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductResponseDto crete(ProductRequestDto productRequestDto) {
        return null;
    }

    @Override
    public List<ProductResponseDto> getByPaging(Pageable pageable) {
        return null;
    }
}
