package pl.misc.hackerank.woc22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Pallav
 * on 21-08-2016.
 */
/*
3
1 2 3
-1 4 3
*/
public class MatchingSets {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int listLength = sc.nextInt();
        List<Long> xMultiSet = fetchInputForMultiSet(listLength, sc);
        List<Long> yMultiSet = fetchInputForMultiSet(listLength, sc);
        Collections.sort(xMultiSet);
        Collections.sort(yMultiSet);
        List<Long> diffMultiSet = fetchDifferenceList(xMultiSet, yMultiSet);
        System.out.println(diffMultiSet);
        long actualDiff = diffMultiSet.stream().reduce(0L, (sum, i) -> sum + i);
        if (actualDiff == 0) {
            actualDiff = diffMultiSet.stream().reduce(0L, (sum, i) -> sum + Math.abs(i));
            System.out.println(actualDiff);
            System.out.println(actualDiff / 2);
        } else {
            System.out.println(-1);
        }
        sc.close();
    }

    private static List<Long> fetchInputForMultiSet(int size, Scanner sc) {
        List<Long> multiSet = new ArrayList<>(size);
        IntStream.range(0, size)
                .forEach(i -> multiSet.add(sc.nextLong()));
        return multiSet;
    }

    private static List<Long> fetchDifferenceList(List<Long> x, List<Long> y) {
        List<Long> diffList = new ArrayList<>(x.size());
        IntStream.range(0, x.size())
                .forEach(i -> diffList.add(x.get(i) - y.get(i)));
        return diffList;
    }

    private MatchingSets() {
    }
}
