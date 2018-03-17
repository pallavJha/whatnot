package pl.misc.interviewbit.arrays;

import java.util.*;

/**
 * Interviewbit Max Sum Contiguous Subarray Solution
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example:
 * <p>
 * Given the array [-2,1,-3,4,-1,2,1,-5,4],
 * <p>
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * <p>
 * For this problem, return the maximum sum.
 *
 * @author pallav
 * @version 1.0
 * @since 22/2/18
 */
public class MaximumSumArray {

    public static int maxSubArray(final List<Integer> A) {
        int sum = 0;
        Collection<Integer> allSums = new LinkedList<>();
        for (int i = 0; i < A.size(); i++) {
            /*if (A.get(i + 1) == 63 && A.get(i + 2) == 77) {
                System.out.println("s");
            }*/
            if (sum < 0 && Math.abs(sum) > A.get(i)) {
                sum = 0;
            }
            int tempSum = sum;
            sum += A.get(i);
            if (sum < A.get(i)) {
                sum = A.get(i);
            }
            if (sum > tempSum) {
                allSums.add(sum);
            }
        }
        return allSums.size() > 0 ? Collections.max(allSums) : Collections.max(A);
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(-89, -277, -475, -480, -420));
        System.out.println(maxSubArray(arrayList));
    }
}
