package pl.misc.sedgewick.chap02;

import java.io.PrintStream;

@SuppressWarnings("rawtypes") 
public class AbstractIn_PlaceMerge {

	private static PrintStream StdOut = System.out;

	public static void main(String... args) {
		Character[] a = {'E', 'E', 'G', 'M', 'R', 'A', 'C', 'E', 'R', 'T'};
		
		show(a);
		merge(a, 0, 4, 9);
		show(a);
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		Comparable[] aux = new Comparable[a.length];
		for (int k = lo; k <= hi; k++) {
			aux[k] = (Character) a[k];
			a[k] = ' ';
		}
		for (int k = lo; k <= hi; k++) {
			
			if (i > mid) {
				a[k] = aux[j++];
				StdOut.println("1");
				System.out.println("i "+i+", j "+j+", mid "+mid);
				show(a);
			}
			else if (j > hi) {
				a[k] = aux[i++];
				StdOut.println("2");
				System.out.println("i "+i+", j "+j+", mid "+mid);
				show(a);
			}
			else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
				StdOut.println("3");
				System.out.println("i "+i+", j "+j+", mid "+mid);
				show(a);
			}
			else {
				a[k] = aux[i++];
				StdOut.println("4");
				System.out.println("i "+i+", j "+j+", mid "+mid);
				show(a);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	@SuppressWarnings("unused")
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print("-" + " ");
		}
		StdOut.println();
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
		for (int i = 0; i < a.length; i++) {
			StdOut.print("-" + " ");
		}
		StdOut.println();
	}
}