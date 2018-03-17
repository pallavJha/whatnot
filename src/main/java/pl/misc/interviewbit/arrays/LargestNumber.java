package pl.misc.interviewbit.arrays;

import java.util.*;

/**
 * interviewbit Largest Number Solution
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * For example:
 * <p>
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * @author pallav
 * @version 1.0
 * @since 3/3/18
 */
public class LargestNumber {

    public String largestNumber(final List<Integer> A) {
        ArrayList<String> stringList = new ArrayList<>();
        for (Integer a : A) {
            stringList.add(a.toString());
        }

        Comparator<String> comp = (o1, o2) -> {
            //o1 = 3345, o2 = 33452
            return (o1 + o2).compareTo(o2 + o1);
        };

        Collections.sort(stringList, comp.reversed());
        return stringList.toString()
                .replaceAll(", ", "")
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll("^0+", "0");
    }

}
