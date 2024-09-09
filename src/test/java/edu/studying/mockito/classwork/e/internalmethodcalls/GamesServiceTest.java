package edu.studying.mockito.classwork.e.internalmethodcalls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

// test class to test GamesService.class methods
@ExtendWith(MockitoExtension.class)
class GamesServiceTest {

    // creating test doubles with annotations
    @Mock
    OrdersRepository ordersRepositoryMock;

    @Mock
    NotificationService notificationServiceMock;

    @InjectMocks
    GamesService gamesService;

    // test data
    int orderId;
    String gameName;
    List<String> games;

    // initializing test data
    @BeforeEach
    void setUp() {
        orderId = 1;
        gameName = "GTA San Andreas";
        games = List.of(gameName);
    }

    // TODO create a test for placeGameOrder() method that validates all the
    //  calls to other related methods where made
    @Test
    void placeGameOrder() {

    }

    // TODO create a test for placeGameOrder() method stubbing all the
    //  internal class methods and validating the calls to methods from
    //  dependency classes, assert the orderIds contains the new addition
    @Test
    void testPlaceGameOrder() {

    }

    // TODO repeat previous task using the Mockito BDD methods
    @Test
    void testPlaceGameOrderBDD() {

    }
}