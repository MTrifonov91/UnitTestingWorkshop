package edu.studying.junit.classwork.c.exceptions;

import java.util.Arrays;
import java.util.List;

// class under test
public class Cashier {

    // class variable
    // list of accepted currencies
    private static final List<String> acceptedCurrencies = Arrays.asList("EUR", "GBP");

    // method that takes a currency name and amount as parameters and returns
    // the amount if valid
    public static double validateTransaction(String currency, double amount) {

        if (currencyIsAccepted(currency) && amountIsValid(amount)) {
            return amount;
        }
        return -1;
    }

    // internal method that validates whether the entered currency is in the declared list
    private static boolean currencyIsAccepted(String currency) {
        // path a
        if (!acceptedCurrencies.contains(currency)) {
            throw new IllegalArgumentException("Currency " + currency + " not within accepted currencies list.");
        }
        // path b
        return true;
    }

    // internal method that validates whether the entered amount is more than 0
    private static boolean amountIsValid(double amount) {
        // path a
        if (amount < 0) {
            throw new InvalidTransactionAmountException("Transaction amount must be greater than 0");
        }
        // path b
        return true;
    }
}
