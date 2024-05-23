package edu.studying.mockito.presentation.c.stubvoidmethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

// test class for testing Car.class methods
class CarTest {

    // declare an instance of class under test
    Car car;
    // declare an instance of a mock of class under test
    Car carMock;
    // declare an instance of a spy of class under test
    Car carSpy;

    @BeforeEach
    public void setup() {
        // initialize the instance of class under test
        car = new Car("Dacia", "Logan", 70);
        // create a mock instance of the class under test
        carMock = mock();
        // create a spy version of the class object
        carSpy = spy(car);
    }

    // example test on getCategory() method on a "spy"
    // without stubbing assignCategory()
    @Test
    public void testAssignCategoryWithSpy() throws Exception {
        // invoke assignCategory() method on the spy object
        carSpy.assignCategory();

        System.out.println("getCategory() on a spy()");
        System.out.println(carSpy.getCategory());
    }

    // example test on getCategory() method on a "spy"
    // stubbing assignCategory() with doNothing()
    @Test
    public void testAssignCategoryWithSpyDoNothing() throws Exception {
        // stub assignCategory() method on the spy object
        doNothing().when(carSpy).assignCategory();

        System.out.println("getCategory() on a spy() with assignCategory() stubbed to doNothing()");
        System.out.println(carSpy.getCategory());
    }

    // example test on getCategory() method on a "mock"
    // without stubbing assignCategory()
    @Test
    public void testAssignCategoryWithMock() throws Exception {
        // invoke assignCategory() method on the mock object
        carMock.assignCategory();

        System.out.println("getCategory() on a mock()");
        System.out.println(carMock.getCategory());
    }

    // example test on getCategory() method on a "mock"
    // stubbing assignCategory() with doCallRealMethod()
    @Test
    public void testAssignCategoryWithMockDoNothing() throws Exception {
        // stub the getPower() method (as we are using a mock)
        when(carMock.getPower()).thenReturn(51);

        // stub assignCategory() method on the mock object
        doCallRealMethod().when(carMock).assignCategory();
        // stub getCategory() method on the mock object
        doCallRealMethod().when(carMock).getCategory();

        // invoke assignCategory() method on the mock object
        carMock.assignCategory();

        System.out.println("getCategory() on a mock() with multiple methods stubbed to doCallRealMethod()");
        System.out.println(carMock.getCategory());
    }

    // example test on assignCategory() method on a "mock"
    // stubbing assignCategory() with doThrow()
    @Test
    public void testAssignCategoryMockException() throws Exception {
        // stub assignCategory() using doThrow()
        // use 'doThrow' when you want to test whether an exception is thrown
        doThrow(Exception.class).when(carMock).assignCategory();
        // write an assertThrows() assertion on assignCategory() method (path a)
        assertThrows(Exception.class, carMock::assignCategory);
    }

    // example test on getPrice() and getCondition() methods
    // stubbing assignDefaultPriceAndCondition() method's behavior with doAnswer()
    @Test
    public void testAssignDefaultPriceWithDoAnswer() {
        // stubbing assignDefaultPriceAndCondition() with behavior of assigning wins and points
        doAnswer((carrSp) -> {
            Car car1 = (Car) carrSp.getMock();
            car1.setPrice(30000);
            car1.setCondition(Car.Condition.USED);
            return null;
        }).when(carSpy).assignDefaultPriceAndCondition();

        // invoke assignDefaultPriceAndCondition() method on the spy object
        carSpy.assignDefaultPriceAndCondition();

        System.out.println("getPrice(), and getCondition() with assignDefaultPriceAndCondition() stubbed using doAnswer()");
        System.out.println(carSpy.getPrice());
        System.out.println(carSpy.getCondition());
    }

}