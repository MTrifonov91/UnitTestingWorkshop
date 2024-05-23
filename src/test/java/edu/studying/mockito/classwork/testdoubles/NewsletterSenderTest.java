package edu.studying.mockito.classwork.testdoubles;

import edu.studying.mockito.classwork.testdoubles.MessagingEngine;
import edu.studying.mockito.classwork.testdoubles.NewsletterSender;
import edu.studying.mockito.classwork.testdoubles.SubscribersDatabase;
import edu.studying.mockito.classwork.testdoubles.ZeroSubscribersException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

// test class to test NewsletterSender.class methods
class NewsletterSenderTest {

    // test whether de NewsletterSender class's constructor instantiates a "SubscribersDatabase" object
    @Test
    public void testConstructorAssignsDatabase() {
        //TODO create a "mocked" version of the MessagingEngine
        // 'mock' -> a mock is a 'nullable' object of a given type

        //TODO create an actual object of SubscribersDatabase

        //TODO create an actual object of NewsLetterSender
        // passing the SubscribersDatabase object and the MessagingEngine mock

        //TODO validate that SubscribersDatabase object created in the test
        // is the same as the assigned one in NewsLetterSender
    }

    //TODO test "numberOfSubscribers()" method
    @Test
    public void numberOfSubscribersEqualsThree() {

    }

    //TODO test "sendNewsletter()" method on the exception execution path
    @Test
    public void zeroSubscribersThrown() {

    }

}