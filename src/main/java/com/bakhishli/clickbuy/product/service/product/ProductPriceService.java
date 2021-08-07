package com.bakhishli.clickbuy.product.service.product;

import com.bakhishli.clickbuy.product.domain.enums.MoneyType;

import java.math.BigDecimal;

public interface ProductPriceService {
    BigDecimal getByMoneyType(String id, MoneyType moneyType);
}
