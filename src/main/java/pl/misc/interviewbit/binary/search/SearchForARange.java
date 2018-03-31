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
public class SearchForARange {

    public static ArrayList<Integer> findCount(final List<Integer> A, int B) {

        ArrayList<Integer> returnList = new ArrayList<>(2);
        int index = binarySearch(A, B);
        if (index < 0) {
            returnList.add(-1);
            returnList.add(-1);
            return returnList;
        } else {
            returnList.add(index);
            returnList.add(index);
        }
        int leftIndex = binarySearch(A, B - 1);
        leftIndex = leftIndex < 0 ? Math.abs(leftIndex + 1) : leftIndex;
        if (leftIndex > -1) {
            for (int i = leftIndex; i <= index; i++) {
                if (A.get(i) == B) {
                    returnList.set(0, i);
                    break;
                }
            }
        }

        int rightIndex = binarySearch(A, B + 1);
        rightIndex = rightIndex < 0 ? Math.abs(rightIndex + 1) : rightIndex;
        if (rightIndex > -1) {
            for (int i = rightIndex; i >= index; i--) {
                if (i < A.size() && A.get(i) == B) {
                    returnList.set(1, i);
                    break;
                }
            }
        }
        return returnList;
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
                if (target < currentElem) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -(low + 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 7, 7, 8, 8, 10, 10, 10));
        System.out.println(findCount(arrayList, 5));
        System.out.println(findCount(arrayList, 7));
        System.out.println(findCount(arrayList, 10));
        System.out.println(findCount(arrayList, 45));

        arrayList = new ArrayList<>(Arrays.asList(10, 10, 10));
        System.out.println(findCount(arrayList, 10));

    }
}
