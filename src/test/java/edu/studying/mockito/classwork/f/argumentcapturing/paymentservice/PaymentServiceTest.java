package edu.studying.mockito.classwork.f.argumentcapturing.paymentservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

// test class to test PaymentService.class methods
@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    // TODO create test doubles
    @Mock
    PaymentGateway paymentGatewayMock;

    @InjectMocks
    PaymentService paymentService;

    // TODO write a test for processPayment() method validating data passed to
    //  charge() method
    @Test
    void processPayment() {
        // Arrange
        ArgumentCaptor<String> orderIdCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Double> amountCaptor = ArgumentCaptor.forClass(Double.class);

        // Act
        paymentService.processPayment("order123", 100.0);

        verify(paymentGatewayMock).charge(orderIdCaptor.capture(), amountCaptor.capture());

        // Assert
        assertEquals("order123", orderIdCaptor.getValue());
        assertEquals(100.0, amountCaptor.getValue());

    }
}