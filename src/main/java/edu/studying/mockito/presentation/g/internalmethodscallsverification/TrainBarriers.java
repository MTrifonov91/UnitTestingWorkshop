package edu.studying.mockito.presentation.g.internalmethodscallsverification;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

// class under test
public class TrainBarriers {

    private PassengerRepository repository;
    private EmailService emailService;

    @Getter
    private Set<Integer> passengersOnBoard;

    public TrainBarriers(PassengerRepository repository, EmailService emailService) {
        this.passengersOnBoard = new HashSet<Integer>();
        this.repository = repository;
        this.emailService = emailService;
    }

    // method under test
    public void passengerEntry(int passengerId){
        if(passengerIsEligible(passengerId)) {
            passengersOnBoard.add(passengerId);
            repository.registerPassengerOnTrain(passengerId);
            emailService.notifyPassenger(passengerId);
        }
    }

    public boolean passengerIsEligible(int passengerId) {
        //logic to check passenger can board train
        return !passengersOnBoard.contains(passengerId);
    }
}
