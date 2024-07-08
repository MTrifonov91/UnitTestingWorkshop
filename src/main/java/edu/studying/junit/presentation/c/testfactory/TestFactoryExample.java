package edu.studying.junit.presentation.c.testfactory;

import java.util.List;

public class TestFactoryExample {

    public int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

}
