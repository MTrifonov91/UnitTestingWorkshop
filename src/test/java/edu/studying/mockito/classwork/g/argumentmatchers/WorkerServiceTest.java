package edu.studying.mockito.classwork.g.argumentmatchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// test class to test WorkerService.class methods
@ExtendWith(MockitoExtension.class)
class WorkerServiceTest {

    @Mock
    WorkerRepository workerRepositoryMock;

    @InjectMocks
    WorkerService workerService;

    // TODO write a test for getWorkerById() method to verify that the
    //  findWorkerById() method was called with an argument of type Long
    @Test
    void getWorkerById_callsFindWorkerByIdWithAnyLong() {

    }

    // TODO write a test for createOrUpdateWorker() method to verify that
    //  the saveWorker() method was called with argument that equals
    //  the test Worker object's name
    @Test
    void createOrUpdateWorker_verifyWorkerName() {

    }

    // TODO write a test for createOrUpdateWorker() method to verify that
    //  the saveWorker() method was called with argument that equals
    //  the test Worker object's age
    @Test
    void createOrUpdateWorker_verifyWorkerAge() {

    }

    // TODO write a test for createOrUpdateWorker() method to verify that
    //  the saveWorker() method was called with argument that is
    //  an instance of Worker.class
    @Test
    void createOrUpdateWorker_savesAnInstanceOfWorker() {

    }

    // TODO write a test for deleteWorker() method to verify that
    //  the removeWorker() method was called with argument that equals
    //  the test Worker object's name
    @Test
    void deleteWorker_verifyWorkerName() {

    }

    // TODO write a test for deleteWorker() method to verify that
    //  the removeWorker() method was called with argument that equals
    //  the test Worker object's age
    @Test
    void deleteWorker_verifyWorkerAge() {

    }

    // TODO write a test for deleteWorker() method to verify that
    //  the removeWorker() method was called with argument that is
    //  an instance of Worker.class
    @Test
    void deleteWorker_removesAnInstanceOfWorker() {

    }

}