package edu.studying.mockito.classwork.f.argumentcapturing.paymentservice;

// external dependency for PaymentService.class
public interface PaymentGateway {

    void charge(String orderId, double amount);

}
