package edu.studying.junit.classwork.b.parameterized;
// class under test
public class StudentScoreCalculator {

    // class variable
    private int satScore;
    private int mediumScore;

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

    // method that takes 4 parameters as input and sets the class variable with:
    // path a -1
    // path b parameters multiplied and divided by 4
    public void calculateMediumScore(int mathsScore, int historyScore, int informaticsScore, int englishScore) {
        // path a
        if (mathsScore < 0 || mathsScore > 100
                || historyScore < 0 || historyScore > 100
                || informaticsScore < 0 || informaticsScore > 100
                || englishScore < 0 || englishScore > 100) {
            mediumScore = -1;
        } else {
            // path b
            mediumScore = (mathsScore + historyScore + informaticsScore + englishScore) / 4;
        }
    }

    // getter method for the class variable
    public int getSatScore() {
        return this.satScore;
    }

    // getter method for the class variable
    public int getMediumScore() {
        return this.mediumScore;
    }
}
