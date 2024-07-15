package edu.studying.mockito.classwork.g.argumentmatchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        // Stub the findWorkerById method to return a Worker when any String is passed
        Worker worker = new Worker(1L, "John Doe", 30);
        when(workerRepositoryMock.findWorkerById(anyLong())).thenReturn(worker);

        // Call the getWorkerDetails method with a specific ID
        Worker result = workerService.getWorkerById(1L);

        // Assert the result
        assertEquals("John Doe", result.getName());
        assertEquals(30, result.getAge());

        // Verify that the findWorkerById method was called with any Long
        verify(workerRepositoryMock).findWorkerById(anyLong());
    }

    // TODO write a test for createOrUpdateWorker() method to verify that
    //  the saveWorker() method was called with argument that equals
    //  the test Worker object's name
    @Test
    void createOrUpdateWorker_verifyWorkerName() {
        // Create a Worker object
        Worker worker = new Worker(1L, "Jane Doe", 25);

        // Call the createOrUpdateWorker method
        workerService.createOrUpdateWorker(worker);

        // Verify that the saveWorker method was called with a Worker object whose name is "Jane Doe"
        verify(workerRepositoryMock).saveWorker(argThat(w -> "Jane Doe".equals(w.getName())));
    }

    // TODO write a test for createOrUpdateWorker() method to verify that
    //  the saveWorker() method was called with argument that equals
    //  the test Worker object's age
    @Test
    void createOrUpdateWorker_verifyWorkerAge() {
        // Create a Worker object
        Worker worker = new Worker(1L, "Jane Doe", 25);

        // Call the createOrUpdateWorker method
        workerService.createOrUpdateWorker(worker);

        // Verify that the saveWorker method was called with a Worker object whose age is equal to created worker test object age
        verify(workerRepositoryMock).saveWorker(argThat(w -> w.getAge() == worker.getAge()));
    }

    // TODO write a test for createOrUpdateWorker() method to verify that
    //  the saveWorker() method was called with argument that is
    //  an instance of Worker.class
    @Test
    void createOrUpdateWorker_savesAnInstanceOfWorker() {
        // Create a Worker object
        Worker worker = new Worker(2L, "Alex Smith", 28);

        // Call the createOrUpdateWorker method
        workerService.createOrUpdateWorker(worker);

        // Verify that the saveWorker method was called with any Worker object
        verify(workerRepositoryMock).saveWorker(any(Worker.class));
    }

    // TODO write a test for deleteWorker() method to verify that
    //  the removeWorker() method was called with argument that equals
    //  the test Worker object's name
    @Test
    void deleteWorker_verifyWorkerName() {
        // Create a Worker object
        Worker worker = new Worker(11L, "Sunnny Bob", 35);

        // Call the deleteWorker method
        workerService.deleteWorker(worker);

        // Verify that the removeWorker method was called with a Worker object whose name is "Jane Doe"
        verify(workerRepositoryMock).removeWorker(argThat(w -> "Sunnny Bob".equals(w.getName())));
    }

    // TODO write a test for deleteWorker() method to verify that
    //  the removeWorker() method was called with argument that equals
    //  the test Worker object's age
    @Test
    void deleteWorker_verifyWorkerAge() {
        // Create a Worker object
        Worker worker = new Worker(10L, "Bill Clinton", 75);

        // Call the deleteWorker method
        workerService.deleteWorker(worker);

        // Verify that the removeWorker method was called with a Worker object whose age is equal to created worker test object age
        verify(workerRepositoryMock).removeWorker(argThat(w -> w.getAge() == worker.getAge()));
    }

    // TODO write a test for deleteWorker() method to verify that
    //  the removeWorker() method was called with argument that is
    //  an instance of Worker.class
    @Test
    void deleteWorker_removesAnInstanceOfWorker() {
        // Create a Worker object
        Worker worker = new Worker(2L, "Rob Banks", 28);

        // Call the deleteWorker method
        workerService.deleteWorker(worker);

        // Verify that the removeWorker method was called with any Worker object
        verify(workerRepositoryMock).removeWorker(any(Worker.class));
    }

}