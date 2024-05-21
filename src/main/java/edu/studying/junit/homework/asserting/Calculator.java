package edu.studying.junit.homework.asserting;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public boolean isEven(int a) {
        return a % 2 == 0;
    }

    public int[] getEvenNumbers(int[] numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                count++;
            }
        }

        int[] evenNumbers = new int[count];
        int index = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenNumbers[index++] = num;
            }
        }

        return evenNumbers;
    }
}
