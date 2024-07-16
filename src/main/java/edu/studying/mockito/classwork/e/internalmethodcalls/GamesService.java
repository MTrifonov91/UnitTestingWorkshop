package edu.studying.mockito.classwork.e.internalmethodcalls;

import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// class under test
public class GamesService {

    // external dependencies
    private OrdersRepository ordersRepository;
    private NotificationService notificationService;
    @Getter
    private Set<Integer> orderIds;

    public GamesService(OrdersRepository ordersRepository, NotificationService notificationService) {
        this.ordersRepository = ordersRepository;
        this.notificationService = notificationService;
        orderIds = new HashSet<>();
    }

    // method under test
    public void placeGameOrder(String gameName, Integer orderId) {
        if (isGamePresent(gameName) && isOrderIdValid(orderId)) {
            orderIds.add(orderId);
            ordersRepository.storeOrder(orderId);
            notificationService.notifyAboutOrder(orderId);
        }
    }

    // internal method
    public boolean isGamePresent(String game) {
        List<String> exisingGames = ordersRepository.queryExistingGames();
        return exisingGames.stream()
                .anyMatch(game::equals);
    }

    // internal method
    public boolean isOrderIdValid(int orderId) {
        return !orderIds.contains(orderId);
    }

}
