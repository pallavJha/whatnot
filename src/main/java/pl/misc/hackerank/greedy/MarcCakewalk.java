package pl.misc.hackerank.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MarcCakewalk {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int noOfCakes = sc.nextInt();
		List<Integer> list = new ArrayList<>(noOfCakes);
		IntStream.range(0, noOfCakes).forEach(i -> {
			list.add(sc.nextInt());
		});
		
		System.out.println(calcuateMinDistance(list, noOfCakes));
		sc.close();
	}

	private static long calcuateMinDistance(List<Integer> list, int n) {
		Collections.sort(list, Collections.reverseOrder());
		long distance = 0;
		for (int i = 0; i < n; i++) {
			distance += (list.get(i) * (long)(Math.pow(2, i))); 
		}
		return distance;
	}
}