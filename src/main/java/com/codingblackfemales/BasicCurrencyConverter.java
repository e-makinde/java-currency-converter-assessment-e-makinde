package com.codingblackfemales;

public class BasicCurrencyConverter implements CurrencyConverter {
    CurrenciesGBP currenciesGBP = new CurrenciesGBP();

    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
        double conversion = this.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode) * amount;
        return conversion;
    }

    public String[] getCurrencyCodes(){
        String[] currencyCodes = currenciesGBP.exchangeRates.keySet().toArray(new String[0]);
        return currencyCodes;
    }

    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) {
        double sourceCurrencyValue = currenciesGBP.exchangeRates.get(sourceCurrencyCode);
        double destinationCurrencyValue = currenciesGBP.exchangeRates.get(destinationCurrencyCode);

        double exchangeRate = destinationCurrencyValue/sourceCurrencyValue;
        return exchangeRate;
    }
}