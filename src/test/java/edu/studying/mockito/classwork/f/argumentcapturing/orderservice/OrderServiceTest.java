package edu.studying.mockito.classwork.f.argumentcapturing.orderservice;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

// test class to test OrderService.class methods
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    // create an OrderStorage spy()
    @Spy
    OrderStorage orderStorageSpy;

    // creation of an OrderService instance that contains the dependency
    @InjectMocks
    OrderService orderService;

    // TODO create a test for placeOrder() method validating that objects
    //  of expected types (Pizza and Delivery) where created and send to storeOrder() method
    @Test
    public void test_placeOrder_withValidData_SendsObjectsOfValidTypes() {
        // ArgumentCaptor initialisation
        ArgumentCaptor<Order> capturedOrder = ArgumentCaptor.forClass(Order.class);

        // test method invocation
        orderService.placeOrder("Neapolitana", "Arborilor 21", 69000000);

        // looking into the storeOrder() method call and capturing the passed parameter
        verify(orderStorageSpy).storeOrder(capturedOrder.capture());

        // getting the captured object
        Order capturedOrderValue = capturedOrder.getValue();

        // write an AssertJ assertion to validate the placed order's object types
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(capturedOrderValue.getPizza()).isInstanceOf(Pizza.class);
            softly.assertThat(capturedOrderValue.getDelivery()).isInstanceOf(Delivery.class);
        });
    }

    // TODO create a test for placeOrder() method validating that an object
    //  containing expected data was sent to storage
    @Test
    public void test_placeOrder_withValidData_SendsValidDataToStorage() {
        // ArgumentCaptor initialisation
        ArgumentCaptor<Order> capturedOrder = ArgumentCaptor.forClass(Order.class);

        // method invocation
        orderService.placeOrder("Rancho", "Arborilor 21", 69000000);

        // looking into the storeOrder() method call and capturing the passed parameter
        verify(orderStorageSpy).storeOrder(capturedOrder.capture());

        // getting the captured object
        Order capturedOrderValue = capturedOrder.getValue();

        // write an AssertJ assertion to validate the placed order's data
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(capturedOrderValue.getPizza().getName()).isEqualTo("Rancho");
            softly.assertThat(capturedOrderValue.getDelivery().getAddress()).isEqualTo("Arborilor 21");
            softly.assertThat(capturedOrderValue.getDelivery().getTelephoneNumber()).isEqualTo(69000000);
        });
    }

}