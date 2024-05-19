package edu.studying.junit.e.privatemethods.testing;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

// test class to test GradeCalculator.class methods
class GradeCalculatorTest {

    // write a test for computeGrade() method for "path a" (return "Pass")
    @Test
    public void computeGradePass() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange  / Given
        // Initialize class under test
        // Use reflection to initialize the method under test
        // set the method instance to be accessible
        GradeCalculator gc = new GradeCalculator();
        Method method = gc.getClass().getDeclaredMethod("computeGrade", Integer.class);
        method.setAccessible(true);

        // Act  / When
        // Invoke the method and collect the return
        String actualGrade = (String) method.invoke(gc, 80);

        // Assert  / Then
        // write an assertEquals() assertion
        assertEquals("Pass", actualGrade);
    }

    // write a test for computeGrade() method for "path b" (return "Fail")
    @Test
    public void computeGradeFail() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange  / Given
        // Initialize class under test
        // Use reflection to initialize the method under test
        // set the method instance to be accessible
        GradeCalculator gc = new GradeCalculator();
        Method method = gc.getClass().getDeclaredMethod("computeGrade", Integer.class);
        method.setAccessible(true);

        // Act  / When
        // Invoke the method and collect the return
        String actualGrade = (String) method.invoke(gc, 69);

        // Assert  / Then
        // write an assertEquals() assertion
        assertEquals("Fail", actualGrade);
    }
}