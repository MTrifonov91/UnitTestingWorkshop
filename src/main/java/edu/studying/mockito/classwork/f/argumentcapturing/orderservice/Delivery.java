package edu.studying.mockito.classwork.f.argumentcapturing.orderservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
// class serving as external dependency for placeOrderMethod from OrderService.class
public class Delivery {

    private String address;
    private int telephoneNumber;
}
