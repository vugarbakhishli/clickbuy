package com.bakhishli.clickbuy.product.service.product.impl;

import com.bakhishli.clickbuy.product.domain.enums.MoneyType;
import com.bakhishli.clickbuy.product.service.product.ProductDeliveryService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductDeliveryServiceImpl implements ProductDeliveryService {

    @Override
    public String getDeliveryDetails(String id) {
        // TODO
        return "Tomorrow";
    }

    @Override
    public Boolean freeDeliveryCheck(String id, BigDecimal price, MoneyType moneyType) {
        // TODO
        return price.compareTo(BigDecimal.ONE) >= 0;
    }
}
