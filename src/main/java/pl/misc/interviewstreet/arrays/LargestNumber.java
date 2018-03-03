package pl.misc.interviewstreet.arrays;

import java.util.*;

/**
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
