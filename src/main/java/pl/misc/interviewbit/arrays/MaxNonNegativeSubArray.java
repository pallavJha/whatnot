package pl.misc.interviewbit.arrays;

import java.util.*;

/**
 * interviewbit Max Non Negative SubArray Solution
 * Find out the maximum sub-array of non negative numbers from an array.
 * The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * <p>
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 * <p>
 * Example:
 * <p>
 * A : [1, 2, 5, -7, 2, 3]
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3]
 * NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 * NOTE 2: If there is still a tie, then return the segment with minimum sta
 *
 * @author pallav
 * @version 1.0
 * @since 2/3/18
 */
public class MaxNonNegativeSubArray {

    public static ArrayList<Integer> maximumSubArray(ArrayList<Integer> A) {
        Iterator<Integer> iter = A.iterator();
        Map<Long, ArrayList<Integer>> sumToElements = new HashMap<>();

        long sum = 0;
        ArrayList<Integer> elementsForSum = new ArrayList<>();


        while (iter.hasNext()) {
            int currElem = iter.next();
            if (currElem > -1) {
                elementsForSum.add(currElem);
                sum += currElem;
            }
            if (currElem < 0 || !iter.hasNext()) {
                ArrayList<Integer> prevElements = sumToElements.get(sum);
                if (prevElements == null || prevElements.isEmpty()) {
                    sumToElements.put(sum, elementsForSum);
                } else {
                    prevElements = prevElements.size() > elementsForSum.size() ? prevElements : elementsForSum;
                }

                elementsForSum = new ArrayList<>();
                sum = 0;
            }
        }

        if (sumToElements.size() > 0) {
            long maxSum = Collections.max(sumToElements.keySet());
            return sumToElements.get(maxSum);
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(756898537);
        arrayList.add(-1973594324);
        arrayList.add(-2038664370);
        arrayList.add(-184803526);
        arrayList.add(1424268980);

        System.out.println(maximumSubArray(arrayList));
    }
}
