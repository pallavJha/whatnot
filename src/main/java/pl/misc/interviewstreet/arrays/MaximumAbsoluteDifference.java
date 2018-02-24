package pl.misc.interviewstreet.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author pallav
 * @version 1.0
 * @since 22/2/18
 */
public class MaximumAbsoluteDifference {

    public static int maxArr(ArrayList<Integer> A) {
        int prevSum = 0;
        int prevIndex = 0;
        if (A == null || A.size() == 0 || A.size() == 1) {
            return 0;
        }
        ArrayList<Integer> B = new ArrayList<>(A.size());
        B.add(0, A.get(0));
        if (A.size() > 1) {
            B.add(1, A.get(1));
            prevSum = (int) Math.abs(B.get(0) - B.get(1)) + 1;
            prevIndex = 0;
        }
        System.out.println("prevIndex : " + prevIndex);
        System.out.println("prevSum : " + prevSum);
        if (A.size() > 2) {
            for (int i = 2; i < A.size(); i++) {
                B.add(i, A.get(i));
                int currentSum = Math.abs(B.get(i) - B.get(i - 1)) + 1;
                int newPrevSum = Math.abs(B.get(i) - B.get(prevIndex)) + Math.abs(i - prevIndex);
                if (newPrevSum > prevSum) {
                    prevSum = newPrevSum;
                    System.out.println("First Case");
                }
                if (currentSum > prevSum) {
                    prevSum = newPrevSum;
                    prevIndex = i - 1;
                    System.out.println("Second Case");
                }
                System.out.println("prevIndex : " + prevIndex);
                System.out.println("prevSum : " + prevSum);
            }
        }
        return prevSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(-70, -64, -6, -56, 64, 61, -57, 16, 48, -98));
        maxArr(arrayList);
    }
}
