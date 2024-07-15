package edu.studying.mockito.classwork.f.argumentcapturing.userservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
// class serving as external dependency for createUser() method from UserService.class
public class User {

    private String name;
}
