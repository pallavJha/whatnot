package pl.misc.interviewstreet.arrays;

import java.util.*;

/**
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
