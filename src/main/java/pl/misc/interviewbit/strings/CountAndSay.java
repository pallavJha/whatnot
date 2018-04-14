package pl.misc.interviewbit.strings;

/**
 * @author Pallav Jha
 * @since 15/4/18
 */
public class CountAndSay {

    /**
     * The count-and-say sequence is the sequence of integers beginning as follows:
     * <p>
     * 1, 11, 21, 1211, 111221, ...
     * 1 is read off as one 1 or 11.
     * 11 is read off as two 1s or 21.
     * <p>
     * 21 is read off as one 2, then one 1 or
     * <p></p>
     * Example:
     * <p>
     * if n = 2,
     * the sequence is 11.F
     *
     * @param n
     */
    public String countAndSay(int n) {
        String currentString = "1";
        for (int i = 1; i < n; i++) {
            currentString = generateNext(currentString);
        }
        return currentString;
    }


    public String generateNext(String number) {
        StringBuilder builder = new StringBuilder();
        int currentStart = 0;
        for (int i = 0; i < number.length(); i++) {
            if (i + 1 == number.length() || number.charAt(i) != number.charAt(i + 1)) {
                builder.append(i - currentStart + 1)
                        .append(number.charAt(i));
                currentStart = i + 1;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        CountAndSay obj = new CountAndSay();
        System.out.println(obj.countAndSay(2));
    }
}
