package edu.studying.mockito.classwork.a.mocking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

// test class to test BookingManager.class methods
public class BookingManagerTest {

    // creating test doubles without annotations

    // declaring the objects we will be working with
    // HotelDao object should be a "mock", (it's methods will be stubbed)
    // and its name must reflect this
    private HotelDao hotelDaoMock;
    // BookingManager object (not a mock), as it's methods will not be 'instructed'
    private BookingManager bookingManager;

    // As we have more than 1 test, it is a good practice to write a "setup()" method using @BeforeEach annotation
    @BeforeEach
    public void setup() throws SQLException {
        //TODO instantiate the HotelDao mocked object

        //TODO instantiate the BookingManager object


        //TODO create test data,
        // that will be used as an instruction (stub) for the mocked object

        //TODO stub "fetchAvailableRooms()" mocked method
        // to return the CREATED test data when called

    }

    //TODO write a test for the "checkRoomAvailability(roomName)" method
    // with expected result = true
    @Test
    public void checkAvailableRoomsTrue() throws SQLException {

    }

    //TODO write a test for the "checkRoomAvailability(roomName)" method
    // with expected result = false
    @Test
    public void checkAvailableRoomsFalse() throws SQLException {

    }

}
