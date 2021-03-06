package pl.misc.sedgewick.chap02;

import java.io.PrintStream;

import org.apache.commons.lang.ArrayUtils;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class InsertionSortSentinel {

	private static PrintStream StdOut = System.out;

	public static void sort(Comparable[] a) {

		show(a);
		int min = 0;
		for (int i = 0; i < a.length-1; i++) {

 			if (!less(a[min], a[i + 1])) {
				min = i+1;
			}

		}
		System.out.println(min);
		System.out.println(a[min]);
		exch(a, 0, min);
		
		show(a);	
		
		for (int i = 1; i < a.length; i++) {
			for (int j = i; less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
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

	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		//String s = "31452434565682423453553342";
		String s = "9876543210";
		Character[] c_arr = ArrayUtils.toObject(s.toCharArray());
		InsertionSortSentinel.sort(c_arr);
		InsertionSortSentinel.show(c_arr);
	}
}
