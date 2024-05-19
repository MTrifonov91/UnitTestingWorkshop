package edu.studying.junit.g.assertj;

import java.util.List;

// class under test
// class contains an external dependency "Item"
public class ListTransformer {

    // method under test
    // method takes a CharSequence and a List of "Items"
    // returns filtered List with only those Items that contain CharSequence in the description
    public List<Item> containsLetter(CharSequence letter, List<Item> list) {
        return list.stream()
                .filter(item -> item.getDescription().contains(letter))
                .toList();
    }

    // method under test
    // method takes a CharSequence and a List of "Items"
    // returns filtered List with only those Items that contain CharSequence in the description
    // sorts the filtered list in alphabetical order
    public List<Item> containsLetterAndSort(CharSequence letter, List<Item> list) {
        return list.stream()
                .filter(item -> item.getDescription().contains(letter))
                .sorted()
                .toList();
    }
}
