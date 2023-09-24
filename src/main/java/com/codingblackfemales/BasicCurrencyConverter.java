package com.codingblackfemales;


public class BasicCurrencyConverter implements CurrencyConverter {

    Currencies currencies;

    String[] currencyCodes;
    double conversion;
    

    // Constructor
    public BasicCurrencyConverter(Currencies currencies) {
        // Update Currencies object to access required exchange rates
        this.currencies = currencies;
    }


    // Method to return final converted amount
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
        // Amount cannot be a minus vlue
        if (amount < 0) {
            return 0;
        }
        // In all other instances, return converted amount.
        conversion = this.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode) * amount;
        return conversion;
    }


    // Retrieve all available codes (keys) from hashmap.
    public String[] getCurrencyCodes(){ 
        currencyCodes = currencies.getAllExchangeRates().keySet().toArray(new String[0]);
        return currencyCodes;
    }


    // Calculate exchange rate between two currencies.
    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) {
        // If the source or destination currency code are not available then return 0.
        if (this.getCurrencyExchangeRate(destinationCurrencyCode)==0 || this.getCurrencyExchangeRate(sourceCurrencyCode) == 0) {
            return 0;
        } else {
            double exchangeRate = this.getCurrencyExchangeRate(destinationCurrencyCode)/this.getCurrencyExchangeRate(sourceCurrencyCode);
            return exchangeRate;
        }
    }


    // Return exchange rate of individial currency.
    public double getCurrencyExchangeRate(String currencyCode) {
        Double exchangeRate = currencies.getAllExchangeRates().get(currencyCode);
        return exchangeRate == null ? 0:exchangeRate; // ternary operator return 0 for null value. before colon = if cond, after = else cond
    }

}