package edu.studying.mockito.presentation.e.injectannotations;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
// class under test
public class CustomerOrder {

    // external dependencies
    @Autowired
    private BreakfastWaiter breakfastWaiter;

    @Autowired
    private DinnerWaiter dinnerWaiter;

    // All argument constructor
    public CustomerOrder(BreakfastWaiter breakfastWaiter, DinnerWaiter dinnerWaiter) {
        this.breakfastWaiter = breakfastWaiter;
        this.dinnerWaiter = dinnerWaiter;
    }

    // method that calls a method from external dependency
    public void setBreakfastWaiter(BreakfastWaiter breakfastWaiter) {
        this.breakfastWaiter = breakfastWaiter;
    }

    // method that calls a method from external dependency
    public void setDinnerWaiter(DinnerWaiter dinnerWaiter) {
        this.dinnerWaiter = dinnerWaiter;
    }

    // method that calls a method from external dependency
    public List<String> vegetarianBreakfast() {
        return breakfastWaiter.getVegetarianMenu();
    }

    // method that calls a method from external dependency
    public List<String> meatBreakfast() {
        return breakfastWaiter.getMeatMenu();
    }

    // method that calls a method from external dependency
    public List<String> vegetarianDinner() {
        return dinnerWaiter.getVegetarianMenu();
    }

    // method that calls a method from external dependency
    public List<String> meatDinner() {
        return dinnerWaiter.getMeatMenu();
    }

    // method to test stubbing on current class direct instance
    public String sayHello() {
        return "Hello!";
    }
}
