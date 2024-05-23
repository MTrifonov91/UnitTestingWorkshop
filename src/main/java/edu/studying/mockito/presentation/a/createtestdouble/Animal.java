package edu.studying.mockito.presentation.a.createtestdouble;
// class under test
public class Animal {

    // external dependency
    private ZooKeeper zooKeeper;
    public int age;

    public Animal(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    // No Args Constructor for spy()
//    public Animal() {
//
//    }

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public int getAge() {
        return age;
    }

}
