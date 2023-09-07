package com.codingblackfemales;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Currencies currencies = new CurrenciesGBP();
    static BasicCurrencyConverter basicCurrencyConverter = new BasicCurrencyConverter(currencies);
    static String[] currencyCodesArray = basicCurrencyConverter.getCurrencyCodes();
    static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("0.00");

        String sourceCurrencyCode = requestUserCurrencyCode(true);
        String destinationCurrencyCode = requestUserCurrencyCode(false);

        System.out.println("You have chosen to convert from " + sourceCurrencyCode + " to " + destinationCurrencyCode + ".");

        System.out.println("Provide the amount ,in "+ sourceCurrencyCode + ", to be converted to " + destinationCurrencyCode + ".");
        double amount = Double.parseDouble(scanner.nextLine());

        System.out.println(df.format(basicCurrencyConverter.convertCurrency(sourceCurrencyCode, destinationCurrencyCode, amount)) + destinationCurrencyCode);
    }



    public static boolean isValueInArray(String value, String[] array) {
        boolean isvalueInArray = Arrays.asList(array).contains(value);
        return isvalueInArray;
    }



    // Request and validate user input for currency codes.
    public static String requestUserCurrencyCode(boolean isSourceCurrencyCode) {
        String currencyCode;

        // Select appropriate message for source code and destination code input prompt.
        String message1 = (isSourceCurrencyCode == true) ? "What currency do you have? " : "What currency are you converting to? ";

        // Validate the users' input. If unacceptable, print the list of available codes and prompt the user to update their choice until they choose correctly.
        do {
            System.out.println(message1 + "Available currencies are " + Arrays.toString(currencyCodesArray));
            currencyCode = scanner.nextLine().toUpperCase();
        } while (currencyCode == "" || !isValueInArray(currencyCode, currencyCodesArray));

        System.out.println("You have selected " + currencyCode + ".");
        
        return currencyCode;

    }
}
