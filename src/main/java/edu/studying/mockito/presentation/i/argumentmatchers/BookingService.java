package edu.studying.mockito.presentation.i.argumentmatchers;

import java.util.List;
// class under test
public class BookingService {

    // external dependency
    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // method under test
    public boolean buyTicket(String showId){
        String ticketShowId = createTicketShowId(showId);
        Ticket ticket = new Ticket(ticketShowId);
        return bookSeat(ticket);
    }

    // method under test
    public boolean bookSeat(Ticket ticket) {
        List<String> availableSeatsForShow =
                bookingRepository.getSeats(ticket.getShowFromId());
        if(availableSeatsForShow.contains(ticket.getShowId())){
            //update database
            return true;
        }
        else{
            return false;
        }
    }

    // internal method
    private String createTicketShowId(String showId) {
        return "TICKET:" + showId;
    }
}
