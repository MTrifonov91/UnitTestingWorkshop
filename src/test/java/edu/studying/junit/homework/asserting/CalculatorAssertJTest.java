package edu.studying.junit.homework.asserting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CalculatorAssertJTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("Test add method")
    void testAdd() {
        //TODO: Write an isEqualTo() assertion to test the add method
        assertThat(calculator.add(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("Test subtract method")
    void testSubtract() {
        //TODO: Write an isNotEqualTo() assertion to test the subtract method
        assertThat(calculator.subtract(3, 2)).isNotEqualTo(5);
    }

    @Test
    @DisplayName("Test multiply method")
    void testMultiply() {
        //TODO: Write an containsExactly() assertion to test the multiply method
        assertThat(new int[]{calculator.multiply(1, 2), calculator.multiply(2, 2), calculator.multiply(3, 2)})
                .containsExactly(2, 4, 6);
    }

    @Test
    @DisplayName("Test divide method with zero divisor")
    void testDivideWithZeroDivisor() {
        //TODO: Write an isEqualTo() assertion to test the divide method with zero divisor
        assertThat(calculator.divide(8, 4)).isEqualTo(2);
        assertThat(calculator.divide(12, 3)).isEqualTo(4);
    }

    @Test
    @DisplayName("Test isEven method with odd number")
    void testIsEvenWithOddNumber() {
        //TODO: Write an isFalse() assertion to test the isEven method with odd number
        assertThat(calculator.isEven(3)).isFalse();
    }

    @Test
    @DisplayName("Test getEvenNumbers method with all even numbers")
    void testGetEvenNumbersWithAllEvenNumbers() {
        //TODO: Write a hasSize() assertion to test the getEvenNumbers method with all even numbers
        assertThat(calculator.getEvenNumbers(new int[]{2, 4, 6, 8})).hasSize(4);
    }

    @Test
    @DisplayName("Test getEvenNumbers method with no even numbers")
    void testGetEvenNumbersWithNoEvenNumbers() {
        //TODO: Write an isEmpty() assertion to test the getEvenNumbers method with no even numbers
        assertThat(calculator.getEvenNumbers(new int[]{1, 3, 5})).isEmpty();
    }

    @Test
    @DisplayName("Test add method with same inputs")
    void testAddWithSameInputs() {
        //TODO: Write an isSameAs() assertion to test the add method with same inputs
        assertThat(calculator.add(5, 5)).isSameAs(calculator.add(5, 5));
    }

    @Test
    @DisplayName("Test add method with different inputs")
    void testAddWithDifferentInputs() {
        //TODO: Write an isNotSameAs() assertion to test the add method with different inputs
        assertThat(calculator.add(5, 5)).isNotSameAs(calculator.add(5, 6));
    }

    @Test
    @DisplayName("Test divide method with zero divisor throws exception")
    void testDivideWithZeroDivisorThrowsException() {
        //TODO: Write an assertThatThrownBy() assertion to test that the divide method throws an exception with zero divisor
        assertThatThrownBy(() -> calculator.divide(10, 0)).isInstanceOf(ArithmeticException.class);
    }

    @Test
    @DisplayName("Test divide method with non-zero divisor does not throw exception")
    void testDivideWithNonZeroDivisorDoesNotThrowException() {
        //TODO: Write an assertThatCode() assertion to test that the divide method does not throw an exception with non-zero divisor
        assertThatCode(() -> calculator.divide(10, 2)).doesNotThrowAnyException();
    }
}
