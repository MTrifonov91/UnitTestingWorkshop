package edu.studying.mockito.classwork.testdoubles;

import java.util.ArrayList;
import java.util.List;
// external dependency for NewsletterSender.class
public class SubscribersDatabase {

    // in the real world this method would connect to a DB and fetch the list
    public List<String> getSubscribers() {

        List<String> subscribers = new ArrayList<>();

        return subscribers;
    }
}
