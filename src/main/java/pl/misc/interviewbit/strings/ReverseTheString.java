package pl.misc.interviewbit.strings;

/**
 * @author Pallav Jha
 * @since 15/4/18
 */
public class ReverseTheString {
    public String reverseWords(String a) {
        a = a.trim();
        a = a.replaceAll("\\s+", " ");
        String[] words = a.split(" ");
        for (int i = 0; i < words.length / 2; i++) {
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReverseTheString obj = new ReverseTheString();
        System.out.println(obj.reverseWords("the sky is blue"));
        System.out.println(obj.reverseWords("  the sky is blue  "));
        System.out.println(obj.reverseWords("the sky is    blue"));
    }
}
