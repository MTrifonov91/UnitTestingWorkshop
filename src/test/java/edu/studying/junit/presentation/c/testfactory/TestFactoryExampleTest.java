package edu.studying.junit.presentation.c.testfactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestFactoryExampleTest {

    TestFactoryExample testFactoryExample = new TestFactoryExample();
    List<TestCase> testCases;

    @BeforeEach
    void setUp() {
        // Defining test cases as a list of objects (simulating a Runtime test data generation)
        testCases = List.of(
                new TestCase(List.of(1, 2, 3), 6, "Sum of 1, 2, 3"),
                new TestCase(List.of(-1, -2, -3), -6, "Sum of -1, -2, -3"),
                new TestCase(List.of(0, 0, 0), 0, "Sum of 0, 0, 0"),
                new TestCase(List.of(100, 200, 300), 600, "Sum of 100, 200, 300"),
                new TestCase(List.of(), 0, "Sum of empty list"),
                new TestCase(List.of(5), 5, "Sum of single element list 5")
        );
    }


    @TestFactory
    // @TestFactory annotation is treated like @Test annotation but denotes that a method is a test factory for dynamic tests
    // the method should return a Stream of DynamicTest objects
    // Useful when input data is not known in Compile time and only appears in Runtime
    Stream<DynamicTest> dynamicTestsForSum() {
        // Generate dynamic tests
        return testCases.stream().map(testCase ->
                DynamicTest.dynamicTest(testCase.getDescription(), () -> {
                    System.out.println("Expected: " + testCase.getExpected() + " -> Actual: " + testFactoryExample.sum(testCase.getNumbers()));
                    assertEquals(testCase.getExpected(), testFactoryExample.sum(testCase.getNumbers()));
                })
        );
    }

    // Helper class that acts as a test case template and used to create test case object with specific data
    private static class TestCase {
        private final List<Integer> numbers;
        private final int expected;
        private final String description;

        public TestCase(List<Integer> numbers, int expected, String description) {
            this.numbers = numbers;
            this.expected = expected;
            this.description = description;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public int getExpected() {
            return expected;
        }

        public String getDescription() {
            return description;
        }
    }
}