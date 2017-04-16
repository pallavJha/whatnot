package pl.misc.hackerank.greedy;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndMiniMax {

	public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int p = sc.nextInt();
		int q = sc.nextInt();

		int minP = getMinimumPValue(arr, p, q);
		System.out.println(minP);
		sc.close();
	}

	public static int getMinimumPValue(int[] arr, int p, int q) {
		Data prevData = null;
		Map<Integer, Integer> minDiffToValue = new LinkedHashMap<>();
		for (int i = p; i <= q; i++) {
			if (prevData == null) {
				prevData = subtractElem(arr, i);
				minDiffToValue.putIfAbsent(prevData.min, i);
				if (prevData.valueToIndex.containsKey(prevData.min)) {
					int min = prevData.min;
					while (min > 0) {
						min--;
						i++;
						minDiffToValue.putIfAbsent(min, i);
					}
					prevData = null;
				}
			}
		}

		int maxDiff = Collections.max(minDiffToValue.keySet());
		return minDiffToValue.get(maxDiff);
	}

	public static Data subtractElem(int[] arr, int t) {
		int temp = 0;
		Map<Integer, Integer> valueToIndex = new HashMap<>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			temp = arr[i] - t;
			valueToIndex.put(temp, i);
			if (Math.abs(temp) < min) {
				min = temp;
			}
		}
		Data data = new Data();
		data.valueToIndex = valueToIndex;
		data.min = min;
		return data;
	}
}

class Data {
	public Map<Integer, Integer> valueToIndex;
	public int min;
}