package pl.misc.prep.java8.chap03;


/**
 * count the number of lower case characters in the string
 *
 * @author pallav
 * @version 1.0
 * @since 8/7/16
 */
public class Q06 {

    public static void main(String... args) {
        System.out.println(count("Pallav Jha"));
    }

    public static long count(String str) {
        return str.chars()
                .filter(ch -> ch > 96 && ch < 122)
                .count();
    }
}
