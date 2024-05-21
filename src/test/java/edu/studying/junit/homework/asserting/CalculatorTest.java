package edu.studying.junit.homework.asserting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setupCalc() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test add method")
    void testAdd() {
        //TODO: Write an assertEquals assertion to test the add() method
    }

    @Test
    @DisplayName("Test subtract method")
    void testSubtract() {
        //TODO: Write an assertNotEquals assertion to test the subtract() method
    }

    @Test
    @DisplayName("Test multiply method")
    void testMultiply() {
        //TODO: Write an assertArrayEquals assertion to test the multiply() method
    }

    @Test
    @DisplayName("Test divide method with zero divisor")
    void testDivideWithZeroDivisor() {
        //TODO: Write an assertIterableEquals assertion to test the divide() method with zero divisor
    }

    @Test
    @DisplayName("Test getEvenNumbers method with all even numbers")
    void testGetEvenNumbersWithAllEvenNumbers() {
        //TODO: Write a assertTrue assertion to test the getEvenNumbers method with all even numbers
    }

    @Test
    @DisplayName("Test getEvenNumbers method with no even numbers")
    void testGetEvenNumbersWithNoEvenNumbers() {
        //TODO: Write an assertFalse assertion to test the getEvenNumbers method with no even numbers
    }

    @Test
    @DisplayName("Test add method with same inputs")
    void testAddWithSameInputs() {
        //TODO: Write an assertSame assertion to test the add method with same inputs
    }

    @Test
    @DisplayName("Test add method with different inputs")
    void testAddWithDifferentInputs() {
        //TODO: Write an assertNotSame assertion to test the add method with different inputs
    }

    @Test
    @DisplayName("Test divide method with zero divisor throws exception")
    void testDivideWithZeroDivisorThrowsException() {
        //TODO: Write an assertThrows assertion to test that the divide method throws an exception with zero divisor
    }

    @Test
    @DisplayName("Test divide method with non-zero divisor does not throw exception")
    void testDivideWithNonZeroDivisorDoesNotThrowException() {
        //TODO: Write an assertDoesNotThrow assertion to test that the divide method does not throw an exception with non-zero divisor
    }

    @Test
    @DisplayName("Test fail assertion")
    void testFailAssertion() {
        //TODO: Write a fail assertion to intentionally fail the test with message
    }
}
