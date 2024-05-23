package edu.studying.mockito.presentation.e.injectannotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

// class should be extended with MockitoExtension, for the mockito annotations to work
@ExtendWith(MockitoExtension.class)
// test class to test CustomerOrder.class methods
class CustomerOrderTest {

    // creation of a BreakfastWaiter spy()
    @Spy
    BreakfastWaiter breakfastWaiterSpy;

    // creation of a DinnerWaiter spy()
    @Spy
    DinnerWaiter dinnerWaiterSpy;

    // creation of a CustomerOrder instance that contains both of the dependencies
    // it returns an object instance, NOT a spy() or a mock()
    @InjectMocks
    CustomerOrder customerOrder;

    // example test for vegetarianBreakfast()
    @Test
    void testServeVegetarianBreakfast() {
        System.out.println(customerOrder.vegetarianBreakfast());
    }

    // example test for meatDinner()
    @Test
    void meatDinner() {
        System.out.println(customerOrder.meatDinner());
    }

    // example test for sayHello()
    @Test
    void testSayHello() {
        System.out.println(customerOrder.sayHello());
    }

    // example test for sayHello() stubbing the method
    @Test
    void testSayHelloStubbed() {
        when(customerOrder.sayHello()).thenReturn("Good bye");

        System.out.println(customerOrder.sayHello());
    }

    // example test for sayHello() stubbing the method on a spy()
    @Test
    void testSayHelloStubbedOnSpy() {
        CustomerOrder customerOrderSpy = spy(customerOrder);

        when(customerOrderSpy.sayHello()).thenReturn("Good bye");

        System.out.println(customerOrderSpy.sayHello());
    }

}