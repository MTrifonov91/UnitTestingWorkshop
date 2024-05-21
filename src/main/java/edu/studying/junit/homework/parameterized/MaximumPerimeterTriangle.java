package edu.studying.junit.homework.parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of stick lengths, use of them to construct a non-degenerate triangle with
 * the maximum possible perimeter. Return an array of the lengths of its sides as:
 * 3 integers in non-decreasing order.
 * <p>
 * If there are several valid triangles having the maximum perimeter:
 * <p>
 * Choose the one with the longest maximum side.
 * If more than one has that maximum, choose from them the one with the longest minimum side.
 * If more than one has that maximum as well, print any one them.
 * <p>
 * If no non-degenerate triangle exists, return [-1]
 * <p>
 * A degenerate triangle is: https://en.wikipedia.org/wiki/Degeneracy_(mathematics)
 */
// class under test
public class MaximumPerimeterTriangle {

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        sticks.sort(Collections.reverseOrder());
        for (int i = 0; i <= sticks.size() - 3; i++) {
            int a = sticks.get(i);
            int b = sticks.get(i + 1);
            int c = sticks.get(i + 2);
            if (a < b + c) {
                return Arrays.asList(c, b, a);
            }
        }
        return List.of(-1);
    }
}
