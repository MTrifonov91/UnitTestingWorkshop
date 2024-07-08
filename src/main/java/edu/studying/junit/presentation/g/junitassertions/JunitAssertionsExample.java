package edu.studying.junit.presentation.g.junitassertions;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class JunitAssertionsExample {

    // Method to generate a German IBAN
    public String generateGermanIBAN() {
        // StringBuilder for the IBAN
        StringBuilder iban = new StringBuilder("DE");

        // SecureRandom for generating random digits
        SecureRandom random = new SecureRandom();

        // Append 20 random digits to the IBAN
        for (int i = 0; i < 20; i++) {
            int digit = random.nextInt(10); // Generate a digit between 0 and 9
            iban.append(digit);
        }

        // Return the generated IBAN
        return iban.toString();
    }

    public boolean isIbanValid(String iban) {
        return iban.matches("^DE[0-9]{20}$");
    }

    public double divide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor must not be zero");
        }
        return dividend / divisor;
    }

    // Method to format a list of strings
    public List<String> formatText(List<String> lines) {
        List<String> formattedLines = new ArrayList<>();
        for (String line : lines) {
            formattedLines.add("Formatted: " + line);
        }
        return formattedLines;
    }

}
