package edu.studying.junit.presentation.g.junitassertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JunitAssertionsExampleTest {

    JunitAssertionsExample example;

    // initialising a new class under test object before each test
    @BeforeEach
    void setUp() {
        example = new JunitAssertionsExample();
    }

    @Test
    void testAssertEquals() {
        // Given/Arrange
        double expected = 3.33;
        double delta = 0.01;
        int inputDivident = 10;
        int inputDivisor = 3;

        // When/Act
        double actual = example.divide(inputDivident, inputDivisor);

        // Then/Assert
        assertEquals(expected, actual, delta, "Result of the division should be " + expected + " with approximation of " + delta);
    }

    @Test
    void testAssertNotEquals() {
        assertNotEquals(10, 1);
    }

    @Test
    void testArrayEquals() {
        String[] expected = {"a", "b", "c"};
        String[] actual = {"a", "b", "c"};

        assertArrayEquals(expected, actual);
    }

    @Test
    void testLinesMatches() {
        // Input data
        List<String> actualLines = example.formatText(Arrays.asList(
                "Hello, World!",
                "JUnit 5 is awesome!",
                "Testing with assertLinesMatch",
                "This line will be skipped",
                "Matching line after skipping"
        ));

        // Expected output pattern
        List<String> expectedLines = Arrays.asList(
                "Formatted: Hello, World!",
                "Formatted: JUnit \\d is awesome!", // using a regex for the number
                "Formatted: Testing with assertLinesMatch",
                ">>>>",                             // symbol used to skip line comparing until the next matching one
                "Formatted: Matching line after skipping"
        );


        // Using assertLinesMatch to compare actual and expected lines
        assertLinesMatch(expectedLines, actualLines);
    }

    @Test
    void testIterableEquals() {
        List<Integer> expectedList = Arrays.asList(1, 2, 3);
        Set<Integer> actualList = new HashSet<>(Arrays.asList(1, 2, 3, 1, 2, 3, 1, 2, 3, 1));

        // assertIterableEquals() will compare any "iterable" based on its internal values
        assertIterableEquals(expectedList, actualList);
    }

    @Test
    void testAssertNull() {
        example = null;
        assertNull(example);
    }

    @Test
    void testAssertNotNull() {
        assertNotNull(example);
    }

    @Test
    void testAssertTrue() {
        assertTrue(example.isIbanValid("DE41120300000000717777"));
    }

    @Test
    void testAssertFalse() {
        assertFalse(example.isIbanValid("MD41120300000000717777"));
    }

    @Test
    void testAssertSame() {
        JunitAssertionsExample example1 = example;
        assertSame(example1, example);
    }

    @Test
    void testAssertNotSame() {
        JunitAssertionsExample example2 = new JunitAssertionsExample();
        assertNotSame(example2, example);
    }

    @Test
    void testAssertThrows() {
        assertThrows(IllegalArgumentException.class, () -> example.divide(1, 0));
    }

    @Test
    void testAssertDoesNotThrow() {
        assertDoesNotThrow(() -> example.divide(10, 100));
    }

    @Test
    void testFail() {
        fail("Method not implemented yet");
    }

}