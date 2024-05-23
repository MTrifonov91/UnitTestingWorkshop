package edu.studying.mockito.homework.injectmocks;

import java.util.Arrays;
import java.util.List;
// external dependency for CustomerOrder.class
public class DinnerWaiter {

    // methods called from CustomerOrder.class
    public List<String> getMeatMenu(){
        return Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding");
    }

    public List<String> getVegetarianMenu(){
        return Arrays.asList("Garlic bread", "Vegetable Lasagne", "Chocolate Brownie");
    }
}
