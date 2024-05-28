package edu.studying.junit.c.exceptions.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// test class to test Cashier.class methods
class CashierTest {

    // write a test for "validateTransaction()" method on IllegalArgumentException thrown path
    @Test
    public void validateTransactionThrowsIllegalArgument() {
        // write an assertThrows() assertion with IllegalArgumentException
        assertThrows(IllegalArgumentException.class
                , () -> Cashier.validateTransaction("USD", 10));
    }

    //TODO write a test for "validateTransaction()" method
    // on InvalidTransactionAmountException thrown path
    // write an assertThrows() assertion with InvalidTransactionAmountException
    @Test
    public void amountIsValidThrowsInvalidAmountException() {
        // write an assertThrows() assertion with InvalidTransactionAmountException
        assertThrows(InvalidTransactionAmountException.class
                , () -> Cashier.validateTransaction("EUR", -10));
    }

}