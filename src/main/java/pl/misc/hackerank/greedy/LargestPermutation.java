package pl.misc.hackerank.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LargestPermutation {
	
	private static Integer[] arr, sortedArr;
	private static Map<Integer, Integer> indexMap = new HashMap<>(); 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		arr = new Integer[n];
		sortedArr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sortedArr[i] = arr[i];
			indexMap.put(arr[i], i);
		}
		
		Arrays.sort(sortedArr, Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			int[] valAndIndex = findMax(i);
			if (valAndIndex[1] != i) {
				arr[valAndIndex[1]] = arr[i];
				arr[i] = valAndIndex[0];
				k--;
				updateIndexMap(valAndIndex[0], i, arr[valAndIndex[1]], valAndIndex[1]);
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

	private static int[] findMax(int initialIndex) {
		int max = sortedArr[initialIndex];
		int index = indexMap.get(max);
		return new int[] { max, index };
	}
	
	private static void updateIndexMap(int newValue, int newIndex, int oldValue, int oldIndex) {
		indexMap.put(newValue, newIndex);
		indexMap.put(oldValue, oldIndex);
	}
}