package com.codingblackfemales;

public class BasicCurrencyConverter implements CurrencyConverter {
    
    // Create object to acess hashmap in CurrenciesGBP class.
    CurrenciesGBP currenciesGBP = new CurrenciesGBP();

    // Constructor
    public BasicCurrencyConverter() {
    }

    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
        double conversion = this.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode) * amount;
        return conversion;
    }

    
    public String[] getCurrencyCodes(){
        // Fetch keys (currency codes) from exchangeRates hashmap and convert to array.
        String[] currencyCodes = currenciesGBP.exchangeRates.keySet().toArray(new String[0]);
        return currencyCodes;
    }


    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) {
        // Fetch the values for the corresponding currency code
        double sourceCurrencyValue = currenciesGBP.exchangeRates.get(sourceCurrencyCode);
        double destinationCurrencyValue = currenciesGBP.exchangeRates.get(destinationCurrencyCode);

        // Logic to calculate exchange rate
        double exchangeRate = destinationCurrencyValue/sourceCurrencyValue;
        return exchangeRate;
    }
}