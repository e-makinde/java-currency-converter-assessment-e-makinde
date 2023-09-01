package com.codingblackfemales;

import java.util.HashMap;

public class CurrenciesUSD {
    protected HashMap<String, Double> exchangeRates;

    public CurrenciesUSD() {
        this.exchangeRates = new HashMap<String, Double>() {
            {
                put("GBP", 0.79);
                put("EUR", 0.91);
                put("USD", 1.0);
                put("JPY", 145.84);
            }
        };
    }

    public HashMap<String, Double> getAllExchangeRates() {
        return this.exchangeRates;
    }
}
