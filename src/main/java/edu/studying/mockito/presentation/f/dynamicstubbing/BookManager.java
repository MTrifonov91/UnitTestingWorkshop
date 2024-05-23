package edu.studying.mockito.presentation.f.dynamicstubbing;

import java.util.Set;
// class under test
public class BookManager {

    // external dependency
    private BooksRepository booksRepository;

    // class constructor with external dependency as parameter
    public BookManager(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    // method under test
    public Integer getBookInventoryCount(){

        Set<String> allBooks = booksRepository.getBooks();
        return allBooks.size();
    }

    // method under test
    public void addBook(String bookName){
        this.booksRepository.addBook(bookName);
    }
}
