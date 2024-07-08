package edu.studying.junit.classwork.e.privatemethods;

import java.util.ArrayList;
import java.util.List;

// class under test
public class GradeCalculator {

    public List<String> getGrades(List<Integer> scores) {
        List<String> grades = new ArrayList<>();
        for(Integer score : scores) {
            grades.add(computeGrade(score));
        }
        return grades;
    }

    // method under test
    // method receives an Integer parameter and returns:
    // path a -> fail
    // path b -> pass
    private String computeGrade(Integer score) {
        return score < 70 ? "Fail" : "Pass";
    }
}
