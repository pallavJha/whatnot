package pl.misc.hackerank;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class SherlockAndMiniMax {

	public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main2(String... strings) {
		long start = System.currentTimeMillis();

		for (int i = 70283784; i <= 302962359; i++) {
			for (int j = 0; j < 73; j++) {

			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		int i = 55;
		System.out.println(~i);
	}

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int temp_arr[] = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int p = sc.nextInt();
		int q = sc.nextInt();

		sc.close();

		int temp = p;
		
		Arrays.sort(arr);
		
		for (int i = 0; i < n; i++) {
			temp_arr[i] = Math.abs(arr[i] - temp);
		}
		
		int min = findMinimum(temp_arr);
		if (min != 0) {
			map.put(temp, min);
		}
		System.out.println(temp);
		printArray(temp_arr);
		System.out.println(min);
		temp++;
		
		
		while (temp <= q) {
			for (int i = 0; i < n; i++) {
				temp_arr[i] = Math.abs(temp_arr[i] - 1);
			}
			
			min = findMinimum(temp_arr);
			if (min != 0) {
				map.put(temp, min);
			}
			System.out.println(temp);
			printArray(temp_arr);
			System.out.println(min);
			temp++;
		}

		int max = findMaximumFromMapVal(map);
		printMinimum(map, max);
	}

	public static int findMinimum(int[] arr) {

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}

	public static int findMaximumFromMapVal(HashMap<Integer, Integer> map) {
		return Collections.max(map.values());
	}

	public static void printMinimum(HashMap<Integer, Integer> map, int max) {
		Iterator<Integer> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			int temp_key = iter.next();
			if (map.get(temp_key) == max) {
				System.out.println(temp_key);
				break;
			}
		}
	}
	
	public static void printArray(int[] arr){
		for(int i = 0 ; i < arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}