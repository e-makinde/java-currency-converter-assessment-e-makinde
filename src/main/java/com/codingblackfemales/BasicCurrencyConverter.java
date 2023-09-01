package com.codingblackfemales;


public class BasicCurrencyConverter implements CurrencyConverter {
    String [] supportedCurrencies = {"GBP", "USD", "EUR", "JPY"};

    CurrenciesGBP gbp = new CurrenciesGBP();
    CurrenciesEUR eur = new CurrenciesEUR();
    CurrenciesUSD usd = new CurrenciesUSD();
    CurrenciesJPY jpy = new CurrenciesJPY();
    
    // Constructor
    public BasicCurrencyConverter(Currencies currencies) {
    }

    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
    	    return getExchangeRate(sourceCurrencyCode, destinationCurrencyCode) * amount;
    
    }

    public String[] getCurrencyCodes(){ 
        return supportedCurrencies;
    }

    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) {
            switch (sourceCurrencyCode) {
            case "GBP":
                return gbp.getAllExchangeRates().get(destinationCurrencyCode);
            case "USD":
                return usd.getAllExchangeRates().get(destinationCurrencyCode) ;
            case "EUR":
                return eur.getAllExchangeRates().get(destinationCurrencyCode);
            case "JPY":
                return jpy.getAllExchangeRates().get(destinationCurrencyCode);
            default:
                return 0;
            }
    }
}