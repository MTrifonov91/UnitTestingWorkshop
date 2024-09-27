package edu.studying.mockito.homework.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// test class to test RepositoryManager.class methods
@ExtendWith(MockitoExtension.class)
class RepositoryManagerTest {

    // TODO create all the necessary test doubles via annotations
    @Mock
    EntityManager emMock;

    @InjectMocks
    RepositoryManager repositoryManager;

    @Mock
    Query queryMock;

    // TODO create required test data

    List<Student> studentList;

    @BeforeEach
    public void setup() {
        Student a = new Student(1, "Parker");
        Student b = new Student(2, "Mary");
        Student c = new Student(3, "Ben");
        studentList = Arrays.asList(a, b, c);
    }

    // TODO write a test for getAllStudents() method
    @Test
    void getAllStudentsTest() {

        when(queryMock.getResultList()).thenReturn(studentList);

        when(emMock.createNamedQuery(RepositoryManager.GET_ALL_STUDENTS)).thenReturn(queryMock);

        List<Student> actualStudents = repositoryManager.getAllStudents();

        assertEquals(actualStudents, studentList);

    }
}