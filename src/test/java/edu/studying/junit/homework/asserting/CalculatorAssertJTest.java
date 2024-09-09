package edu.studying.junit.homework.asserting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorAssertJTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("Test add method")
    void testAdd() {
        //TODO: Write an isEqualTo() assertion to test the add method

    }

    @Test
    @DisplayName("Test subtract method")
    void testSubtract() {
        //TODO: Write an isNotEqualTo() assertion to test the subtract method

    }

    @Test
    @DisplayName("Test multiply method")
    void testMultiply() {
        //TODO: Write an containsExactly() assertion to test the multiply method

    }

    @Test
    @DisplayName("Test divide method with zero divisor")
    void testDivideWithZeroDivisor() {
        //TODO: Write an isEqualTo() assertion to test the divide method with zero divisor

    }

    @Test
    @DisplayName("Test isEven method with odd number")
    void testIsEvenWithOddNumber() {
        //TODO: Write an isFalse() assertion to test the isEven method with odd number

    }

    @Test
    @DisplayName("Test getEvenNumbers method with all even numbers")
    void testGetEvenNumbersWithAllEvenNumbers() {
        //TODO: Write a hasSize() assertion to test the getEvenNumbers method with all even numbers

    }

    @Test
    @DisplayName("Test getEvenNumbers method with no even numbers")
    void testGetEvenNumbersWithNoEvenNumbers() {
        //TODO: Write an isEmpty() assertion to test the getEvenNumbers method with no even numbers

    }

    @Test
    @DisplayName("Test add method with same inputs")
    void testAddWithSameInputs() {
        //TODO: Write an isSameAs() assertion to test the add method with same inputs

    }

    @Test
    @DisplayName("Test add method with different inputs")
    void testAddWithDifferentInputs() {
        //TODO: Write an isNotSameAs() assertion to test the add method with different inputs

    }

    @Test
    @DisplayName("Test divide method with zero divisor throws exception")
    void testDivideWithZeroDivisorThrowsException() {
        //TODO: Write an assertThatThrownBy() assertion to test that the divide method throws an exception with zero divisor

    }

    @Test
    @DisplayName("Test divide method with non-zero divisor does not throw exception")
    void testDivideWithNonZeroDivisorDoesNotThrowException() {
        //TODO: Write an assertThatCode() assertion to test that the divide method does not throw an exception with non-zero divisor

    }
}
