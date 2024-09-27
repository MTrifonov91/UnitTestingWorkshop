package edu.studying.mockito.classwork.f.argumentcapturing.userservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

// class to test UserService.class methods
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    // TODO create test doubles
    @Mock
    UserRepository userRepositoryMock;

    @InjectMocks
    UserService userService;

    // TODO write a test for createUser() method validating data passed
    //  to save() method
    @Test
    void test_createUser_isCreatedWithValidData() {
        userService.createUser("John Doe");

        // Capture the argument passed to the save method
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepositoryMock).save(userCaptor.capture());

        User capturedUser = userCaptor.getValue();
        assertNotNull(capturedUser);
        assertEquals("John Doe", capturedUser.getName());
    }
}