package edu.studying.mockito.presentation.g.internalmethodscallsverification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// test class to test TrainBarriers.class methods
@ExtendWith(MockitoExtension.class)
class TrainBarriersTest {

    // create a PassengerRepository mock()
    @Mock
    PassengerRepository passengerRepositoryMock;

    // create a EmailService mock()
    @Mock
    EmailService emailServiceMock;

    // creation of a TrainBarriers instance that contains both of the dependencies
    @InjectMocks
    TrainBarriers trainBarriers;

    // test data
    final int PASSENGER_ID = 3;

    // example test for passengerEntry() method
    // validating that it called registerPassengerOnTrain() and notifyPassenger() methods
    @Test
    void testPassengerEntryOnInternalMethodCalls() {

        trainBarriers.passengerEntry(PASSENGER_ID);
        verify(passengerRepositoryMock, times(2)).registerPassengerOnTrain(PASSENGER_ID);
        verify(emailServiceMock).notifyPassenger(PASSENGER_ID);
    }

    // example test for passengerEntry() method
    // validating that it called registerPassengerOnTrain() and notifyPassenger()
    // and added PASSENGER_ID to the passengersOnBoard Set
    // NON BDD style "verify()"
    @Test
    void testPassengerEntry() {

        // given - setup for test

        // instantiating a spy() version of the class under test instance
        TrainBarriers trainBarriersSpy = spy(trainBarriers);
        // stubbing the passengerIsEligible() method to return true
        when(trainBarriersSpy.passengerIsEligible(PASSENGER_ID)).thenReturn(true);

        // when - method invocation

        // method invocation
        trainBarriersSpy.passengerEntry(PASSENGER_ID);

        // then - what we expect

        // validating notifyPassenger() method was called
        verify(emailServiceMock).notifyPassenger(PASSENGER_ID);
        // validating registerPassengerOnTrain() method was called
        verify(passengerRepositoryMock).registerPassengerOnTrain(PASSENGER_ID);
        // validating passengersOnBoard set contains the added ID
        assertTrue(trainBarriersSpy.getPassengersOnBoard().contains(PASSENGER_ID));
    }

    // example test for passengerEntry() method
    // validating that it called registerPassengerOnTrain() and notifyPassenger()
    // and added PASSENGER_ID to the passengersOnBoard Set
    // BDD style "then() + should()"
    @Test
    void testPassengerEntryBDD() {

        // given

        // instantiating a spy() version of the class under test instance
        TrainBarriers trainBarriersSpy = spy(trainBarriers);
        // stubbing the passengerIsEligible() method to return true
        given(trainBarriersSpy.passengerIsEligible(PASSENGER_ID))
                .willReturn(true);

        // when

        // method invocation
        trainBarriersSpy.passengerEntry(PASSENGER_ID);

        // then

        // validating notifyPassenger() method was called
        then(emailServiceMock)
                .should()
                .notifyPassenger(PASSENGER_ID);

        // validating registerPassengerOnTrain() method was called
        then(passengerRepositoryMock)
                .should()
                .registerPassengerOnTrain(PASSENGER_ID);

        // validating passengersOnBoard set contains the added ID
        assertTrue(trainBarriersSpy.getPassengersOnBoard().contains(PASSENGER_ID));
    }
}