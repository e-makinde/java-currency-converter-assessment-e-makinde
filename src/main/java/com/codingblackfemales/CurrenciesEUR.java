package com.codingblackfemales;

import java.util.HashMap;

public class CurrenciesEUR {
    protected HashMap<String, Double> exchangeRates;

    public CurrenciesEUR() {
        this.exchangeRates = new HashMap<String, Double>() {
            {
                put("GBP", 0.86);
                put("EUR", 1.0);
                put("USD", 1.09);
                put("JPY", 159.42);
            }
        };
    }

    public HashMap<String, Double> getAllExchangeRates() {
        return this.exchangeRates;
    }

    
}
