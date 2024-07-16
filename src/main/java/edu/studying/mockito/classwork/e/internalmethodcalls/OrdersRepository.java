package edu.studying.mockito.classwork.e.internalmethodcalls;

import java.util.ArrayList;
import java.util.List;

// class serving as external dependency for GamesService.class
public class OrdersRepository {

    public List<String> queryExistingGames() {
        // DB logic to return a list of games from repo
        return new ArrayList<>();
    }

    public void storeOrder(int id) {
        // DB logic to store order
    }

}
