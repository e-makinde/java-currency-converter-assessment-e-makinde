package com.codingblackfemales;

public interface CurrencyConverter {
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount);
    
    public String[] getCurrencyCodes();

    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode);
}