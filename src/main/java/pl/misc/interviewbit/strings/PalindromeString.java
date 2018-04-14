package pl.misc.interviewbit.strings;

/**
 * @author Pallav Jha
 * @since 15/4/18
 */
public class PalindromeString {

    public int isPalindrome(String a) {
        if (a.length() == 1) {
            return 1;
        }
        a = a.replaceAll("[^\\w\\d]", "");
        int loopCount = a.length() / 2;
        for (int i = 0; i < loopCount; i++) {
            int firstChar = a.charAt(i);
            int toCompareWith = a.charAt(a.length() - 1 - i);
            if (firstChar > 96) {
                firstChar = firstChar - 32;
            }
            if (toCompareWith > 96) {
                toCompareWith = toCompareWith - 32;
            }
            if (firstChar != toCompareWith) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        PalindromeString obj = new PalindromeString();
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(obj.isPalindrome("race a car"));
    }

    private PalindromeString() {
    }
}
