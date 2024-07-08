package edu.studying.junit.presentation.b.advanced.annotations;

import java.util.Collections;
import java.util.List;

public class AdvancedAnnotationsExample {

    public String trimAllSpaces(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        } else {
            return str.replaceAll("\\s+", " ");
        }
    }

    public String reverseString(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    public int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Number must be non-negative");
        return n <= 1 ? 1 : n * factorial(n - 1);
    }

    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public Integer findMax(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) return null;
        return Collections.max(numbers);
    }

    public Double calculateAverage(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return null;
        }
        double sum = 0;
        int count = 0;
        for (Double number : numbers) {
            if (number != null) {
                sum += number;
                count++;
            }
        }
        return count > 0 ? sum / count : null;
    }

}
