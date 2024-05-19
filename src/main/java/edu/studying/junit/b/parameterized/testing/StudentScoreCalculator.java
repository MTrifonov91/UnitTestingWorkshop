package edu.studying.junit.b.parameterized.testing;
// class under test
public class StudentScoreCalculator {

    // class variable
    private int satScore;

    // method that takes 2 parameters as input and sets the class variable with:
    // path a -1
    // path b parameters multiplied
    public void calculateSATScore(int mathsScore, int literacyScore) {
        // path a
        if (mathsScore < 0 || mathsScore > 100 || literacyScore < 0 || literacyScore > 100) {
            satScore = -1;
        } else {
            // path b
            satScore = mathsScore * literacyScore;
        }
    }

    // getter method for the class variable
    public int getSatScore() {
        return this.satScore;
    }
}
