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

    }

    // TODO create a test for placeOrder() method validating that an object
    //  containing expected data was sent to storage
    @Test
    public void test_placeOrder_withValidData_SendsValidDataToStorage() {

    }

}