package com.codingblackfemales;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Currencies currencies = new CurrenciesGBP();
    static BasicCurrencyConverter basicCurrencyConverter = new BasicCurrencyConverter(currencies);
    static String[] currencyCodesArray = basicCurrencyConverter.getCurrencyCodes();
    static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {

        String sourceCurrencyCode = requestUserCurrencyCode(true);
        String destinationCurrencyCode = requestUserCurrencyCode(false);

        System.out.println("You have chosen to convert from " + sourceCurrencyCode + " to " + destinationCurrencyCode + ".");

        System.out.println("Provide the amount (in "+ sourceCurrencyCode + ") to be converted to " + destinationCurrencyCode);
        double amount = Double.parseDouble(scanner.nextLine());

        System.out.println(basicCurrencyConverter.convertCurrency(sourceCurrencyCode, destinationCurrencyCode, amount));
    }



    public static boolean checkValueInArray(String value, String[] array) {
        boolean valueInArray = Arrays.asList(array).contains(value);
        return valueInArray;
    }



    // Request and validate user input for currency codes.
    public static String requestUserCurrencyCode(boolean sourceCode) {


        // Select appropriate message for source code and destination code input prompt.
        String message1 = (sourceCode == true) ? "What currency do you have? " : "What currency are you converting to? ";

        
        System.out.println(message1 + "Press the \"Enter\" key for a list of available currency codes.");
        String currencyCode = scanner.nextLine();
        currencyCode = currencyCode.toUpperCase();


        // Validate the users' input. If unacceptable, print the list of available codes and prompt the user to update their choice until they choose correctly.
        while (currencyCode == "" || checkValueInArray(currencyCode, currencyCodesArray) == false) {
            System.out.println("Available currencies are " + Arrays.toString(currencyCodesArray));
            System.out.println("Please try again. " + message1);
            currencyCode = scanner.nextLine();
            currencyCode = currencyCode.toUpperCase();
        } 


        System.out.println("You have selected " + currencyCode);
        
        return currencyCode;

    }
}
