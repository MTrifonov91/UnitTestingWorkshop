package edu.studying.junit.presentation.a.basic.annotations;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicAnnotationsExampleTest {

    static BasicAnnotationsExample basicAnnotationsExample;

    @BeforeAll
    // @BeforeAll annotation Denotes that the annotated method should be executed before all
    // @Test, @RepeatedTest, @ParameterizedTest, and @TestFactory methods in the current class
    // Method annotated with this annotation must be static
    public static void setUpBeforeClass() {
        basicAnnotationsExample = new BasicAnnotationsExample();
        System.out.println("Before All step executed, class under test instantiated: " + basicAnnotationsExample);
    }

    @BeforeEach
    // @BeforeEach annotation is used to signal that the annotated method should be executed before each
    // @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, and @TestTemplate method in the current test class
    void setUp(TestInfo testInfo) {
        System.out.println("Test " + testInfo.getDisplayName() + " started.");
    }

    @DisplayName("String concatenation without spaces")
    // @DisplayName annotation is used to provide a custom name for the test class and test methods
    @Test
    void concat_withValidData() {
        // given
        String first = "a";
        String second = "b";
        String third = "c";
        String expectedResult = "abc";

        // when
        var actualResult = basicAnnotationsExample.concat(first, second, third);

        // then
        assertEquals(expectedResult, actualResult);
    }

//    @Disabled
    // @Disabled annotation is used to disable a test class or a test method
    @RepeatedTest(value = 10, failureThreshold = 2)
    @DisplayName("String concatenation with spaces in between arguments")
    void concatWithSpace_withValidData() {
        // given
        String first = "a";
        String second = "b";
        String third = "c";
        String expectedResult = "a b c";

        // when
        var actualResult = basicAnnotationsExample.concatWithSpace(first, second, third);

        // then
        assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    // @AfterEach annotation is used to signal that the annotated method should be executed after each
    // @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, and @TestTemplate method in the current test class
    public void tearDown(TestInfo testInfo) {
        System.out.println("Test " + testInfo.getDisplayName() + " finished");
    }

    @AfterAll
    // @AfterAll annotation Denotes that the annotated method should be executed after all
    // @Test, @RepeatedTest, @ParameterizedTest, and @TestFactory methods in the current class
    // Method annotated with this annotation must be static
    public static void tearDownAfterClass() {
        System.out.println("AfterAll, class object: " + basicAnnotationsExample);
        basicAnnotationsExample = null;
        System.out.println("class object after nullification: " + basicAnnotationsExample);
    }
}