package pl.misc.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>interviewbit Find Duplicate In Array Solution</h1>
 * <p>
 * <p>
 * <p>
 * <p>
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
 * <p>
 * Sample Input:
 * <p>
 * [3 4 1 4 1]
 * Sample Output:
 * <p>
 * 1
 * If there are multiple possible answers ( like in the sample case above ), output any one.
 * <p>
 * If there is no duplicate, output -1
 *
 * @author pallav
 * @version 1.0
 * @apiNote <a href = "https://www.interviewbit.com/problems/find-duplicate-in-array/">Find Duplicate In Array</a>
 * @since 10/3/18
 */
public class FindDuplicateInArray {

    public static int repeatedNumber(final List<Integer> a) {
        List<Integer> b = new ArrayList<>(a);
        for (int i = 0; i < b.size(); i++) {
            int actualPosition = b.get(Math.abs(b.get(i)) - 1);
            if (actualPosition > 0) {
                b.set(Math.abs(b.get(i)) - 1, -actualPosition);
            } else {
                return Math.abs(b.get(i));
            }
        }
        return 0;
    }
}
