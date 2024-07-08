package edu.studying.junit.classwork.g.assertj;

import edu.studying.junit.classwork.g.assertj.Item;
import edu.studying.junit.classwork.g.assertj.ListTransformer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// test class to test ListTransformer.class methods
class ListTransformerTest {

    // AssertJ provides improved readability compared to JUnit assertions
    // declare the instance of the class under test
    private ListTransformer listTransformer;

    // initialize instance of the class under test
    @BeforeEach
    public void setup() {
        listTransformer = new ListTransformer();
    }

    // write a test for containsLetter() method using both JUNIT and ASSERTJ assertions
    @Test
    public void containsLetterTest() {
        // create test data for methods parameters
        // List of Items
        Item a = new Item(10, "raspberry");
        Item b = new Item(2, "banana");
        Item c = new Item(1, "apricot");
        List<Item> items = Arrays.asList(a, b, c);
        // CharSequence
        CharSequence cs = "b";

        // collect method's return
        List<Item> itemsWithB = listTransformer.containsLetter(cs, items);
        // declare expected return
        List<Item> expected = Arrays.asList(a, b);

        // write assertions with JUnit
        // (assertNotNull, assertEquals for List size and for List objects)
        assertNotNull(itemsWithB);
        assertEquals(2, itemsWithB.size());
        assertEquals(expected, itemsWithB);

        // write assertions with AssertJ
        // assertThat + hasSize + hasSameElementsAs
        Assertions.assertThat(itemsWithB)
                .hasSize(2)
                .hasSameElementsAs(expected);

    }

    // write a test for containsLetterAndSort() method using both JUNIT and ASSERTJ assertions
    @Test
    public void containsLetterAndSortTest() {
        // create test data for methods parameters
        // List of Items
        Item a = new Item(10, "raspberry");
        Item b = new Item(2, "banana");
        Item c = new Item(1, "apricot");
        List<Item> items = Arrays.asList(a, b, c);
        // CharSequence
        CharSequence cs = "b";
        // collect method's return
        List<Item> itemsWithB = listTransformer.containsLetterAndSort(cs, items);
        // declare expected return
        List<Item> expected = Arrays.asList(b, a);

        // write assertions with JUnit
        // validate List is not null, has expected size and is in expected order
        assertNotNull(itemsWithB);
        assertEquals(2, itemsWithB.size());
        assertIterableEquals(expected, itemsWithB);

        // write assertions with AssertJ
        // validate List is not null, has expected size and is in expected order
        Assertions.assertThat(itemsWithB)
                .hasSize(2)
                .isSortedAccordingTo(Item::compareTo)
                // or using containsExactlyElementsOf()
                .containsExactlyElementsOf(expected);
    }
}