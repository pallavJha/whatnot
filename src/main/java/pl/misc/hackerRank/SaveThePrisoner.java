package pl.misc.hackerRank;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author pallav
 * @version 1.0
 * @since 16/7/16
 */
public class SaveThePrisoner {

    public static final Scanner sc = new Scanner(System.in);

    /**
     * Main
     *
     * @param args runtime args
     */
    public static void main(String[] args) {
        int noOfTestCases = sc.nextInt();
        IntStream.range(0, noOfTestCases)
                .map(i -> findTheLastPrisoner())
                .forEach(System.out::println);
    }

    private static int findTheLastPrisoner() {
        int noOfPrisoners = sc.nextInt();
        int noOfSweets = sc.nextInt();
        int startPrisonerId = sc.nextInt();
        int number = (noOfSweets - 1 + startPrisonerId);
        if (number > noOfPrisoners) {
            int toReturn = number % noOfPrisoners;
            return toReturn != 0 ? toReturn : noOfPrisoners;
        }
        return number;
    }
}
