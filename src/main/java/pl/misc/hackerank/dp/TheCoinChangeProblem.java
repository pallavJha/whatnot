package pl.misc.hackerank.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheCoinChangeProblem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long number = sc.nextLong();
		int noOfCoins = sc.nextInt();
		long[] coins = new long[noOfCoins];
		for (int i = 0; i < noOfCoins; i++) {
			coins[i] = sc.nextLong();
		}
		
		Arrays.sort(coins);

		Map<Long, Long> numToCount = new HashMap<>();
		for (int c = 0; c < coins.length; c++) {
			for (long i = 1; i <= number; i++) {
				long currCount = numToCount.getOrDefault(i, 0L);
				numToCount.put(i, currCount);
				if (currCount > 0 && i + coins[c] <= number) {
					long nextSum = numToCount.getOrDefault(i + coins[c], 0L);
					nextSum+=currCount;
					numToCount.put(i + coins[c], nextSum);
				}
				if (i % coins[c] == 0) {
					currCount = numToCount.getOrDefault(i, 0L);
					currCount++;
					numToCount.put(i, currCount);
				}
			}
			//System.out.println(coins[c]);
			//System.out.println(numToCount);
		}

		System.out.println(numToCount.get(number));
		sc.close();
	}
}