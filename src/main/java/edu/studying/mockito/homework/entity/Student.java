package edu.studying.mockito.homework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "student_table")
@NoArgsConstructor
@ToString
public class Student {
    private int studentId;
    private String name;

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getStudentId() {
        return studentId;
    }

    @Column(name = "student_name")
    public String getName() {
        return name;
    }

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

}