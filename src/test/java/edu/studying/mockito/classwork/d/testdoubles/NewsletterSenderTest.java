package edu.studying.mockito.classwork.d.testdoubles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

// test class to test NewsletterSender.class methods
@ExtendWith(MockitoExtension.class)
class NewsletterSenderTest {

    // creating test doubles without annotations

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