package pl.misc.pi;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author pallav
 * @version 1.0
 * @since 15/6/17
 */
public class TestOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            List<List<Integer>> listList = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                List<Integer> list = new LinkedList<>();
                for (int k = 0; k < n; k++) {
                    list.add(sc.nextInt());
                }
                listList.add(list);
            }
            encode2DArray(listList);
        }
    }

    private static void encode2DArray(List<List<Integer>> listList) {
        while (listList != null) {
            firstHorizontal(listList);
            if (listList.size() > 0) {
                lastVertical(listList);
            } else {
                break;
            }
            if (listList.size() > 0) {
                lastHorizontalReverse(listList);
            } else {
                break;
            }
            if (listList.size() > 0) {
                firstVerticalReverse(listList);
            } else {
                break;
            }
        }
        System.out.println();
    }

    private static void firstHorizontal(List<List<Integer>> listList) {
        listList.get(0).forEach(t -> {
            System.out.print(t + " ");
        });
        listList.remove(0);
    }

    private static void lastVertical(List<List<Integer>> listList) {
        listList.forEach(list -> {
            System.out.print(list.get(list.size() - 1) + " ");
            list.remove(list.size() - 1);
        });
    }

    private static void lastHorizontalReverse(List<List<Integer>> listList) {
        List<Integer> lastList = listList.get(listList.size() - 1);
        for (int i = lastList.size() - 1; i > -1; i--) {
            System.out.print(lastList.get(i) + " ");
        }
        listList.remove(listList.size() - 1);
    }

    private static void firstVerticalReverse(List<List<Integer>> listList) {
        ListIterator<List<Integer>> iterator = listList.listIterator(listList.size());
        while (iterator.hasPrevious()) {
            List<Integer> list = iterator.previous();
            System.out.print(list.get(0) + " ");
            list.remove(0);
        }

    }
}
