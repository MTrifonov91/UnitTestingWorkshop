package edu.studying.junit.c.exceptions.testing;
// custom exception
public class InvalidTransactionAmountException extends RuntimeException{

    public InvalidTransactionAmountException(String message) {
        super(message);
    }
}
