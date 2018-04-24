package pl.misc.interviewbit.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Pallav Jha
 * @since 24/4/18
 */
public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(ArrayList<Integer> a) {

        int currElem = Integer.MAX_VALUE;
        int count = 0;
        int dupPosition = -1;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(currElem)) {
                count++;
                currElem = a.get(i);
            }
        }

        //System.out.println(a);
        for (int i = a.size() - 1; i > 0; i--) {
            if (a.get(i).equals(a.get(i - 1))) {
                a.remove(i);
                //i--;
            }
        }
        //System.out.println(a);
        return count;
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedArray obj = new RemoveDuplicatesSortedArray();
        obj.removeDuplicates(new ArrayList<>(Arrays.asList(0, 1, 1, 2, 2, 3, 3, 3, 3)));
    }
}
