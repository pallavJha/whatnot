package pl.misc.interviewbit.binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * interviewbit Count Element Occurrence solution
 * Given a sorted array of integers, find the number of occurrences of a given target value.
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return 0
 * <p>
 * *Example : **
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return 2.
 * <p>
 * PROBLEM APPROACH :
 * <p>
 * For complete solution, look at the hint.
 *
 * @author Pallav Jha
 * @since 17/3/18
 */
public class SearchForARange {

    public static ArrayList<Integer> findCount(final List<Integer> A, int B) {
        ArrayList<Integer> returnList = new ArrayList<>(2);
        int location = 0;
        int index = -1;
        int low = 0;
        int high = A.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int currentElement = A.get(mid);
            if (currentElement == B) {
                index = mid;
                break;
            }
            if (B > currentElement) {
                low = mid + 1;
            } else if (B < currentElement) {
                high = mid - 1;
            }
        }
        if (index == -1) {
            returnList.add(-1);
            returnList.add(-1);
            return returnList;
        }
        if (index == 0) {
            for (int i = 0; i < A.size(); i++) {
                if (B == A.get(i)) {
                    location = i;
                } else {
                    break;
                }
            }
            returnList.add(0);
            returnList.add(location);
            return returnList;
        }
        if (index == A.size() - 1) {
            for (int i = A.size() - 1; i > -1; i--) {
                if (B == A.get(i)) {
                    location = i;
                } else {
                    break;
                }
            }
            returnList.add(location);
            returnList.add(index);
            return returnList;
        }

        if (A.get(index - 1) == B) {
            for (int i = index - 1; i > -1; i--) {
                if (B == A.get(i)) {
                    location = i;
                } else {
                    break;
                }
            }
        } else {
            location = index;
        }
        returnList.add(location);
        if (A.get(index + 1) == B) {
            for (int i = index + 1; i < A.size(); i++) {
                if (B == A.get(i)) {
                    location = i;
                } else {
                    break;
                }
            }
        } else {
            location = index;
        }
        returnList.add(location);

        return returnList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 7, 7, 8, 8, 10));
        System.out.println(findCount(arrayList, 5));
        System.out.println(findCount(arrayList, 10));
        System.out.println(findCount(arrayList, 8));
        System.out.println(findCount(arrayList, 81));


    }
}
