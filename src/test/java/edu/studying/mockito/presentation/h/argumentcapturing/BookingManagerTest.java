package edu.studying.mockito.presentation.h.argumentcapturing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
// test class to test BookingManager.class methods
@ExtendWith(MockitoExtension.class)
class BookingManagerTest {

    // create a BookingPersister spy()
    @Spy
    BookingPersister bookingPersisterSpy;

    // creation of a BookingManager instance that contains the dependency
    @InjectMocks
    BookingManager bookingManager;

    // example test for addReservation() method
    // intended to test what object was passed to database
    @Test
    void addReservation() {

        // ArgumentCaptor initialisation
        ArgumentCaptor<Booking> capturedBooking = ArgumentCaptor.forClass(Booking.class);
        // method invocation
        bookingManager.addReservation("Anthony", 2, 19);
        // looking into the persistToDatabase() method call and capturing the passed parameter
        verify(bookingPersisterSpy).persistToDatabase(capturedBooking.capture());
        // getting the captured object
        Booking captureBookingValue = capturedBooking.getValue();

        System.out.println(captureBookingValue);
    }
}