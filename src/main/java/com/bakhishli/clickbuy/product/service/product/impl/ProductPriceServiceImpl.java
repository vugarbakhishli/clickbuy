package com.bakhishli.clickbuy.product.service.product.impl;

import com.bakhishli.clickbuy.product.domain.enums.MoneyType;
import com.bakhishli.clickbuy.product.service.product.ProductPriceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {
    @Override
    public BigDecimal getByMoneyType(String id, MoneyType moneyType) {
        return BigDecimal.TEN;
    }
}
