package edu.studying.mockito.presentation.d.stubmethodswithreturntype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

// test class to test CarShop.class methods
class CarShopTest {

    // declaring test dependencies
    CarShop carShopSpy;
    Map<String, Integer> carsInStock;
    List<String> cars;


    @BeforeEach
    public void setup() {
        // instantiating a spy version of class under test
        carShopSpy = spy();

        // instantiating the carsInStock map
        carsInStock = new HashMap<>();
        // setting the map with test data
        carsInStock.put("Jaguar", 10);

        // instantiating the cars list and setting test data
        cars = List.of("Jaguar", "Dacia", "BMW");
    }

    // example test for thenReturn() stubbing
    @Test
    public void testCarsInShopThenReturn() {

        //thenReturn() - has a compile time check on data type;
        // also, method behavior is run in background
        when(carShopSpy.getCarsInStock()).thenReturn(carsInStock);

        System.out.println(carShopSpy.getStockForBrand("Jaguar"));
    }

    // example test for doReturn() stubbing
    @Test
    public void testCarsInShopDoReturn() {

        //doReturn() - checks for data type at runtime;
        // invoked method is not being run
        doReturn(carsInStock).when(carShopSpy).getCarsInStock();

        System.out.println(carShopSpy.getStockForBrand("Jaguar"));
    }

    // example test for doReturn() stubbing
    // passing an invalid data type
    @Test
    public void testCarsInShopDoReturnWithInvalidDataType() {

        //doReturn() - checks for data type at runtime;
        // invoked method is not being run
        doReturn(cars).when(carShopSpy).getCarsInStock();

        System.out.println(carShopSpy.getStockForBrand("Jaguar"));
    }


}