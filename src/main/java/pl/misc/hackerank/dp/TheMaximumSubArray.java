package pl.misc.hackerank.dp;

import java.util.Scanner;

/**
 * Kadane’s Algorithm:
 *
 * Initialize: max_so_far = 0 max_ending_here = 0
 *
 * Loop for each element of the array (a) max_ending_here = max_ending_here +
 * a[i] (b) if(max_ending_here < 0) max_ending_here = 0 (c) if(max_so_far <
 * max_ending_here) max_so_far = max_ending_here return max_so_far
 */

public class TheMaximumSubArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nOOfTestCases = sc.nextInt();
		for (int i = 0; i < nOOfTestCases; i++) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int j = 0; j < size; j++) {
				arr[j] = sc.nextInt();
			}
			int[] op = runKadaneAlgo(arr);
			System.out.println(op[0] + " " + op[1]);
		}
		sc.close();
	}

	public static int[] runKadaneAlgo(int[] arr) {
		int maxEndingHere = 0;
		int maxSoFar = 0;
		int allPositiveSum = 0;
		int maxElem = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxElem) {
				maxElem = arr[i];
			}
			maxEndingHere = maxEndingHere + arr[i];
			if (arr[i] > 0) {
				allPositiveSum += arr[i];
			}
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}
		if (allPositiveSum == 0) {
			allPositiveSum = maxSoFar = maxElem;
		}
		return new int[] { maxSoFar, allPositiveSum };
	}

}