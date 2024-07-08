package edu.studying.junit.classwork.b.parameterized;

import edu.studying.junit.classwork.b.parameterized.StudentScoreCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

// test class to test StudentScoreCalculator.class methods
class StudentScoreCalculatorTest {

    // declare an object of class under test
    private StudentScoreCalculator sc;

    // initialize class under test
    @BeforeEach
    public void initClass() {
        sc = new StudentScoreCalculator();
    }

    // write a @ParameterizedTest that uses a "method" as source of test data
    // provide valid data for Expected values for both paths (a and b)
    @ParameterizedTest
    // specify the data source method
    @MethodSource("testValuesAsObjects")
    // add test data as parameters to the test method
    public void studentScoreCalculatorRegularTestWithObjectsAsValues(int mathScore, int literacyScore, int expectedResult) {
        sc.calculateSATScore(mathScore, literacyScore);
        assertEquals(expectedResult, sc.getSatScore());
    }

    // write a @ParameterizedTest that uses a "method" as source of test data
    // provide valid data for Expected values for both paths (a and b)
    @ParameterizedTest
    // specify the data source method
    @MethodSource("testValuesFromStreams")
    // add test data as parameters to the test method
    public void studentScoreCalculatorRegularTestWithStreamsAsValues(int mathScore, int literacyScore, int expectedResult) {
        sc.calculateSATScore(mathScore, literacyScore);
        assertEquals(expectedResult, sc.getSatScore());
    }

    // method serving as source for test data, returning array objects with test values
    private static Object[] testValuesAsObjects() {
        return new Object[]{
                new Object[]{50, 50, 2500},
                new Object[]{-10, 50, -1},
                new Object[]{50, -1, -1},
                new Object[]{-1, -1, -1},
                new Object[]{150, 50, -1},
                new Object[]{50, 150, -1},
                new Object[]{150, 150, -1},
                new Object[]{0, 0, 0},
                new Object[]{100, 100, 10000}
        };
    }

    // method serving as source for test data, returning Stream of arguments with test values
    private static Stream<Arguments> testValuesFromStreams() {
        return Stream.of(
                Arguments.of(50, 50, 2500),
                Arguments.of(-10, 50, -1),
                Arguments.of(50, -1, -1),
                Arguments.of(-1, -1, -1),
                Arguments.of(150, 50, -1),
                Arguments.of(50, 150, -1),
                Arguments.of(150, 150, -1),
                Arguments.of(0, 0, 0),
                Arguments.of(100, 100, 10000)
        );
    }

    //TODO write a @ParameterizedTest for calculateMediumScore() method
    // that uses a "method" as source of test data
    // provide valid data for Expected values for both paths (a and b)
    @ParameterizedTest
    // specify the data source method
    @MethodSource("secondTestValuesAsObjects")
    // add test data as parameters to the test method
    public void mediumScoreCalculatorTestWithObjectsAsValues(int mathScore, int historyScore, int informaticsScore, int englishScore, int expectedResult) {
        sc.calculateMediumScore(mathScore, historyScore, informaticsScore, englishScore);
        assertEquals(expectedResult, sc.getMediumScore());
    }


    //TODO write a @ParameterizedTest for calculateMediumScore() method
    // that uses a "method" as source of test data
    // provide valid data for Expected values for both paths (a and b)
    //TODO write a @ParameterizedTest for calculateMediumScore() method
    // that uses a "method" as source of test data
    // provide valid data for Expected values for both paths (a and b)
    @ParameterizedTest
    // specify the data source method
    @MethodSource("secondTestValuesFromStreams")
    // add test data as parameters to the test method
    public void mediumScoreCalculatorTestWithValuesFromStreams(int mathScore, int historyScore, int informaticsScore, int englishScore, int expectedResult) {
        sc.calculateMediumScore(mathScore, historyScore, informaticsScore, englishScore);
        assertEquals(expectedResult, sc.getMediumScore());
    }

    // method serving as source for test data, returning array objects with test values
    private static Object[] secondTestValuesAsObjects() {
        return new Object[]{
                new Object[]{50, 50, 50, 50, 50},
                new Object[]{-10, 50, 50, 50, -1},
                new Object[]{50, 1010, 80, 50, -1},
                new Object[]{101, 100, 99, 98, -1},
                new Object[]{0, 0, 0, 0, 0},
                new Object[]{100, 100, 100, 100, 100}
        };
    }

    // method serving as source for test data, returning Stream of arguments with test values
    private static Stream<Arguments> secondTestValuesFromStreams() {
        return Stream.of(
                Arguments.of(50, 50, 50, 50, 50),
                Arguments.of(-10, 50, 50, 50, -1),
                Arguments.of(50, 1010, 80, 50, -1),
                Arguments.of(101, 100, 99, 98, -1),
                Arguments.of(0, 0, 0, 0, 0),
                Arguments.of(100, 100, 100, 100, 100)
        );
    }
}