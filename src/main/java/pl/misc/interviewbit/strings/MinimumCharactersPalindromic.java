package pl.misc.interviewbit.strings;

/**
 * @author Pallav Jha
 * @since 15/4/18
 */
public class MinimumCharactersPalindromic {

    public int minChars(String A) {
        String aWithItsReverse = A + "$" + new StringBuilder(A).reverse().toString();
        int[] lps = prepareLPSArray(aWithItsReverse);
        return A.length() - lps[lps.length - 1];
    }


    private int[] prepareLPSArray(String A) {
        int[] lps = new int[A.length()];
        int i = 1;
        int len = 0;
        lps[0] = 0;

        while (i < A.length()) {
            if (A.charAt(len) == A.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        MinimumCharactersPalindromic obj = new MinimumCharactersPalindromic();
        System.out.println(obj.minChars("ABC"));
        System.out.println(obj.minChars("BAACECAAAAA"));
        System.out.println(obj.minChars("ABBCD"));//DCBBABBCD
        System.out.println(obj.minChars("ABEACBBC"));
        System.out.println(obj.minChars("HQGHUMEAYLNLFDXFI"));//HQGHUMEAYLNLFDXFI
    }
}
