package pl.misc.interviewbit.binary.search;

/**
 * interviewbit Count Element Occurence solution
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
public class CountElementOccurrence {

    public static int findCount(final int[] A, int B) {
        int count = 0;
        int index = -1;
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int currentElement = A[mid];
            if (currentElement == B) {
                index = mid;
                break;
            }
            if (B > currentElement) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (index == -1) {
            return 0;
        }
        if (index == 0) {
            for (int i = 0; i < A.length; i++) {
                if (B == A[i]) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }
        if (index == A.length - 1) {
            for (int i = A.length - 1; i > -1; i--) {
                if (B == A[i]) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }
        count++;
        if (A[index + 1] == B) {
            for (int i = index + 1; i < A.length; i++) {
                if (B == A[i]) {
                    count++;
                } else {
                    break;
                }
            }
        }

        if (A[index - 1] == B) {
            for (int i = index - 1; i > -1; i--) {
                if (B == A[i]) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10};
        int res = findCount(arr, 1);
        System.out.println(res);


    }
}
