package pl.misc.hackerank.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaximumPerimeterTriangle {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean found = false;
		int n = sc.nextInt();
		Long[] sides = new Long[n];
		for (int i = 0; i < n; i++) {
			sides[i] = sc.nextLong();
		}

		Arrays.sort(sides, Collections.reverseOrder());

		here: for (int i = 0; i < n; i++) {
			for (int j = (i + 1); j < n; j++) {
				for (int k = (j + 1); k < n; k++) {
					if (sides[i] < sides[j] + sides[k]) {
						List<Long> sideList = new ArrayList<>(3);
						sideList.add(sides[i]);
						sideList.add(sides[j]);
						sideList.add(sides[k]);
						Collections.sort(sideList);
						sideList.forEach(elem -> {
							System.out.print(elem + " ");
						});
						found = true;
						break here;
					}
				}
			}
		}
		if (!found) {
			System.out.print(-1);
		}

		sc.close();

	}

}