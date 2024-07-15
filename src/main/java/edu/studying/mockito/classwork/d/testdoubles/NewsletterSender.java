package edu.studying.mockito.classwork.d.testdoubles;

import java.util.List;
// Class under test

// Class responsible for sending a newsletter using 2 services
public class NewsletterSender {

    // External dependencies
    private SubscribersDatabase subscribersDatabase;
    private MessagingEngine messagingEngine;

    // Method to be tested
    // Class constructor that takes both dependencies as parameters and instantiates them
    public NewsletterSender(SubscribersDatabase subscribersDatabase, MessagingEngine messagingEngine) {
        this.subscribersDatabase = subscribersDatabase;
        this.messagingEngine = messagingEngine;
    }

    // Method to be tested
    // The method call form the external dependency must be stubbed
    // This method has 2 paths of execution
    public void sendNewsletter(String subject){
        List<String> emails = subscribersDatabase.getSubscribers();

        if(numberOfSubscribers() == 0){
            throw new ZeroSubscribersException();
        }
        messagingEngine.sendEmail(subject, emails);
    }

    // Method to be tested
    // current method uses a method from an external dependency
    public int numberOfSubscribers(){
        return subscribersDatabase.getSubscribers().size();
    }

    public SubscribersDatabase getSubscribersDatabase() {
        return subscribersDatabase;
    }

    public MessagingEngine getMessagingEngine() {
        return messagingEngine;
    }
}
