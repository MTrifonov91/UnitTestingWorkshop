package edu.studying.mockito.homework.injectmocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

// class should be extended with MockitoExtension, for the mockito annotations to work
@ExtendWith(MockitoExtension.class)
// test class to test CustomerOrder.class methods
class CustomerOrderTest {

    //TODO create all test doubles using annotations like @Mock, @Spy, @InjectMocks


    //TODO write a test for vegetarianBreakfast() method
    @Test
    public void testVegetarianBreakfastReturnsValidList() {

    }

    //TODO write a test for meatBreakfast() method
    @Test
    public void testMeatBreakfastReturnsValidList() {

    }

    //TODO write a test for vegetarianDinner() method
    @Test
    public void testVegetarianDinnerReturnsValidList() {

    }

    //TODO write a test for meatDinner() method
    @Test
    public void testMeatDinnerReturnsValidList() {

    }
}