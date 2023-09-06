package com.codingblackfemales;


public class BasicCurrencyConverter implements CurrencyConverter {
    Currencies currencies = new CurrenciesGBP();
    String[] currencyCodes;
    double conversion;
    
    // Constructor
    public BasicCurrencyConverter(Currencies currencies) {
        this.currencies = currencies;
        
    }

    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
        
        if (amount < 0) {
            return 0;
        } 

        conversion = this.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode) * amount;
        return conversion;
    }

    public String[] getCurrencyCodes(){ 
        currencyCodes = currencies.getAllExchangeRates().keySet().toArray(new String[0]);

        return currencyCodes;
    }

    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) {
         // Logic to calculate exchange rate
        if (this.getCurrencyExchangeRate(destinationCurrencyCode)==0 || this.getCurrencyExchangeRate(sourceCurrencyCode) == 0) {
            return 0;
        } else {
            double exchangeRate = this.getCurrencyExchangeRate(destinationCurrencyCode)/this.getCurrencyExchangeRate(sourceCurrencyCode);
            return exchangeRate;
        }
    }

    public double getCurrencyExchangeRate(String currencyCode) {
        Double exchangeRate = currencies.getAllExchangeRates().get(currencyCode);
        return exchangeRate == null ? 0:exchangeRate; // ternary operator return 0 for null value. before colon = if cond, after = else cond
    }

}