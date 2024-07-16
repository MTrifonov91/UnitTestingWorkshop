package edu.studying.mockito.classwork.f.argumentcapturing.userservice;

import lombok.AllArgsConstructor;

// class under test
@AllArgsConstructor
public class UserService {

    // external dependencies
    private UserRepository userRepository;

    // method under test
    public void createUser(String name) {
        User user = new User(name);
        userRepository.save(user);
    }

}
