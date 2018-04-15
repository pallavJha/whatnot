package pl.misc.interviewbit.strings;

/**
 * @author Pallav Jha
 * @since 15/4/18
 */
public class MinimumCharactersPalindromic {

    public int minChars(String A) {
        int additions = 0;
        for (int i = 0, j = A.length() - 1; i < j; j--) {
            System.out.println(i + " " + A.charAt(i) + ", " + j + " " + A.charAt(j));
            if (A.charAt(i) == A.charAt(j)) {
                i++;
                System.out.println("Already Present");
            } else {
                additions++;
                System.out.println("Added");
            }
        }
        return additions;
    }

    public static void main(String[] args) {
        MinimumCharactersPalindromic obj = new MinimumCharactersPalindromic();
        //System.out.println(obj.minChars("ABC"));
        //System.out.println(obj.minChars("BAACECAAAAA"));
        //System.out.println(obj.minChars("ABBCD"));//DCBBABBCD
        System.out.println(obj.minChars("ABEACBBC"));
        //System.out.println(obj.minChars("HQGHUMEAYLNLFDXFI"));//HQGHUMEAYLNLFDXFI
    }
}
