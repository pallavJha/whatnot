package pl.misc.prep.java8.chap03;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Find the String with the largest number of lowercase letters from a List<String>. You can return
 * an Optional<String> to account for the empty list case.
 *
 * @author pallav
 * @version 1.0
 * @since 9/7/16
 */
public class Q07 {

    private Q07() {
    }

    private static List<String> createStringList() {
        List<String> stringList = new LinkedList<>();
        stringList.add("New Delhi");
        stringList.add("Bombay");
        stringList.add("Chennai");
        stringList.add("Calcutta");
        stringList.add("Bangalore");
        return stringList;
    }

    private static String getStringWithMaxLowerCaseLetters(List<String> stringList) {
        Map<Long, String> map =
                IntStream.range(0, stringList.size())
                        .boxed()
                        .collect(Collectors.toMap(i -> Q06.count(stringList.get(i)), i -> stringList.get(i), (s, a) -> s + ", " + a));

        Long key = map.keySet()
                .stream().max(Comparator.naturalOrder()).get();
        return map.get(key).toString();
    }

    /**
     * Main Method
     *
     * @param args run time arguments
     */
    public static void main(String... args) {
        List<String> stringList = createStringList();
        System.out.println(getStringWithMaxLowerCaseLetters(stringList));
    }
}
