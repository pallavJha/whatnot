package pl.misc.hackerRank;

import java.util.Scanner;

public class LargestRectangle {

	public static void main(String[] args) {
		// input and closing the scanner
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] min_arr = new int[n];
		int[] area = new int[n];
		int new_area1 = 0;
		int new_area2 = 0;
		int count = 1;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		// initial calculation for minimum number
		minimumTill(arr, min_arr, 0);

		// calculating area
		area[0] = arr[0];
		for (int i = 1; i < n; i++) {
			if (min_arr[i - 1] < arr[i]) {
				new_area1 = min_arr[i - 1] * (++count);
			} else {
				new_area1 = arr[i] * (++count);
				minimumTill(arr, min_arr, i);
			}
			new_area2 = arr[i];
			if (new_area1 > new_area2) {
				area[i] = new_area1;
			} else {
				area[i] = new_area2;
				minimumTill(arr, min_arr, i);
				count = 1;
			}
		}
		calculateMax(area);
	}
	

	static void minimumTill(int[] arr, int[] min_arr, int start_index) {
		min_arr[start_index] = arr[start_index];
		for (int i = start_index + 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				min_arr[i] = arr[i];
			} else {
				min_arr[i] = min_arr[i - 1];
			}
		}
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	static void calculateMax(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if(max < arr[i]){
				max = arr[i];
			}
		}
		System.out.println(max);
	}
}