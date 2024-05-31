package edu.studying.mockito.classwork.stubbing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static edu.studying.mockito.classwork.stubbing.Vehicle.VehicleType.COMMERCIAL;
import static edu.studying.mockito.classwork.stubbing.Vehicle.VehicleType.MOTORCYCLE;
import static edu.studying.mockito.classwork.stubbing.Vehicle.VehicleType.PASSENGER_CAR;
import static edu.studying.mockito.classwork.stubbing.Vehicle.VehicleType.SUV;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParkingTest {

    // TODO declare/create test doubles and test data
    @Spy
    Parking parkingSpy;

    Map<Vehicle.VehicleType, Integer> parkedVehicles;

    @BeforeEach
    public void setup() {
        // instantiating the carsInStock map
        parkedVehicles = new HashMap<>();
        // setting the map with test data
        parkedVehicles.put(MOTORCYCLE, 19);
        parkedVehicles.put(PASSENGER_CAR, 99);
        parkedVehicles.put(SUV, 151);
        parkedVehicles.put(COMMERCIAL, 22);
    }

    // TODO write a test for getParkedVehiclesByType() method (path a)
    //  using created test data (stub the internal method call)
    @Test
    public void testGetParkedVehiclesByType() {
        when(parkingSpy.getParkedVehicles()).thenReturn(parkedVehicles);

        assertEquals(99, parkingSpy.getParkedVehiclesByType(PASSENGER_CAR));
    }

    // TODO write a test for getParkedVehiclesByType() method (path b)
    //  using an argument matcher
    @Test
    public void testGetParkedVehiclesByTypeWithMatcher() {
        when(parkingSpy.getParkedVehicles()).thenReturn(anyMap());

        assertThrows(MissingParkedVehiclesOfGivenTypeException.class,
                () -> parkingSpy.getParkedVehiclesByType(PASSENGER_CAR));
    }

    // TODO write a test for getTotalAvailableSpaces() method
    //  using stubs on called methods
    @Test
    public void testGetTotalAvailableSpaces() {
        when(parkingSpy.getParkedVehicles()).thenReturn(parkedVehicles);

        when(parkingSpy.getParkedVehiclesByType(MOTORCYCLE)).thenReturn(100);
        when(parkingSpy.getParkedVehiclesByType(PASSENGER_CAR)).thenReturn(1000);
        when(parkingSpy.getParkedVehiclesByType(SUV)).thenReturn(1000);
        when(parkingSpy.getParkedVehiclesByType(COMMERCIAL)).thenReturn(100);

        assertEquals(2800, parkingSpy.getTotalAvailableSpaces());
    }

    // TODO write a test for getTotalAvailableSpaces() method
    //  validate all internal method calls where made
    @Test
    public void testGetTotalAvailableSpacesCallsMethods() {
        when(parkingSpy.getParkedVehicles()).thenReturn(parkedVehicles);
        parkingSpy.getTotalAvailableSpaces();

        verify(parkingSpy, times(4)).getParkedVehicles();
        verify(parkingSpy).getParkedVehiclesByType(MOTORCYCLE);
        verify(parkingSpy).getParkedVehiclesByType(PASSENGER_CAR);
        verify(parkingSpy).getParkedVehiclesByType(SUV);
        verify(parkingSpy).getParkedVehiclesByType(COMMERCIAL);
    }
}