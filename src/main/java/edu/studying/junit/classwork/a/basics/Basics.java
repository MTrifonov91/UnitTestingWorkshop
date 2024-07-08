package edu.studying.junit.classwork.a.basics;
// Class under test
public class Basics {

    // method takes 2 int parameters, returns:
    // 1 if n1 is bigger
    // -1 if n2 is bigger
    // 0 if n1 == n2
    public int compare(int n1, int n2) {
        if (n1 > n2) return 1;
        else if (n1 < n2) return -1;
        return 0;
    }

    // method takes an int array as parameter
    // returns the biggest one
    public int max(int[] arr) {
        // path a
        if (arr.length == 0) return -1;

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // path b
        return max;
    }

    // method takes an int array as parameter
    // sorts the array in ascending order
    public void sortArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // method takes String as parameter and reverses it
    public String reverseString(String s) {
        int length = s.length();
        StringBuilder reversed = new StringBuilder(length);

        for (int i = length - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }

        return reversed.toString();
    }

}
