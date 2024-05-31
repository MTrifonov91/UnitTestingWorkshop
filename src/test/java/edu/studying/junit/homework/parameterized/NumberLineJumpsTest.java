package edu.studying.junit.homework.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

// test class to test NumberLineJumps.class method
class NumberLineJumpsTest {

    // TODO write a parameterized test for kangaroo() method via "@MethodSource"
    @ParameterizedTest
    @MethodSource("params")
    void testKangaroo(int x1, int v1, int x2, int v2, String result) {
        assertEquals(result, NumberLineJumps.kangaroo(x1, v1, x2, v2));
    }

    public static Collection<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {1, 2, 2, 1, "YES"},
                {150, 10, 100, 6, "NO"},
                {9, 10, 11, 12, "NO"},
                {500, 300, 1100, 150, "YES"},
                {1500, 100, 2000, 80, "YES"}
        });
    }

}