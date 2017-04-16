package pl.misc.hackerank.dp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 *
Sample Input

3
3
5 3 2
3
1 2 100
4
1 3 1 2

Sample Output

0
197
3
*/
/**
 * Go Reverse
 */
public class StockMaximize {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		List<Long> allProfits = new LinkedList<>();
		for (int i = 0; i < noOfTestCases; i++) {
			int arrSize = sc.nextInt();
			long[] prices = new long[arrSize];
			for (int j = 0; j < prices.length; j++) {
				prices[j] = sc.nextLong();
			}
			allProfits.add(stockMaximize(prices));
		}
		sc.close();
		System.out.println(allProfits);
	}

	public static long stockMaximize(long[] prices) {
		long profit = 0;
		int sellAt = prices.length - 1;
		for	 (int i = prices.length - 2; i > -1; i--) {
			if (prices[i] < prices[sellAt]) {
				if (i == 0) {
					profit += business(prices, 0, sellAt);
				}
			} else {
				profit += business(prices, i + 1, sellAt);
				sellAt = i;
			}
		}
		return profit;
	}

	public static long business(long[] prices, int buyFrom, int sellAt) {
		if (buyFrom == sellAt) {
			return 0L;
		}
		long totalCost = 0;
		int totalShares = 0;
		for (int i = buyFrom; i < sellAt; i++) {
			totalCost += prices[i];
			totalShares++;
		}
		System.out.println((prices[sellAt] * totalShares) - totalCost);
		return (prices[sellAt] * totalShares) - totalCost;
	}
}