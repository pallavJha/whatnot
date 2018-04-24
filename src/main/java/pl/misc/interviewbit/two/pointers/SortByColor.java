package pl.misc.interviewbit.two.pointers;

import java.util.ArrayList;

/**
 * @author Pallav Jha
 * @since 25/4/18
 */
public class SortByColor {

    public void sortColors(ArrayList<Integer> colors) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for (int i = 0 ; i < colors.size(); i++) {
            switch (colors.get(i)) {
                case 0:
                    zeroCount++;
                    break;
                case 1:
                    oneCount++;
                    break;
                case 2:
                    twoCount++;
                    break;
                default:
                    System.out.println("Why?");
            }
        }

        int index = 0;
        while (zeroCount > 0) {
            colors.set(index++, 0);
            zeroCount--;
        }
        while (oneCount > 0) {
            colors.set(index++, 1);
            oneCount--;
        }
        while (twoCount > 0) {
            colors.set(index++, 2);
            twoCount--;
        }

    }
}
