package edu.studying.junit.presentation.b.advanced.annotations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedAnnotationsExampleTest {

    AdvancedAnnotationsExample advancedAnnotationsExample;

    @BeforeEach
    void setUp() {
        advancedAnnotationsExample = new AdvancedAnnotationsExample();
    }

    @ParameterizedTest(name = "Trim all spaces test")
    // @ParameterizedTest is used to run the same test method multiple times with different sets of input data
    @MethodSource("provideStringsForTrimAllSpaces")
        // @MethodSource is used for one or more factory methods that generate a stream of arguments.
        // method's name is provided as parameter
    void testTrimAllSpaces(String input, String expectedResult) {
        String actualResult = advancedAnnotationsExample.trimAllSpaces(input);

        assertEquals(expectedResult, actualResult);
    }


    @ParameterizedTest
    @ArgumentsSource(ReverseStringsProvider.class)
        // @ArgumentsSource - uses a Class as parameter of the input data source, the provider class must implement
        // JUnit's ArgumentsProvider interface
    void testReverseString(String input, String expectedResult) {
        String actualResult = advancedAnnotationsExample.reverseString(input);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Madam", "Racecar", "Civic", "Radar", "Kayak", "Rotator"})
        // @ValueSource - uses Type as parameter with data represented as an array
    void testIsPalindrome_True(String input) {
        assertTrue(advancedAnnotationsExample.isPalindrome(input));
    }

    @ParameterizedTest
    @EnumSource(FactorialTestCase.class)
        // @EnumSource - uses an Enum as parameter of the input data source, the Enum itself becomes a test case
    void testFactorial(FactorialTestCase testCase) {
        assertEquals(testCase.getExpected(), advancedAnnotationsExample.factorial(testCase.getInput()));
    }

    @ParameterizedTest
    @CsvSource({
            "2, true",
            "3, true",
            "4, false",
            "5, true",
            "16, false",
            "17, true",
            "18, false",
            "19, true",
            "20, false",
            "-1, false",
            "0, false",
            "1, false"
    })
        // @CsvSource is used for argument lists as comma-separated values,
        // can be used to provide any number of variables for the test for any amount of iterations
    void testIsPrime(int input, boolean expectedResult) {
        boolean actualResult = advancedAnnotationsExample.isPrime(input);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/find_max_test_data.csv", useHeadersInDisplayName = true)
        // @CsvFileSource uses a CSV file and takes as parameters file location and, additionally settings like:
        // useHeadersInDisplayName, ignoreLeadingAndTrailingWhitespace
        // can be used to provide any number of variables for the test for any amount of iterations
    void testFindMax(String input, String expectedResult) {
        List<Integer> inputList = parseNumbers(input);

        // Convert expected to Integer or null
        Integer expectedValue = expectedResult.equals("null") ? null : Integer.valueOf(expectedResult);

        Integer actualValue = advancedAnnotationsExample.findMax(inputList);

        assertEquals(expectedValue, actualValue);
    }

    @ParameterizedTest
    @EmptySource
        // @Empty source annotation is used for a single empty argument of type String, List, Set, Map, or arrays
    void testCalculateAverageWithEmptyList(List<Double> input) {
        System.out.println(input);
        Double result = advancedAnnotationsExample.calculateAverage(input);
        assertNull(result);
    }

    @ParameterizedTest
    @NullSource
        // @NullSource source annotation is used for a single null argument
    void testCalculateAverageWithNullList(List<Double> input) {
        System.out.println(input);
        Double result = advancedAnnotationsExample.calculateAverage(input);
        assertNull(result);
    }

    @ParameterizedTest
    @NullAndEmptySource
        // @NullAndEmptySource source annotation is used for a single null and then a single empty argument of type String, List, Set, Map, or arrays
    void testCalculateAverageWithNullAndEmptyList(List<Double> input) {
        System.out.println(input);
        Double result = advancedAnnotationsExample.calculateAverage(input);
        assertNull(result);
    }

    // Method to supply arguments for the parameterized test annotated with @MethodSource
    static Stream<Arguments> provideStringsForTrimAllSpaces() {
        return Stream.of(
                Arguments.of("hello  world", "hello world"),
                Arguments.of("   leading", " leading"),
                Arguments.of("trailing   ", "trailing "),
                Arguments.of("  in  between  ", " in between "),
                Arguments.of("\t\t tab\t", " tab "),
                Arguments.of("\nnew\nline\n", " new line "),
                Arguments.of("  ", " "),
                Arguments.of("", ""),
                Arguments.of("singleword", "singleword"),
                Arguments.of(null, null)
        );
    }

    // Class to supply arguments for the parameterized test annotated with @ArgumentsSource
    static class ReverseStringsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("hello", "olleh"),
                    Arguments.of("world", "dlrow"),
                    Arguments.of("", ""),
                    Arguments.of("A", "A"),
                    Arguments.of("Java Programming", "gnimmargorP avaJ"),
                    Arguments.of("12345", "54321"),
                    Arguments.of("  leading", "gnidael  "),
                    Arguments.of("trailing  ", "  gniliart"),
                    Arguments.of("  spaces  ", "  secaps  "),
                    Arguments.of("racecar", "racecar"),
                    Arguments.of("!@#$$#@!", "!@#$$#@!"),
                    Arguments.of(null, null)
            );
        }
    }

    // Enum to supply arguments for the parameterized test annotated with @EnumSource
    public enum FactorialTestCase {
        CASE_0(0, 1),
        CASE_1(1, 1),
        CASE_2(2, 2),
        CASE_3(3, 6),
        CASE_4(4, 24),
        CASE_5(5, 120),
        CASE_NEGATIVE(-1, IllegalArgumentException.class);

        private final int input;
        private final Object expected;

        FactorialTestCase(int input, Object expected) {
            this.input = input;
            this.expected = expected;
        }

        public int getInput() {
            return input;
        }

        public Object getExpected() {
            return expected;
        }
    }

    // Internal helper method for demo purposes in test annotated with @CsvFileSource
    private List<Integer> parseNumbers(String numbers) {
        if (numbers.equals("null") || numbers.isEmpty()) {
            return null;
        }
        return Arrays.stream(numbers.split(","))
                .map(Integer::valueOf)
                .toList();
    }
}

