package edu.studying.mockito.classwork.c.stubbingvoid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
        // create a class under test object
        ChessPlayer chessPlayer = new ChessPlayer("Magnus", 30);
        // create a spy version of the object
        ChessPlayer chessPlayerSpy = spy(chessPlayer);
        // stub assignCategory() using doNothing()
        // this will return null on the 'assignCategory()'
        doNothing().when(chessPlayerSpy).assignCategory();
        // invoke assignCategory() method on the spy object
        chessPlayerSpy.assignCategory();
        // write an assertNull() assertion on getCategory() method (path c)
        assertNull(chessPlayerSpy.getCategory());
    }

    //TODO write a test on getCategory() method (path c) on a "mock"
    // stubbing assignCategory() with doCallRealMethod()
    @Test
    public void testAssignCategoryMockDoCallRealMethod() throws Exception {
        // create a mock object of the class under test
        ChessPlayer chessPlayerMock = mock();
        // stub the getAge() method
        when(chessPlayerMock.getAge()).thenReturn(30);

        // doCallRealMethod() - used to call the real method upon a mock object
        // stub assignCategory() using doCallRealMethod()
        doCallRealMethod().when(chessPlayerMock).assignCategory();
        // stub assignCategory() using doCallRealMethod()
        doCallRealMethod().when(chessPlayerMock).getCategory();
        // invoke assignCategory() method on the mock object
        chessPlayerMock.assignCategory();
        // write an assertEquals() assertion on getCategory() method (path c)
        assertEquals("Senior", chessPlayerMock.getCategory());
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
        // create a mock object of the class under test
        ChessPlayer chessPlayerMock = mock();
        // stub assignCategory() using doThrow()
        // use 'doThrow' when you want to test whether an exception is thrown
        doThrow(Exception.class).when(chessPlayerMock).assignCategory();
        // write an assertThrows() assertion on assignCategory() method (path a)
        assertThrows(Exception.class, chessPlayerMock::assignCategory);
    }

    //TODO write a test on getWins() and getPoints() methods
    // stubbing assignScoreStats() method's behavior with
    // our own using doAnswer()
    @Test
    public void testAssignScoreStatsWithDoAnswer() {
        // create a class under test object
        ChessPlayer chessPlayer = new ChessPlayer("Magnus", 30);
        // create a spy version of the object
        ChessPlayer chessPlayerSpy = spy(chessPlayer);
        // stubbing assignScoreStats() with behavior of assigning wins and points
        doAnswer((chessP) -> {
            ChessPlayer player = (ChessPlayer) chessP.getMock();
            player.setWins(3);
            player.setPoints(9);
            return null;
        }).when(chessPlayerSpy).assignScoreStats();
        // invoke assignScoreStats() method on the spy object
        chessPlayerSpy.assignScoreStats();
        // write an assertEquals() assertion on getWins() method
        assertEquals(3, chessPlayerSpy.getWins());
        // write an assertEquals() assertion on getPoints() method
        assertEquals(9, chessPlayerSpy.getPoints());
    }

    //TODO write a test on getCategory() method for "path b" using a "spy"
    @Test
    public void testAssignUnderEighteenCategoryWithSpy() throws Exception {
        // create a class under test object
        ChessPlayer chessPlayer = new ChessPlayer("Magnus", 10);
        // create a spy version of the object
        ChessPlayer chessPlayerSpy = spy(chessPlayer);
        // invoke assignCategory() method on the spy object
        chessPlayerSpy.assignCategory();
        // write an assertEquals() assertion on getCategory() method (path b)
        assertEquals("Under 18's", chessPlayerSpy.getCategory());
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
        // create a class under test object
        ChessPlayer chessPlayer = new ChessPlayer("Magnus", 30);
        // create a spy version of the object
        ChessPlayer chessPlayerSpy = spy(chessPlayer);
        // stub assignCategory() using doThrow()
        // use 'doThrow' when you want to test whether an exception is thrown
        doThrow(Exception.class).when(chessPlayerSpy).assignCategory();
        // write an assertThrows() assertion on assignCategory() method (path a)
        assertThrows(Exception.class, chessPlayerSpy::assignCategory);
    }

    //TODO write a test on assignCategory() method for "path a" on a "spy"
    // without stubbing assignCategory()
    @Test
    public void testAssignCategoryThrowsExceptionWithSpy() {
        // create a class under test object
        ChessPlayer chessPlayer = new ChessPlayer("Magnus", 4);
        // create a spy version of the object
        ChessPlayer chessPlayerSpy = spy(chessPlayer);
        // write an assertThrows() assertion on assignCategory() method (path a)
        assertThrows(Exception.class, chessPlayerSpy::assignCategory);
    }

    //TODO -> exclude from repo
    // write a test on getWins() and getPoints() method
    // invoking assignScoreStats()
    @Test
    public void testAssignScoreStats() {
        // create a class under test object
        ChessPlayer chessPlayer = new ChessPlayer("Magnus", 30);
        // create a spy version of the object
        ChessPlayer chessPlayerSpy = spy(chessPlayer);
        // invoke assignScoreStats() method on the spy object
        chessPlayerSpy.assignScoreStats();
        // write an assertEquals() assertion on getWins() method
        assertEquals(1, chessPlayerSpy.getWins());
        // write an assertEquals() assertion on getPoints() method
        assertEquals(2, chessPlayerSpy.getPoints());
    }

    //TODO -> exclude from repo
    // write a test on getCategory() method
    // stubbing assignCategory() method's behavior with doAnswer()
    @Test
    public void getCategoryAssignedWithDoAnswer() throws Exception {
        // create a class under test object
        ChessPlayer chessPlayer = new ChessPlayer("Magnus", 30);
        // create a spy version of the object
        ChessPlayer chessPlayerSpy = spy(chessPlayer);
        // stubbing assignCategory() with behavior of assigning "Player age too low" category
        doAnswer((chessP) -> {
            ChessPlayer player = (ChessPlayer) chessP.getMock();
            player.setCategory("Player age too low");
            return null;
        }).when(chessPlayerSpy).assignCategory();
        // invoke assignCategory() method on the spy object
        chessPlayerSpy.assignCategory();
        // write an assertEquals() assertion on getCategory() method
        assertEquals("Player age too low", chessPlayerSpy.getCategory());
    }

}