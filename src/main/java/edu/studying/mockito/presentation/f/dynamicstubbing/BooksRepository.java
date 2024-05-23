package edu.studying.mockito.presentation.f.dynamicstubbing;

import java.util.HashSet;
import java.util.Set;
// external dependency for BookManager.class
public class BooksRepository {

    public Set<String> getBooks(){

        //connects to database and returns books
        return new HashSet<String>();
    }

    public String addBook(String book){

        //adds book to database
        return book;
    }
}
