package edu.studying.junit.classwork.f.external.resources.interaction;

import edu.studying.junit.classwork.f.external.resources.interaction.CsvLineCounter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

// test class to test CsvLineCounter.class methods
class CsvLineCounterTest {

    // write a test for countLinesFromFile() method for the happy path
    // using real file creation with try{} and finally{} (for file deletion)
    @Test
    void countLinesFromFile() throws IOException {

        // create the file for test
        File file = new File("./test.csv");
        try {
            // create test data to be written to file
            String csvData = "a,b,c\nd,e,f\ng";
            // write test data to file
            Files.write(file.toPath(), csvData.getBytes());

            // run the method and collect its return
            long actualLines = CsvLineCounter.countLinesFromFile(file.toPath());

            // write an assertEquals() assertion
            assertEquals(3, actualLines);
        } finally {
            // delete the test file
            Files.delete(file.toPath());
        }
    }

    // write a test for countLinesFromFile() method for the happy path
    // using junit @TempDir annotation to create a temporary file
    @Test
    void countLinesFromFileUsingTemporaryDir(@TempDir Path tempDir) throws IOException {

        // create the file for test
        Path tempFile = Files.createTempFile(tempDir, "test", ".txt");

        // create test data to be written to file
        String csvData = "a,b,c\nd,e,f\ng";
        // write test data to file
        Files.write(tempFile, csvData.getBytes());

        // run the method and collect its return
        long actualLines = CsvLineCounter.countLinesFromFile(tempFile);

        // write an assertEquals() assertion
        assertEquals(3, actualLines);
    }

    //TODO write a test for countCharactersInFile() method for the happy path
    // using junit @TempDir annotation to create a temporary file
    @Test
    void countCharsFromFileUsingTemporaryDir(@TempDir Path tempDir) throws IOException {

        // create the file for test
        Path tempFile = Files.createTempFile(tempDir, "test", ".txt");

        // create test data to be written to file
        String csvData = "a,b,c\nd,e,f\ng";
        // write test data to file
        Files.write(tempFile, csvData.getBytes());

        // run the method and collect its return
        long actualLines = CsvLineCounter.countCharactersInFile(tempFile);

        // write an assertEquals() assertion
        assertEquals(13, actualLines);
    }

}