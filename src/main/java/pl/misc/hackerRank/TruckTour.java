/*
 *	Sample Input
 *	
 *	3
 *	1 5
 *	10 3
 *	3 4
 *
 *	Sample Output
 *	
 *	1 
 */
package pl.misc.hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TruckTour {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int petrol[] = new int[n];
		int distance[] = new int[n];
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		
		
		for (int i = 0; i < n; i++) {
			petrol[i] = sc.nextInt();
			distance[i] = sc.nextInt();
		}
		sc.close();
		
		for (int i = 0; i < n; i++) {
			if (petrol[i] > distance[i]) {
				indexMap.put(petrol[i]-distance[i], i);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>(indexMap.keySet());
		System.out.println(indexMap.get(Collections.max(list)));
	}
}