package com.codingblackfemales;

import java.util.HashMap;

public class CurrenciesJPY {
    protected HashMap<String, Double> exchangeRates;

    public CurrenciesJPY() {
        this.exchangeRates = new HashMap<String, Double>() {
            {
                put("GBP", 0.0054);
                put("EUR", 0.0063);
                put("USD", 0.0069);
                put("JPY", 1.0);
            }
        };
    }

    public HashMap<String, Double> getAllExchangeRates() {
        return this.exchangeRates;
    }
}
