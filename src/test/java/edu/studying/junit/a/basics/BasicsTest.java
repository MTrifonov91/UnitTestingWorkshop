package edu.studying.junit.a.basics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// test class to test Basics.class methods
class BasicsTest {

    // declare the instance of class under test
    private Basics basicTests;

    // initialize the instance for every test
    @BeforeEach
    public void setup() {
        basicTests = new Basics();
    }

    // test the compare() method for case when 1st number is bigger
    @Test
    public void compareTwoAndOne() {
        // given
        int a = 2;
        int b = 1;
        int expectedValue = 1;

        //when
        int actualValue = basicTests.compare(a, b);

        // then
        assertEquals(expectedValue, actualValue);
    }

    // test the compare() method for case when 1st number is smaller
    @Test
    @DisplayName("First number is less than the second")
    public void compareTwoAndThree() {
        int value = basicTests.compare(2, 3);
        assertEquals(-1, value);
    }

    // test the compare() method for case when both numbers are equal
    @Test
    @DisplayName("First number is equal to the second")
    public void compareTwoAndTwo() {
        int value = basicTests.compare(2, 2);
        assertEquals(0, value);
    }

    // test the max() method
    @Test
    @DisplayName("Array max number")
    public void arrayMax() {
        int[] array = {5, 8, 3, 9, 1, 6};
        assertEquals(9, basicTests.max(array));
    }

    // test the sortArray() method
    @Test
    @DisplayName("Array sorted")
    public void sortArray() {
        int[] array = {5, 8, 3, 9, 1, 6};
        basicTests.sortArray(array);
        assertArrayEquals(new int[]{1, 3, 5, 6, 8, 9}, array);
    }

    // test the "reverseString()" method
    @Test
    public void reverseStringTest() {
        String expectedString = "olleH";
        assertEquals(expectedString, basicTests.reverseString("Hello"));
    }
}