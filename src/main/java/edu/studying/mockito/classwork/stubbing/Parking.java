package edu.studying.mockito.classwork.stubbing;

import java.util.HashMap;
import java.util.Map;

import static edu.studying.mockito.classwork.stubbing.Vehicle.VehicleType.*;


public class Parking {

    private final int TOTAL_PARKING_CAPACITY = 5000;
    private final int MOTORCYCLE_PARKING_CAPACITY = 300;
    private final int PASSENGER_CARS_PARKING_CAPACITY = 2000;
    private final int SUV_PARKING_CAPACITY = 2000;
    private final int COMMERCIAL_PARKING_CAPACITY = 700;

    // method under test
    public Integer getParkedVehiclesByType(Vehicle.VehicleType vehicleType) {

        Map<Vehicle.VehicleType, Integer> parkedVehicles = getParkedVehicles();

        if (parkedVehicles.containsKey(vehicleType)) {
            // path a
            return parkedVehicles.get(vehicleType);
        } else {
            // path b
            throw new MissingParkedVehiclesOfGivenTypeException();
        }
    }

    // internal method that would call a DB
    // this method will be stubbed
    public Map<Vehicle.VehicleType, Integer> getParkedVehicles() {
        //calls a database
        System.out.println("Getting parked vehicles");

        return new HashMap<>();
    }

    // method under test
    public int getTotalAvailableSpaces() {
        return (MOTORCYCLE_PARKING_CAPACITY - getParkedVehiclesByType(MOTORCYCLE))
                + (PASSENGER_CARS_PARKING_CAPACITY - getParkedVehiclesByType(PASSENGER_CAR))
                + (SUV_PARKING_CAPACITY - getParkedVehiclesByType(SUV))
                + (COMMERCIAL_PARKING_CAPACITY - getParkedVehiclesByType(COMMERCIAL));
    }
}
