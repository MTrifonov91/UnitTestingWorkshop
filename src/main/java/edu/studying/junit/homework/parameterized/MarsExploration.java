package edu.studying.junit.homework.parameterized;

/**
 * A space explorer's ship crashed on Mars! They send a series of SOS messages to Earth for help.
 * Letters in some of the SOS messages are altered by cosmic radiation during transmission. Given the signal received
 * by Earth as a string, , determine how many letters of the SOS message have been changed by radiation.
 * Example: s = 'SOSTOT'
 * The original message was SOSSOS. Two of the message's characters were changed in transit.
 * <p>
 * Complete the marsExploration function in the editor below.
 * <p>
 * marsExploration has the following parameter(s):
 * <p>
 *     string s: the string as received on Earth
 *     returns: int: the number of letters changed during transmission
 */
public class MarsExploration {

    public static int marsExploration(String s) {

        int countOfChanged = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 3 == 1 && s.charAt(i) != 'O') {
                countOfChanged ++;
            }
            else if (i % 3 != 1 && s.charAt(i) != 'S') {
                countOfChanged ++;
            }
        }
        return countOfChanged;
    }
}
