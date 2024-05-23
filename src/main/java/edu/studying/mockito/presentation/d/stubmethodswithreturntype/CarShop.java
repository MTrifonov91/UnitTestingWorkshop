package edu.studying.mockito.presentation.d.stubmethodswithreturntype;

import java.util.HashMap;
import java.util.Map;
// class under test for doReturn() vs thenReturn()
public class CarShop {

    // method under test
    public Integer getStockForBrand(String brand) {

        Map<String, Integer> carsInStock = getCarsInStock();

        if (carsInStock.containsKey(brand)) {
            return carsInStock.get(brand);
        } else {
            throw new RuntimeException("Car brand not in stock.");
        }
    }

    // internal method that would call a DB
    // this method will be stubbed
    // method WILL always throw a RuntimeException
    public Map<String, Integer> getCarsInStock() {
        //calls a database
        System.out.println("Getting cars in stock");
        Map<String, Integer> carsInStock = new HashMap<String, Integer>();
        if(true) {
            throw new RuntimeException("thrown exception)");
        }
        return carsInStock;
    }
}
