package pl.misc.interviewstreet.arrays;

import java.util.*;

/**
 * @author pallav
 * @version 1.0
 * @since 1/3/18
 */
public class RepeatAndMissingNumberArray {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        int max = A.length;
        int sum = max * (max + 1) / 2;
        int thisSum = Arrays.stream(A).sum();


        int sqSum = max * (max + 1) * (2 * max + 1) / 6;
        int thisSqSum = Arrays.stream(A).map(i -> i * i).sum();

        int abDiff = thisSum - sum;
        int abSum = (thisSqSum - sqSum) / (abDiff);

        int a = (abSum + abDiff) / 2;
        int b = abSum - a;

        return new int[]{a, b};
    }
}
