package pl.misc.hackerank.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LargestPermutation {

	private static Integer[] arr;
	private static Pair[] sortedArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		arr = new Integer[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		sortedArr = sortArr(arr);

		for (int i = 0; i < n; i++) {
			int[] valAndIndex = findMax(arr, i);
			if (valAndIndex[1] != i) {
				arr[valAndIndex[1]] = arr[i];
				arr[i] = valAndIndex[0];
				k--;
			}
			if (k == 0) {
				break;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}

	private static int[] findMax(Integer[] arr, int initialIndex) {
		int max = sortedArr[initialIndex].value;
		int index = sortedArr[initialIndex].index;
		/*
		 * for (int i = initialIndex; i < arr.length; i++) { if (max < arr[i]) {
		 * max = arr[i]; index = i; } }
		 */
		return new int[] { max, index };
	}

	private static Pair[] sortArr(Integer[] arr) {
		Pair[] sortedArr = new Pair[arr.length];
		for (int i = 0; i < arr.length; i++) {
			Pair p = new Pair(i, arr[i]);
			sortedArr[i] = p;
		}
		Arrays.sort(sortedArr, Collections.reverseOrder());
		return sortedArr;
	}
}

class Pair implements Comparable<Pair> {
	public final int index;
	public final int value;

	public Pair(int index, int value) {
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(Pair other) {
		return Integer.compare(this.value, other.value);
	}
}