package edu.studying.mockito.presentation.e.injectannotations;

import java.util.Arrays;
import java.util.List;
// external dependency for CustomerOrder.class
public class BreakfastWaiter {

    // methods called from CustomerOrder.class
    public List<String> getMeatMenu(){
        return Arrays.asList("Apple", "Sausages", "Bacon", "Toast");
    }

    public List<String> getVegetarianMenu(){
        return Arrays.asList("Apple", "Beans", "Hash brown", "Toast");
    }
}
