package edu.studying.mockito.classwork.mocking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Represents the external dependency for BookingManager class
public class HotelDao {

    // This methods logic is outside the scope of Unit testing done in BookingManager class, and it should not be actually run
    public List<String> fetchAvailableRooms() throws SQLException {
        List<String> availableRooms = new ArrayList<String>();
        Connection conn = DriverManager.getConnection("DATABASE_URL");
        Statement statement = conn.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("SELECT * FROM ROOMS WHERE AVAILABLE like '1'");
        while(rs.next()){
            availableRooms.add(rs.getString("Room name"));
        }
        return availableRooms;
    }
}

