package edu.studying.mockito.classwork.g.argumentmatchers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// class serving as external dependency for WorkerService.class
public class Worker {

    private long id;
    private String name;
    private int age;

}
