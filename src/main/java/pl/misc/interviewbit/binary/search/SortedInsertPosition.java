package pl.misc.interviewbit.binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * interviewbit solution Search For A Range
 * <p>Given a sorted array of integers, find the starting and ending position of a given target value.</p>
 * <p>
 * <p>Your algorithm’s runtime complexity must be in the order of <code>O(log n)</code>.</p>
 * <p>
 * <p>If the target is not found in the array, return <code>[-1, -1]</code>.</p>
 * <p>
 * <p><strong>Example:</strong></p>
 * <p>
 * <p>Given <code>[5, 7, 7, 8, 8, 10]</code></p>
 * <p>
 * <p>and target value <code>8</code>,</p>
 * <p>
 * <p>return <code>[3, 4]</code>.</p>
 * <p>
 *
 * @author Pallav Jha
 * @since 17/3/18
 */
public class SortedInsertPosition {

    public static int getPosition(final List<Integer> A, int B) {
        int index = binarySearch(A, B);
        return index > -1 ? index : Math.abs(index + 1);
    }


    public static int binarySearch(List<Integer> A, int target) {

        int low = 0;
        int high = A.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int currentElem = A.get(mid);
            if (currentElem == target) {
                return mid;
            } else {
                if (target > currentElem) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -(low + 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 3, 5, 6));
        System.out.println(getPosition(arrayList, 5));
        System.out.println(getPosition(arrayList, 2));
        System.out.println(getPosition(arrayList, 7));
        System.out.println(getPosition(arrayList, 0));
    }
}
