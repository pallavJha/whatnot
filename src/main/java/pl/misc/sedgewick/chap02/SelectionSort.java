package pl.misc.sedgewick.chap02;

import java.io.PrintStream;

import org.apache.commons.lang.ArrayUtils;

@SuppressWarnings({ "rawtypes", "unchecked"})
public class SelectionSort {

    private static PrintStream StdOut = System.out;

    public static void sort(Comparable[] a) {
        show(a);
        for (int i = 0 ; i < a.length ; i++) {

            int min = i;

            for (int j = i + 1 ; j < a.length ; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }

            exch(a, i, min);
            show(a);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0 ; i < a.length ; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1 ; i < a.length ; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "SORTEXAMPLE";
        Character[] c_arr = ArrayUtils.toObject(s.toCharArray());
        SelectionSort.sort(c_arr);
        SelectionSort.show(c_arr);
    }
}
