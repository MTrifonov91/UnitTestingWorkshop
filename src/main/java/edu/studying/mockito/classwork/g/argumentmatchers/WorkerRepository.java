package edu.studying.mockito.classwork.g.argumentmatchers;

// class(interface) serving as external dependency for WorkerService.class
public interface WorkerRepository {

    Worker findWorkerById(long id);

    void saveWorker(Worker worker);

    void removeWorker(Worker worker);

}
