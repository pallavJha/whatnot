package pl.misc.hackerank.greedy;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GoodlandElectricity {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// Map<Integer, Integer> adjMatrix;
		try {
			int towersCount = getTowersCount(arr, n, k);
			System.out.println(towersCount);
			// System.out.println(getNoOfTowers(adjMatrix));
		} catch (IOException e) {
			System.out.println(-1);
		}
		sc.close();
	}

	// private static Map<Integer, Integer> getAdjacencyList(int[] arr, int n,
	// int k) throws IOException {
	private static int getTowersCount(int[] arr, int n, int k) throws IOException {
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> usedTowers = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int max = -1;
			Set<Integer> adjacencySet = new HashSet<>(2 * k - 1);
			Integer prevTowerLocation = map.get(i - 1);
			prevTowerLocation = prevTowerLocation == null ? -1 : prevTowerLocation;
			int distanceWithPrevTower = Math.abs(i - prevTowerLocation);
			if (prevTowerLocation != -1 && distanceWithPrevTower < k) {
				max = prevTowerLocation;
			} else {
				for (int j = i; j < i + k && j < n; j++) {
					if (arr[j] > 0) {
						adjacencySet.add(j);
					}
				}
				for (int j = i; j > -1 && j > i - k; j--) {
					if (arr[j] > 0) {
						adjacencySet.add(j);
					}
				}
			}
			if (adjacencySet.isEmpty() && max == -1) {
				throw new IOException();
			}
			if (max == -1) {
				max = Collections.max(adjacencySet);
			}
			map.put(i, max);
			usedTowers.add(max);
			max = 0;
		}
		return usedTowers.size();
	}
}