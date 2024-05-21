package edu.studying.junit.homework.parameterized;

/** An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly steps, for every step
 * it was noted if it was an uphill, , or a downhill, step. Hikes always start and end at sea level, and each step up
 * or down represents a unit change in altitude. We define the following terms:
 * <p>
 *  A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending
 *  with a step down to sea level.
 * <p>
 *  A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending
 *  with a step up to sea level.
 * <p>
 *  Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
 * <p>
 * Input: int number of steps, string path containing "U" for uphill and "D" for downhill
 * <p>
 * Output: int number of valleys
 */
// class under test
public class CountingValleys {

    public static int countingValleys(int steps, String path) {

        boolean valley = false;
        int currentPosition = 0;
        int numberOfValleys = 0;

        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U') {
                currentPosition ++;
                if (currentPosition >= 0 && valley) {
                    valley = false;
                    numberOfValleys ++;
                }
            }
            else {
                currentPosition --;
                if (currentPosition < 0 && !valley) {
                    valley = true;
                }
            }
        }
        return numberOfValleys;
    }
}
