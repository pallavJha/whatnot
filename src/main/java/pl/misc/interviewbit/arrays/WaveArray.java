package pl.misc.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * interviewbit Wave Array Solution
 * Given an array of integers, sort the array into a wave like array and return it,
 * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 * <p>
 * Example
 * <p>
 * Given [1, 2, 3, 4]
 * <p>
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 *
 * @author pallav
 * @version 1.0
 * @since 4/3/18
 */
public class WaveArray {

    public static ArrayList<Integer> generateWaveArray(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i = 0; i < A.size() - 1; i++) {
            int temp = A.get(i);
            A.set(i, A.get(i + 1));
            A.set(i + 1, temp);
            i = i + 1;
        }
        return A;
    }

    public static void main(String[] args) {
        List<Integer> aList = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(generateWaveArray(new ArrayList<>(aList)));
    }
}
