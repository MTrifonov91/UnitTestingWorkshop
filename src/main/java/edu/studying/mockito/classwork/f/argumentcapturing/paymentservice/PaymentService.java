package edu.studying.mockito.classwork.f.argumentcapturing.paymentservice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
// class under test
public class PaymentService {

    // external dependency
    private PaymentGateway paymentGateway;

    // method under test
    public void processPayment(String orderId, double amount) {
        // some payment processing logic
        paymentGateway.charge(orderId, amount);
    }
}
