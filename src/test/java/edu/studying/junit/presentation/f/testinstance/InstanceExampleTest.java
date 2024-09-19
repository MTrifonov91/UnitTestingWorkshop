package edu.studying.junit.presentation.f.testinstance;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Timeout;

// PER_METHOD is the default parameter
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("development")
class InstanceExampleTest {

    private int result = 5;

    @Test
    @Tag("feature-1")
        // @Tag annotation is used for filtering the test cases based on the given criteria like characteristics, purpose, and features
    void test_substract() {
        System.out.println(result);
        result = 1;
        System.out.println(result);
    }

    @Test
    void test_add() {
        System.out.println(result);
        result = 2;
        System.out.println(result);
    }

    @Test
    @Timeout(3)
        // @Timeout annotation is used to define a timeout for a method or all testable methods within one class and its @Nested classes.
        // This annotation may also be used on lifecycle methods annotated with @BeforeAll, @BeforeEach, @AfterEach, or @AfterAll.
    void test_timeout() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(result);
    }
}