package edu.studying.junit.presentation.e.orders;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
// @TestClassOrder annotation is a type-level annotation that is used to configure a ClassOrderer for the @Nested test classes of the annotated test class.
class OrdersExampleTest {

    OrdersExample example;

    @BeforeEach
    void setUp() {
        example = new OrdersExample();
    }

    @Nested
    // @Nested annotation give the test writer more capabilities to express the relationship among several groups of tests.
    @Order(1)
    // @Order annotation indicates the order of tests execution on a given level
    class PrimaryTests {

        @Test
        @DisplayName("VIP test")
        @Order(1)
        public void testLeapYear_withLeapYearsData_ReturnsTrue() {
            assertTrue(example.isLeapYear(2024));
        }

        @Test
        @DisplayName("NOT VIP test")
        @Order(2)
        public void testisPerfectSquare_withPerfectSquares_ReturnsTrue() {
            assertTrue(example.isPerfectSquare(25));
        }

    }

    @Nested
    @Order(2)
    class SecondaryTests {

        @Test
        @DisplayName("VIP test")
        @Order(10)
        public void testLeapYear_withOrdinaryYearsData_ReturnsFalse() {
            assertFalse(example.isLeapYear(2023));
        }

        @Test
        @DisplayName("NOT VIP test")
        @Order(2)
        public void testisPerfectSquare_withPerfectSquares_ReturnsTrue() {
            assertFalse(example.isPerfectSquare(5));
        }

    }
}