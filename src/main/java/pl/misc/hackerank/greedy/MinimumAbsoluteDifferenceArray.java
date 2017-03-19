package pl.misc.hackerank.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class MinimumAbsoluteDifferenceArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>(n);

		IntStream.range(0, n).forEach(i -> {
			list.add(sc.nextInt());
		});

		System.out.println(findMinimumDiff(list, n));
		sc.close();

	}

	private static int findMinimumDiff(List<Integer> list, int n) {
		Collections.sort(list);
		
		Set<Integer> set = new HashSet<>( 2 * n);
		for(int i = 1;i<n;i++) {
			set.add(Math.abs(list.get(i - 1) - list.get(i)));
		}
		
		return Collections.min(set);
	}

}