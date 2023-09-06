package com.codingblackfemales;

import java.util.HashMap;

public class CurrenciesGBP implements Currencies {
    protected HashMap<String, Double> exchangeRates;

    public CurrenciesGBP() {
        this.exchangeRates = new HashMap<String, Double>() {
            {
                put("GBP", 1.0);
                put("EUR", 1.16);
                put("USD", 1.29);
                put("JPY", 181.78);
                put("NGN", 1020.26d);
                put("JMD", 200.13d);
                put("XCD", 3.49d);
            }
        };
    }

    public HashMap<String, Double> getAllExchangeRates() {
        return this.exchangeRates;
    }

    
}
