package edu.studying.mockito.presentation.i.argumentmatchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
// test class to test BookingService.class methods
@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    // create a BookingPersister spy()
    @Spy
    BookingRepository bookingRepositorySpy;

    // creation of a BookingManager instance that contains the dependency
    @InjectMocks
    BookingService bookingService;

    // example test for buyTicket() method
    // validates that bookSeat() method was called with "any" Ticket
    @Test
    void testBuyTicket() {
        BookingService bookingServiceSpy = spy(bookingService);
        bookingServiceSpy.buyTicket("ABC123");

        // any() - is the arg matcher
        verify(bookingServiceSpy).bookSeat(any(Ticket.class));
    }

    // example test for bookSeat() method
    // instructs getSeats() method to return availableTickets
    // passing anyString() as method parameter
    @Test
    void testBookSeat() {
        String ticketShowId = "TICKET:ID_1";
        Ticket ticket = new Ticket(ticketShowId);

        List<String> availableTickets = new ArrayList<>();
        availableTickets.add(ticketShowId);
        // anyString() - is the arg matcher
        when(bookingRepositorySpy.getSeats(anyString())).thenReturn(availableTickets);

        assertTrue(bookingService.bookSeat(ticket));
    }
}