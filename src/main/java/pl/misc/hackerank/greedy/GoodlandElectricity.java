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
		Map<Integer, Integer> adjMatrix;
		try {
			adjMatrix = getAdjacencyList(arr, n, k);
			System.out.println(adjMatrix);
			System.out.println(getNoOfTowers(adjMatrix));
		} catch (IOException e) {
			System.out.println(-1);
		}
		sc.close();
	}

	private static Map<Integer, Integer> getAdjacencyList(int[] arr, int n, int k) throws IOException {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			Set<Integer> adjacencySet = null;
			boolean forwardLoopRequired = true;
			if (i <= k) {
				adjacencySet = new HashSet<>(2 * k - 1);
				Integer prevTowerLocation = map.get(i - 1);
				prevTowerLocation = prevTowerLocation == null ? -1 : prevTowerLocation;
				for (int j = i; j > -1 && j > i - k; j--) {
					if (arr[j] > 0) {
						adjacencySet.add(j);
						if (prevTowerLocation.equals(j)) {
							adjacencySet = new HashSet<>();
							adjacencySet.add(j);
							forwardLoopRequired = false;
							break;
						}
					}
				}
				if (forwardLoopRequired) {
					for (int j = i; j < i + k && j < n; j++) {
						if (arr[j] > 0) {
							adjacencySet.add(j);
							if (prevTowerLocation.equals(j)) {
								adjacencySet = new HashSet<>();
								adjacencySet.add(j);
								break;
							}
						}
					}
				}
			} else {
				adjacencySet = new HashSet<>();
				adjacencySet.add(map.get(i - 1));
				adjacencySet.remove(i - k);
				if ((i + k - 1) < arr.length && arr[i + k - 1] > 0) {
					adjacencySet.add(i + k - 1);
				}
			}
			if (adjacencySet.isEmpty()) {
				throw new IOException();
			}
			int max = 0;
			if (adjacencySet.size() > 1) {
				max = Collections.max(adjacencySet);
			}
			else {
				max = adjacencySet.iterator().next();
			}
			map.put(i, max);
		}
		return map;
	}

	private static int getNoOfTowers(Map<Integer, Integer> adjMatrix) {
		Map<Integer, Integer> cityToTower = new HashMap<>();
		Set<Integer> usedTowers = new HashSet<>(adjMatrix.size());
		adjMatrix.keySet().stream().forEach(t -> {
			Integer connectedTowers = adjMatrix.get(t);
			Integer previousTower = cityToTower.get(t - 1);
			if (previousTower != null && connectedTowers.equals(previousTower)) {
				cityToTower.put(t, previousTower);
				usedTowers.add(previousTower);
			} else {
				int towerVal = connectedTowers;
				cityToTower.put(t, towerVal);
				usedTowers.add(towerVal);
			}
		});
		return usedTowers.size();
	}
}