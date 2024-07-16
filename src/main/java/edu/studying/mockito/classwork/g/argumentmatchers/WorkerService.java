package edu.studying.mockito.classwork.g.argumentmatchers;

import lombok.AllArgsConstructor;

// class under test
@AllArgsConstructor
public class WorkerService {

    // external dependency
    private WorkerRepository workerRepository;

    // method under test
    public Worker getWorkerById(long id) {
        return workerRepository.findWorkerById(id);
    }

    // method under test
    public void createOrUpdateWorker(Worker worker) {
        workerRepository.saveWorker(worker);
    }

    // method under test
    public void deleteWorker(Worker worker) {
        workerRepository.removeWorker(worker);
    }
}
