package edu.studying.junit.homework.asserting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    public static String reverseString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static String removeVowels(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.replaceAll("[aeiouAEIOU]", "");
    }

    public static List<String> splitAndRemoveEmptyStrings(String str) {
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }
        return Arrays.stream(str.split(","))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }
}
