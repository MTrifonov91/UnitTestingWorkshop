package edu.studying.junit.classwork.d.exception.message;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

// class under test
public class RaceReportProcessor {

    // method under test
    // method takes 2 String parameters representing the paths to files
    //
    public void generateReport(String driverFileLocation, String racePerformanceLocation) throws Exception {

        FileInputStream driverInputStream = new FileInputStream(driverFileLocation);
        List<Driver> driverList = readFileToObjectList(driverInputStream);

        FileInputStream racePerformanceInputStream = new FileInputStream(racePerformanceLocation);
        List<RacePerformance> racePerformanceList = readFileToObjectList(racePerformanceInputStream);

        //combines data
        combineDriverAndRaceToReport(driverList, racePerformanceList);
    }

    // internal method
    private void combineDriverAndRaceToReport(List<Driver> driverList, List<RacePerformance> racePerformanceList) {

        //combine two reports into one and save it.

    }

    // internal method
    <T> List<T> readFileToObjectList(FileInputStream driverFile) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(driverFile);
        List<T> objectList = new ArrayList<T>();
        while (ois.readObject() != null) {
            objectList.add((T) ois.readObject());
        }
        return objectList;
    }
}
