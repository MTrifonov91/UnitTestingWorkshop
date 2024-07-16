package edu.studying.mockito.classwork.e.internalmethodcalls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

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
        // stub queryExistingGames() method to return true
        when(ordersRepositoryMock.queryExistingGames()).thenReturn(games);

        // invoke the tested method
        gamesService.placeGameOrder(gameName, orderId);

        // validate queryExistingGames() was called
        verify(ordersRepositoryMock).queryExistingGames();

        // validate storeOrder() was called with orderId argument
        verify(ordersRepositoryMock).storeOrder(orderId);

        // validate notifyAboutOrder() was called with orderId argument
        verify(notificationServiceMock).notifyAboutOrder(orderId);
    }

    // TODO create a test for placeGameOrder() method stubbing all the
    //  internal class methods and validating the calls to methods from
    //  dependency classes, assert the orderIds contains the new addition
    @Test
    void testPlaceGameOrder() {
        // instantiating a spy() version of the class under test instance
        GamesService gamesServiceSpy = spy(gamesService);

        // stubbing the isOrderIdValid() method to return true
        when(gamesServiceSpy.isOrderIdValid(orderId)).thenReturn(true);

        // stubbing the isGamePresent() method to return true
        when(gamesServiceSpy.isGamePresent(gameName)).thenReturn(true);

        // tested method invocation
        gamesServiceSpy.placeGameOrder(gameName, orderId);

        // validating notifyAboutOrder() method was called
        verify(notificationServiceMock).notifyAboutOrder(orderId);
        // validating registerPassengerOnTrain() method was called
        verify(ordersRepositoryMock).storeOrder(orderId);
        // validating the set contains the added orderID
        assertTrue(gamesServiceSpy.getOrderIds().contains(orderId));
    }

    // TODO repeat previous task using the Mockito BDD methods
    @Test
    void testPlaceGameOrderBDD() {
        // instantiating a spy() version of the class under test instance
        GamesService gamesServiceSpy = spy(gamesService);

        // stubbing the isOrderIdValid() method to return true
        given(gamesServiceSpy.isOrderIdValid(orderId))
                .willReturn(true);

        // stubbing the isOrderIdValid() method to return true
        given(gamesServiceSpy.isGamePresent(gameName))
                .willReturn(true);

        // tested method invocation
        gamesServiceSpy.placeGameOrder(gameName, orderId);

        // validating notifyAboutOrder() method was called
        then(notificationServiceMock)
                .should()
                .notifyAboutOrder(orderId);

        // validating storeOrder() method was called
        then(ordersRepositoryMock)
                .should()
                .storeOrder(orderId);

        // validating the set contains the added orderID
        assertTrue(gamesServiceSpy.getOrderIds().contains(orderId));
    }
}