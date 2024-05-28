package edu.studying.junit.homework.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
// class to test MaximumPerimeterTriangle.class method
class MaximumPerimeterTriangleTest {

    // TODO write a parameterized test for maximumPerimeterTriangle() method via "@MethodSource"
    @ParameterizedTest()
    @MethodSource("providedLists")
    void maximumPerimeterTriangle(List<Integer> inputList, List<Integer> expectedList) {
        assertEquals(expectedList, MaximumPerimeterTriangle.maximumPerimeterTriangle(inputList));
    }

    static Collection<Object[]> providedLists() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(1, 2, 3, 4, 5, 10), Arrays.asList(3, 4, 5)},
                {Arrays.asList(1, 2, 3, 4, 5, 8), Arrays.asList(4, 5, 8)},
                {Arrays.asList(3, 9, 2, 15, 3), Arrays.asList(2, 3, 3)},
                {Arrays.asList(1, 10, 1), List.of(-1)}
        });
    }

}