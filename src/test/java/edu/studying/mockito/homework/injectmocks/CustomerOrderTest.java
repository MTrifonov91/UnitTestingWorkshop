package edu.studying.mockito.homework.injectmocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// class should be extended with MockitoExtension, for the mockito annotations to work
@ExtendWith(MockitoExtension.class)
// test class to test CustomerOrder.class methods
class CustomerOrderTest {

    //TODO create all test doubles using annotations like @Mock, @Spy, @InjectMocks
    @Spy
    BreakfastWaiter breakfastWaiterSpy;

    @Spy
    DinnerWaiter dinnerWaiterSpy;

    @InjectMocks
    CustomerOrder customerOrder;

    //TODO write a test for vegetarianBreakfast() method
    @Test
    public void testVegetarianBreakfastReturnsValidList() {
        List<String> expectedList = Arrays.asList("Apple", "Beans", "Hash brown", "Toast");

        assertEquals(expectedList, customerOrder.vegetarianBreakfast());
    }

    //TODO write a test for meatBreakfast() method
    @Test
    public void testMeatBreakfastReturnsValidList() {
        List<String> expectedList = Arrays.asList("Apple", "Sausages", "Bacon", "Toast");

        assertEquals(expectedList, customerOrder.meatBreakfast());
    }

    //TODO write a test for vegetarianDinner() method
    @Test
    public void testVegetarianDinnerReturnsValidList() {
        List<String> expectedList = Arrays.asList("Garlic bread", "Vegetable Lasagne", "Chocolate Brownie");

        assertEquals(expectedList, customerOrder.vegetarianDinner());
    }

    //TODO write a test for meatDinner() method
    @Test
    public void testMeatDinnerReturnsValidList() {
        List<String> expectedList = Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding");

        assertEquals(expectedList, customerOrder.meatDinner());
    }
}