package pl.misc.interviewbit.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Pallav Jha
 * @since 21/4/18
 */
public class MergeTwoSortedListsII {

    public void merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> mergedArr = new ArrayList<>(arr1.size() + arr2.size());

        int k = 0;
        for (int i = 0, j = 0; ; ) {

            if (i >= arr1.size() && j < arr2.size()) {
                while (j < arr2.size()) {
                    mergedArr.add(arr2.get(j));
                    j++;
                }
                break;
            }

            if (i < arr1.size() && j >= arr2.size()) {
                while (i < arr1.size()) {
                    mergedArr.add(arr1.get(i));
                    i++;
                }
                break;
            }

            if (arr1.get(i) < arr2.get(j)) {
                mergedArr.add(arr1.get(i));
                i++;
            } else {
                mergedArr.add(arr2.get(j));
                j++;
            }

            if (i >= arr1.size() && j >= arr2.size()) {
                break;
            }
        }
        //System.out.println(mergedArr);
        arr1.clear();
        mergedArr.forEach(arr1::add);
    }

    public static void main(String[] args) {
        MergeTwoSortedListsII obj = new MergeTwoSortedListsII();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        obj.merge(a, b);
        System.out.println(a);
    }

}
