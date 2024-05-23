package edu.studying.mockito.classwork.stubbing;

import edu.studying.mockito.classwork.stubbing.MissingParkedVehiclesOfGivenTypeException;
import edu.studying.mockito.classwork.stubbing.Parking;
import edu.studying.mockito.classwork.stubbing.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static edu.studying.mockito.classwork.stubbing.Vehicle.VehicleType.*;

@ExtendWith(MockitoExtension.class)
class ParkingTest {

    // TODO declare/create test doubles and test data


    @BeforeEach
    public void setup() {

    }

    // TODO write a test for getParkedVehiclesByType() method (path a)
    //  using created test data (stub the internal method call)
    @Test
    public void testGetParkedVehiclesByType() {

    }

    // TODO write a test for getParkedVehiclesByType() method (path b)
    //  using an argument matcher
    @Test
    public void testGetParkedVehiclesByTypeWithMatcher() {

    }

    // TODO write a test for getTotalAvailableSpaces() method
    //  using stubs on called methods
    @Test
    public void testGetTotalAvailableSpaces() {

    }

    // TODO write a test for getTotalAvailableSpaces() method
    //  validate all internal method calls where made
    @Test
    public void testGetTotalAvailableSpacesCallsMethods() {

    }

}