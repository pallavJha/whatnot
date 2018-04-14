package pl.misc.interviewbit.strings;

/**
 * @author Pallav Jha
 * @since 15/4/18
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(final String A) {
        int spaceLocation = 0;
        String B = A.trim();
        for (int i = B.length() - 1; i > -1; i--) {
            if (B.charAt(i) == ' ') {
                spaceLocation = i + 1;
                break;
            }
        }
        return B.length() - spaceLocation;
    }

    public static void main(String[] args) {
        LengthOfLastWord obj = new LengthOfLastWord();
        System.out.println(obj.lengthOfLastWord("Hello World!"));
        System.out.println(obj.lengthOfLastWord("HelloWorld!"));
        System.out.println(obj.lengthOfLastWord("H   "));
    }
}
