package edu.studying.mockito.classwork.f.argumentcapturing.orderservice;

// class under test
public class OrderService {
    // external dependency
    private OrderStorage orderStorage;

    // method under test
    public void placeOrder(String pizzaName, String address, int telephoneNumber) {
        Order currentOrder = new Order(new Pizza(pizzaName), new Delivery(address, telephoneNumber));

        orderStorage.storeOrder(currentOrder);
    }

}
