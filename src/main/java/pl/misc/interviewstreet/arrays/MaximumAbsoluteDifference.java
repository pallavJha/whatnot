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
        int prevIndexNeg = -1;
        int prevIndexPos = -1;
        if (A == null || A.size() == 0 || A.size() == 1) {
            return 0;
        }
        ArrayList<Integer> B = new ArrayList<>(A.size());
        B.add(0, A.get(0));
        if (A.size() > 1) {
            B.add(1, A.get(1));
            prevSum = Math.abs(B.get(0) - B.get(1)) + 1;
            prevIndexNeg = B.get(0) < B.get(1) ? 0 : 1;
            prevIndexPos = B.get(0) < B.get(1) ? 1 : 0;
        }
        System.out.println("prevIndexNeg : " + prevIndexNeg);
        System.out.println("prevIndexPos : " + prevIndexPos);
        System.out.println("prevSum : " + prevSum);
        if (A.size() > 2) {
            for (int i = 2; i < A.size(); i++) {
                boolean posSelected = false;
                B.add(i, A.get(i));
                int currentSum = Math.abs(B.get(i) - B.get(i - 1)) + 1;
                int newPrevSum1 = Math.abs(B.get(i) - B.get(prevIndexNeg)) + Math.abs(i - prevIndexNeg);
                int newPrevSum2 = Math.abs(B.get(i) - B.get(prevIndexPos)) + Math.abs(i - prevIndexPos);
                int newPrevSum = 0;
                if (newPrevSum1 > newPrevSum2) {
                    newPrevSum = newPrevSum1;
                } else {
                    newPrevSum = newPrevSum2;
                    posSelected = true;
                }
                if (newPrevSum > prevSum) {
                    prevSum = newPrevSum;
                    if (posSelected) {
                        prevIndexNeg = i;
                    } else {
                        if (B.get(i) - i > B.get(prevIndexPos) - prevIndexPos) {
                            prevIndexPos = i;
                        }
                    }
                    System.out.println("First Case");
                }
                if (currentSum > prevSum) {
                    prevSum = currentSum;
                    int newPrevIndexNeg = B.get(i - 1) < B.get(i) ? i - 1 : i;
                    if (B.get(newPrevIndexNeg) < B.get(prevIndexNeg)) {
                        prevIndexNeg = newPrevIndexNeg;
                    }
                    int newPrevIndexPos = B.get(i - 1) < B.get(i) ? i : i - 1;
                    if (B.get(newPrevIndexPos) - newPrevIndexPos > B.get(prevIndexPos) - prevIndexPos) {
                        prevIndexPos = newPrevIndexPos;
                    }
                    System.out.println("Second Case");
                }
                System.out.println("prevIndexNeg : " + prevIndexNeg);
                System.out.println("prevIndexPos : " + prevIndexPos);
                System.out.println("prevSum : " + prevSum);
            }
        }
        return prevSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(55, -8, 43, 52, 8, 59, -91, -79, -18, -94));
        maxArr(arrayList);
    }
}
