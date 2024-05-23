package edu.studying.mockito.presentation.i.argumentmatchers;

public class Ticket {

    private String showId;

    public Ticket(String showId) {
        this.showId = showId;
    }

    public String getShowId() {
        return showId;
    }

    public String getShowFromId() {
        return getShowId().replace(":", "::");
    }
}
