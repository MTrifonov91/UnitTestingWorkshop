package edu.studying.mockito.presentation.h.argumentcapturing;
// class under test
public class BookingManager {

    private BookingPersister bookingPersister;
    public BookingManager(BookingPersister bookingPersister) {
        this.bookingPersister = bookingPersister;
    }

    // method under test
    public void addReservation(String name, Integer number, Integer time) {
        // creates a Table object with passed parameters
        Table table = new Table(name, number, time);
        // creates a Booking object with passed Table object
        Booking booking = new Booking(table);
        // passes the booking object to database
        bookingPersister.persistToDatabase(booking);
    }
}
