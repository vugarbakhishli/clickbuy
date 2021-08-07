package com.bakhishli.clickbuy.product.domain.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum MoneyType {
    USD("$"),
    EUR,
    TL,
    AZN;

    String currencySymbol;
    public String getCurrencySymbol(){
        return currencySymbol;
    }
}
