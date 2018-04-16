package pl.misc.interviewbit.strings;

import java.util.ArrayList;

/**
 * @author Pallav Jha
 * @since 16/4/18
 */
public class Atoi {
    public int atoi(final String A) {
        // 48, 57
        int startIndex = 0;
        boolean negative = false;
        if (A.charAt(0) == '-') {
            startIndex = 1;
            negative = true;
        }
        if (A.charAt(0) == '+') {
            startIndex = 1;
            negative = false;
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = startIndex; i < A.length(); i++) {
            if (A.charAt(i) > 47 && A.charAt(i) < 58) {
                numbers.add(A.charAt(i) - 48);
            } else {
                break;
            }
        }
        //System.out.println(numbers);
        int number = 0;
        for (int i = 0; i < numbers.size(); i++) {
            number += numbers.get(i) * Math.pow(10, numbers.size() - 1 - i);
        }
        if (number < 0) {
            number = Integer.MAX_VALUE;
        }
        return negative ? (number == Integer.MAX_VALUE ? Integer.MIN_VALUE : -number) : number;
    }
}
