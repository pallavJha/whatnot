package pl.misc.interviewbit.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Pallav Jha
 * @since 24/4/18
 */
public class RemoveDuplicatesSortedArrayII {

    public int removeDuplicates(ArrayList<Integer> a) {

        int prevElem = Integer.MAX_VALUE;
        int currElem = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(currElem) || !a.get(i).equals(prevElem)) {
                count++;
            }
            prevElem = i != 0 ? a.get(i - 1) : Integer.MAX_VALUE;
            currElem = a.get(i);
        }

        System.out.println(a);
        for (int i = a.size() - 1; i > 1; i--) {
            if (a.get(i).equals(a.get(i - 1)) && a.get(i).equals(a.get(i - 2))) {
                a.remove(i);
            }
        }
        System.out.println(a);
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedArrayII obj = new RemoveDuplicatesSortedArrayII();
        System.out.println(obj.removeDuplicates(new ArrayList<>(Arrays.asList(0, 1, 1, 2, 2, 3, 3, 3, 3))));
        System.out.println(obj.removeDuplicates(new ArrayList<>(Arrays.asList(1, 1, 2))));
    }
}
