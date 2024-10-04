/*
 * TA：瀬戸村
 */

package day1;

import java.util.Arrays;

public class Calc {
    public static void main(String[] args) {
        int[] array = { 10, 12, 8, 16, 20, 6, 24, 32 };
        Arrays.sort(array);
        int min = array[0];
        int max = array[array.length - 1];

        int mid = 0;
        for (int i = 0; i < array.length; i++) {
            mid += array[i];
        }
        mid = mid / array.length;

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Mid: " + mid);
    }
}
