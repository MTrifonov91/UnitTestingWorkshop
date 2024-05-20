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
    @DisplayName("First number is bigger than the second")
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

    //TODO test the compare() method for case when 1st number is smaller


    //TODO test the compare() method for case when both numbers are equal


    // test the max() method on path b
    @Test
    @DisplayName("Array max number")
    public void arrayMax() {
        int[] array = {5, 8, 3, 9, 1, 6};
        assertEquals(9, basicTests.max(array));
    }

    //TODO test the max() method on path a


    //TODO test the sortArray() method


    //TODO test the "reverseString()" method

}