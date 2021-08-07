package com.bakhishli.clickbuy.product.service.product;

import com.bakhishli.clickbuy.product.domain.enums.MoneyType;

import java.math.BigDecimal;

public interface ProductDeliveryService {
    String getDeliveryDetails(String id);
    Boolean freeDeliveryCheck(String id, BigDecimal price, MoneyType moneyType);
}
