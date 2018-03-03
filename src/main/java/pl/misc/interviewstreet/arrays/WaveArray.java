package pl.misc.interviewstreet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
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
