package pl.misc.interviewbit.strings;

/**
 * @author Pallav Jha
 * @since 15/4/18
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] A) {

        int minLength = Integer.MAX_VALUE;
        int shortStringIndex = 0;
        for (int i = 0; i < A.length; i++) {
            String a = A[i];
            if (a.length() < minLength) {
                minLength = a.length();
                shortStringIndex = i;
            }
        }

        int i = 0;
        outer:
        for (; i < A[shortStringIndex].length(); i++) {
            int currentChar = A[shortStringIndex].charAt(i);
            for (String a : A) {
                if (a.charAt(i) != currentChar) {
                    break outer;
                }
            }
        }

        if (i == A[0].length()) {
            return A[0];
        }
        return A[0].substring(0, i);
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String str = obj.longestCommonPrefix(new String[]{

                "abcdefgh",

                "abcdefgh",

                "abcdefgh"
        });
        System.out.println(str);
    }
}
