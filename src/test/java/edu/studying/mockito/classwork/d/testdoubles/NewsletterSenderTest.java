package edu.studying.mockito.classwork.d.testdoubles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// test class to test NewsletterSender.class methods
@ExtendWith(MockitoExtension.class)
class NewsletterSenderTest {

    // creating test doubles without annotations

    // test whether de NewsletterSender class's constructor instantiates a "SubscribersDatabase" object
    @Test
    public void testConstructorAssignsDatabase() {
        //TODO create a "mocked" version of the MessagingEngine
        // 'mock' -> a mock is a 'nullable' object of a given type
        MessagingEngine messagingEngineMock = mock();
        //TODO create an actual object of SubscribersDatabase
        SubscribersDatabase subscribersDatabase = new SubscribersDatabase();
        //TODO create an actual object of NewsLetterSender
        // passing the SubscribersDatabase object and the MessagingEngine mock
        NewsletterSender newsletterSender = new NewsletterSender(subscribersDatabase, messagingEngineMock);
        //TODO validate that SubscribersDatabase object created in the test
        // is the same as the assigned one in NewsLetterSender
        assertSame(subscribersDatabase, newsletterSender.getSubscribersDatabase());
    }

    //TODO test "numberOfSubscribers()" method
    @Test
    public void numberOfSubscribersEqualsThree() {
        // create a "mocked" version of the SubscribersDatabase
        SubscribersDatabase subscribersDatabaseMock = mock();
        // create a "mocked" version of the MessagingEngine
        MessagingEngine messagingEngineMock = mock();
        // create an actual object of NewsLetterSender passing both mocks
        NewsletterSender sender = new NewsletterSender(subscribersDatabaseMock, messagingEngineMock);

        // creating test data, that will be used as an instruction (stub) for the mocked object
        List<String> subscribersList = Arrays.asList("email1", "email2", "email3");
        // instructing(stubbing) the getSubscribers() method to return our created test data
        // 'stub' -> Giving a predefined return differentiates a STUB from a MOCK
        when(subscribersDatabaseMock.getSubscribers()).thenReturn(subscribersList);
        // validate that "numberOfSubscribers()" method returns the valid count
        assertEquals(3, sender.numberOfSubscribers(), "Number of subscribers should be: " + 3);
    }

    //TODO test "sendNewsletter()" method on the exception execution path
    @Test
    public void zeroSubscribersThrown() {
        // create a NewsletterSender instance
        NewsletterSender newsletterSender = new NewsletterSender(new SubscribersDatabase(), new MessagingEngine());
        // create a SPY version of NewsletterSender
        // 'spy' -> provides the ability of giving predefined returns for some of the class methods (allows stubbing)
        NewsletterSender newsletterSenderSpy = spy(newsletterSender);
        // stub numberOfSubscribers() to return 0
        when(newsletterSenderSpy.numberOfSubscribers()).thenReturn(0);
        // validate that sendNewsletter() method throws ZeroSubscribersException
        assertThrows(ZeroSubscribersException.class, () -> {
            newsletterSenderSpy.sendNewsletter("SUBJECT");
        });
    }

}