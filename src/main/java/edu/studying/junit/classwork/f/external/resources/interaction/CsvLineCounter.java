package edu.studying.junit.classwork.f.external.resources.interaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// class under test
public class CsvLineCounter {

    // method under test
    // method takes a path to a file as a parameter and returns the number of lines in the file
    public static Long countLinesFromFile(Path filePath) {
        try (var lines = Files.lines(filePath)) {
            return lines.count();
        } catch (IOException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    // method under test
    // method takes a path to a file as a parameter and returns the number of lines in the file
    public static Long countCharactersInFile(Path filePath) {
        Long characterCount = 0L;

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                characterCount++;
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        return characterCount;
    }
}
