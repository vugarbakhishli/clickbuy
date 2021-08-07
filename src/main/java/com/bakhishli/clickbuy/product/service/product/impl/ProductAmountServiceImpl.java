package com.bakhishli.clickbuy.product.service.product.impl;

import com.bakhishli.clickbuy.product.service.product.ProductAmountService;
import org.springframework.stereotype.Service;

@Service
public class ProductAmountServiceImpl implements ProductAmountService {

    @Override
    public Integer getByProductId(String id) {
        return 1;
    }
}
