package pl.misc.interviewbit.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Pallav Jha
 * @since 25/4/18
 */
public class RemoveElementFromArray {

    public int removeElementFromArray(ArrayList<Integer> a, int b) {
        for (int  i = a.size() - 1; i > -1; i--) {
            if (a.get(i) == b) {
                a.remove(i);
            }
        }
        return a.size();
    }


    public static void main(String[] args) {
        RemoveElementFromArray obj= new RemoveElementFromArray();
        System.out.println(obj.removeElementFromArray(new ArrayList<>(Arrays.asList(1,1,1,1,121,1)), 1));


    }
}
