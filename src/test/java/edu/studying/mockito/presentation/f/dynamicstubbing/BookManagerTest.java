package edu.studying.mockito.presentation.f.dynamicstubbing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

// test class to test BookManager.class methods
@ExtendWith(MockitoExtension.class)
class BookManagerTest {

    // creating mock via annotation
    @Spy
    private BooksRepository booksRepositoryMock;

    // creating a class under test object with the mocked dependency
    @InjectMocks
    private BookManager bookManager;

    // test data declaration
    private Set<String> booksDatabaseSet;

    @BeforeEach
    public void setup() {
        // test data initialisation
        booksDatabaseSet = new HashSet<>();
        booksDatabaseSet.add("Harry Potter");
    }

    // test getBookInventoryCount() method stubbing getBooks() method from dependency
    @Test
    public void testGetBookInventoryCount() {
        when(booksRepositoryMock.getBooks()).thenReturn(booksDatabaseSet);

        System.out.println("Number of books is: " + bookManager.getBookInventoryCount());
        System.out.println(booksDatabaseSet);
    }

    // test getBookInventoryCount() method stubbing getBooks() method from dependency
    // using thenAnswer() method and an implementation of Answer interface
    @Test
    public void testGetBookInventoryCountWithAnswer() {
        when(booksRepositoryMock.getBooks()).thenAnswer(new GetBooks());

        System.out.println("Number of books is: " + bookManager.getBookInventoryCount());
        System.out.println(booksDatabaseSet);
    }

    // test addBook() method stubbing addBook() method from dependency
    // using thenAnswer() method and an implementation of Answer interface
    @Test
    public void testGetBookInventoryCountWithAnswers() {
        when(booksRepositoryMock.getBooks()).thenAnswer(new GetBooks());

        System.out.println("Initial Number of books is: " + bookManager.getBookInventoryCount());
        System.out.println(booksDatabaseSet);

        String newBook = "Lord of the Rings";
        when(booksRepositoryMock.addBook(newBook)).thenAnswer(new AddBook());
        bookManager.addBook(newBook);

        System.out.println("Number of books after addition is: " + bookManager.getBookInventoryCount());
        System.out.println(booksDatabaseSet);
    }

    // creating a representation of the getBook() (stubbing it)
    // with Answer interface implementation
    // to allow dynamic stubbing
    class GetBooks implements Answer<Object> {
        // the answer object will be returned upon "GetBooks" invocation
        public Object answer(InvocationOnMock invocation) {

            // here the logic of the method can be further updated

            // for now this answer object just returns the test data set
            return booksDatabaseSet;
        }
    }

    // creating a representation of the addBook() (stubbing it)
    // with Answer interface implementation
    // to allow dynamic stubbing
    class AddBook implements Answer<Object> {
        // the answer object will be returned upon "AddBook" invocation
        public Object answer(InvocationOnMock invocation) {
            // saving the argument passed to the invoked "addBook()" method
            String book = invocation.getArgument(0);
            // updating the set with the new books name
            booksDatabaseSet.add(book);
            // returning the new books name
            return book;
        }
    }

}