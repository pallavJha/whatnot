package pl.misc.hackerank.graph;

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
		Map<Integer, Set<Integer>> adjMatrix;
		try {
			adjMatrix = getAdjacencyList(arr, n, k);
			System.out.println(getNoOfTowers(adjMatrix));
		} catch (IOException e) {
			System.out.println(-1);
		}
		sc.close();
	}
	
	private static Map<Integer, Set<Integer>> getAdjacencyList(int[] arr, int n, int k) throws IOException {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for(int i = 0 ; i < n; i++) {
			Set<Integer> adjacencySet = new HashSet<>(2 * k - 1);
			for(int j = i; j < i + k && j < n; j++) {
				if(arr[j] > 0) {
					adjacencySet.add(j);
				}
			}
			for(int j = i; j > -1 && j > i - k; j--) {
				if(arr[j] > 0) {
					adjacencySet.add(j);
				}
			}
			if(adjacencySet.isEmpty()) {
				throw new IOException();
			}
			map.put(i, adjacencySet);
		}
		return map;
	}
	
	private static int getNoOfTowers(Map<Integer, Set<Integer>> adjMatrix) {
		Map<Integer, Integer> cityToTower = new HashMap<>();
		Set<Integer> usedTowers = new HashSet<>(adjMatrix.size());
		adjMatrix.keySet()
				   .stream()
				   .forEach(t -> {
					   Set<Integer> connectedTowers = adjMatrix.get(t);					   
					   Integer previousTower = cityToTower.get(t-1);
					   if(previousTower != null && connectedTowers.contains(previousTower)) {
						   cityToTower.put(t, previousTower);
						   usedTowers.add(previousTower);
					   }
					   else {
						   int towerVal = Collections.max(connectedTowers);
						   cityToTower.put(t, towerVal);
						   usedTowers.add(towerVal);
					   }
				   });
		return usedTowers.size();
	}
}