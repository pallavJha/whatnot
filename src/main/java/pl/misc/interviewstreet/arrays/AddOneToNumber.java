package pl.misc.interviewstreet.arrays;

import java.util.ArrayList;

/**
 * Given a non-negative number represented as an array of digits,
 * <p>
 * add 1 to the number ( increment the number represented by the digits ).
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example:
 * <p>
 * If the vector has [1, 2, 3]
 * <p>
 * the returned vector should be [1, 2, 4]
 * <p>
 * as 123 + 1 = 124.
 *
 * @author pallav
 * @version 1.0
 * @since 24/2/18
 */
public class AddOneToNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        plusOne(A, A.size() - 1);
        while (A.get(0) != null && A.get(0).equals(0)) {
            A.remove(0);
        }
        return A;
    }

    private void plusOne(ArrayList<Integer> A, int index) {
        if (index == -1) {
            A.add(0, 0);
            index = 0;
        }
        int sum = A.get(index) + 1;
        int carry = sum / 10;
        int actualSum = sum % 10;
        A.set(index, actualSum);
        if (carry > 0) {
            plusOne(A, index - 1);
        }
    }

    public ArrayList<Integer> plusOneAnotherSolution(ArrayList<Integer> A) {
        String numAsString = A.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll("\\s", "");
        java.math.BigInteger a = new java.math.BigInteger(numAsString);
        a = a.add(java.math.BigInteger.ONE);
        numAsString = a.toString();
        ArrayList<Integer> returnVal = new ArrayList<>(numAsString.length());
        for (int i = 0; i < numAsString.length(); i++) {
            returnVal.add(numAsString.charAt(i) - '0');
        }
        return returnVal;
    }
}
