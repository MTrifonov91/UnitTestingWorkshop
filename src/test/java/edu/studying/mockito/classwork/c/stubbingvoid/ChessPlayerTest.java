package edu.studying.mockito.classwork.c.stubbingvoid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// test class for testing ChessPlayer.class methods
class ChessPlayerTest {

    // creating test doubles without annotations

    // example test on getCategory() method on a "spy"
    // without stubbing assignCategory()
    @Test
    public void testAssignSeniorCategoryWithSpy() throws Exception {
        // create a class under test object
        ChessPlayer chessPlayer = new ChessPlayer("Magnus", 30);
        // create a spy version of the object
        ChessPlayer chessPlayerSpy = spy(chessPlayer);
        // invoke assignCategory() method on the spy object
        chessPlayerSpy.assignCategory();
        // write an assertEquals() assertion on getCategory() method (path c)
        assertEquals("Senior", chessPlayerSpy.getCategory());
    }

    //TODO write a test on getCategory() method on a "spy"
    // stubbing assignCategory() with doNothing()
    @Test
    public void testAssignSeniorCategorySpyDoNothing() throws Exception {

    }

    //TODO write a test on getCategory() method (path c) on a "mock"
    // stubbing assignCategory() with doCallRealMethod()
    @Test
    public void testAssignCategoryMockDoCallRealMethod() throws Exception {

    }

    // example test on getCategory() method on a "mock"
    // without stubbing assignCategory()
    @Test
    public void testAssignCategoryMock() throws Exception {
        // create a mock object of the class under test
        ChessPlayer chessPlayerMock = mock();
        // invoke assignCategory() method on the mock object
        chessPlayerMock.assignCategory();
        // write an assertEquals() assertion on getCategory() method (path c)
        assertEquals("Senior", chessPlayerMock.getCategory());
    }

    //TODO write a test on assignCategory() method (path a) on a "mock"
    // stubbing assignCategory() with doThrow()
    @Test
    public void testAssignCategoryMockException() throws Exception {

    }

    //TODO write a test on getWins() and getPoints() methods
    // stubbing assignScoreStats() method's behavior with
    // our own using doAnswer()
    @Test
    public void testAssignScoreStatsWithDoAnswer() {

    }

    //TODO write a test on getCategory() method for "path b" using a "spy"
    @Test
    public void testAssignUnderEighteenCategoryWithSpy() throws Exception {

    }

    // Example test on getCategory() method for "path b" using a "mock"
    @Test
    public void testAssignUnderEighteenCategoryWithMock() throws Exception {
        // create a mock object of the class under test
        ChessPlayer chessPlayerMock = mock();
        // stub the getAge() method
        when(chessPlayerMock.getAge()).thenReturn(10);

        // doCallRealMethod() - used to call the real method upon a mock object
        // stub assignCategory() using doCallRealMethod()
        doCallRealMethod().when(chessPlayerMock).assignCategory();
        // stub assignCategory() using doCallRealMethod()
        doCallRealMethod().when(chessPlayerMock).getCategory();
        // invoke assignCategory() method on the mock object
        chessPlayerMock.assignCategory();
        // write an assertEquals() assertion on getCategory() method (path b)
        assertEquals("Under 18's", chessPlayerMock.getCategory());
    }

    //TODO write a test on assignCategory() method for "path a" on a "spy"
    // stubbing assignCategory() with doThrow()
    // P.S. use a ChessPlayer object with data that would not cause
    // any exceptions under normal conditions (without stubbing)
    @Test
    public void testAssignCategoryThrowsExceptionWithSpyDoThrow() throws Exception {

    }

    //TODO write a test on assignCategory() method for "path a" on a "spy"
    // without stubbing assignCategory()
    @Test
    public void testAssignCategoryThrowsExceptionWithSpy() {

    }

    //TODO -> exclude from repo
    // write a test on getWins() and getPoints() method
    // invoking assignScoreStats()
    @Test
    public void testAssignScoreStats() {

    }

    //TODO -> exclude from repo
    // write a test on getCategory() method
    // stubbing assignCategory() method's behavior with doAnswer()
    @Test
    public void getCategoryAssignedWithDoAnswer() throws Exception {

    }

}