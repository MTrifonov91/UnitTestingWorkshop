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
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @DisplayName("Test subtract method")
    void testSubtract() {
        //TODO: Write an assertNotEquals assertion to test the subtract() method
        assertNotEquals(5, calculator.subtract(3, 2));
    }

    @Test
    @DisplayName("Test multiply method")
    void testMultiply() {
        //TODO: Write an assertArrayEquals assertion to test the multiply() method
        assertArrayEquals(new int[]{2, 4, 6}, new int[]{calculator.multiply(1, 2), calculator.multiply(2, 2), calculator.multiply(3, 2)});
    }

    @Test
    @DisplayName("Test divide method with zero divisor")
    void testDivideWithZeroDivisor() {
        //TODO: Write an assertIterableEquals assertion to test the divide() method with zero divisor
        assertIterableEquals(List.of(2, 4), List.of(calculator.divide(8, 4), calculator.divide(12, 3)));
    }

    @Test
    @DisplayName("Test getEvenNumbers method with all even numbers")
    void testGetEvenNumbersWithAllEvenNumbers() {
        //TODO: Write a assertTrue assertion to test the getEvenNumbers method with all even numbers
        assertEquals(4, calculator.getEvenNumbers(new int[]{2, 4, 6, 8}).length);
    }

    @Test
    @DisplayName("Test getEvenNumbers method with no even numbers")
    void testGetEvenNumbersWithNoEvenNumbers() {
        //TODO: Write an assertFalse assertion to test the getEvenNumbers method with no even numbers
        assertFalse(calculator.getEvenNumbers(new int[]{1, 3, 5}).length > 0);
    }

    @Test
    @DisplayName("Test add method with same inputs")
    void testAddWithSameInputs() {
        //TODO: Write an assertSame assertion to test the add method with same inputs
        assertSame(calculator.add(5, 5), calculator.add(5, 5));
    }

    @Test
    @DisplayName("Test add method with different inputs")
    void testAddWithDifferentInputs() {
        //TODO: Write an assertNotSame assertion to test the add method with different inputs
        assertNotSame(calculator.add(5, 5), calculator.add(5, 6));
    }

    @Test
    @DisplayName("Test divide method with zero divisor throws exception")
    void testDivideWithZeroDivisorThrowsException() {
        //TODO: Write an assertThrows assertion to test that the divide method throws an exception with zero divisor
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @Test
    @DisplayName("Test divide method with non-zero divisor does not throw exception")
    void testDivideWithNonZeroDivisorDoesNotThrowException() {
        //TODO: Write an assertDoesNotThrow assertion to test that the divide method does not throw an exception with non-zero divisor
        assertDoesNotThrow(() -> calculator.divide(10, 2));
    }

    @Test
    @DisplayName("Test fail assertion")
    void testFailAssertion() {
        //TODO: Write a fail assertion to intentionally fail the test with message
        fail("This test case is intentionally failing");
    }
}
