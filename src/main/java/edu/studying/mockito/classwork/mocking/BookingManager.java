package edu.studying.mockito.classwork.mocking;

import java.sql.SQLException;
import java.util.List;
// Class under test

// Class responsible for recording bookings
public class BookingManager {

    // External dependency
    private HotelDao dao;

    // Class constructor that takes the dependency as a parameter
    public BookingManager(HotelDao dao) {
        this.dao = dao;
    }

    // Method to be tested
    // The method call via the external dependency must be stubbed
    // This method has only 2 possible valid returns - true and false
    public boolean checkRoomAvailability(String roomName) throws SQLException {

        List<String> roomsAvailable = dao.fetchAvailableRooms();
        return roomsAvailable.contains(roomName);
    }
}
