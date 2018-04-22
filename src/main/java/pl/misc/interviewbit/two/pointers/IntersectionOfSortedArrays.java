package pl.misc.interviewbit.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Pallav Jha
 * @since 21/4/18
 */
public class IntersectionOfSortedArrays {


    public ArrayList<Integer> intersect(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {

        ArrayList<Integer> intersectionArray = new ArrayList<>(arr1.size() > arr2.size() ? arr2.size() : arr1.size());
        for (int i = 0, j = 0; i < arr1.size() && j < arr2.size(); ) {
            if (arr1.get(i) < arr2.get(j)) {
                i++;
            } else if (arr1.get(i) > arr2.get(j)) {
                j++;
            } else {
                intersectionArray.add(arr1.get(i));
                i++;
                j++;
            }
        }
        return intersectionArray;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 6));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(3, 5));

        IntersectionOfSortedArrays obj = new IntersectionOfSortedArrays();

        System.out.println(obj.intersect(arr1, arr2));
    }
}
