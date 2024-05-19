package edu.studying.junit.f.external.resources.interaction.testing;

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
}
