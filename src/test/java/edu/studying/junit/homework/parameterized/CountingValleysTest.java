package edu.studying.junit.homework.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

// class to test CountingValleys.class method
class CountingValleysTest {

    // TODO write a parameterized test for countingValleys() method via "@CsvSource"
    @ParameterizedTest
    @CsvSource({
            "UDDDUDUU, 1",
            "DDUUUUDD, 1",
            "DDUDUDUDUDUDUDUDUDDDDDDUUUUUUUUDDDUUU, 2"
    })
    void countingValleys(String path, int numberOfValleys) {
        assertEquals(numberOfValleys, CountingValleys.countingValleys(path.length(), path));
    }

}