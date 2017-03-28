package pl.misc.hackerank.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BoardCutting {

	private static int mIndex = 0, nIndex = 0;
	public static void main(String... args) {
		
		Scanner sc = new Scanner(System.in);
		int queries = sc.nextInt();
		for (int i = 0; i < queries; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			Long[] costY = new Long[m -1];
			Long[] costX = new Long[n -1];
			for (int j = 1; j < m; j++) {
				costY[j - 1] = sc.nextLong();
			}
			for (int j = 1; j < n; j++) {
				costX[j - 1] = sc.nextLong();
			}
			long cost = minimumCost(costY, m, costX, n);
			cost = (long) (cost % (Math.pow(10, 9) + 7));
			System.out.println(cost);
			mIndex = 0;
			nIndex = 0;
		}
		sc.close();
	}
	
	private static long minimumCost(Long[] costY, int m, Long[] costX, int n) {
		Arrays.sort(costY, Collections.reverseOrder());
		Arrays.sort(costX, Collections.reverseOrder());
		
		long noOfXSegments = 1, noOfYSegments = 1, cost = 0;
		int loopCount = m + n - 2;
		for (int i = 0; i < loopCount; i++) {
			long[] maxSegmentCost = maxFromTwo(costY, costX);
			if(maxSegmentCost[1] == 1) {
				cost += (long)(maxSegmentCost[0] * noOfYSegments) % (Math.pow(10, 9) + 7);
				noOfXSegments++;
			}
			else {
				cost += (long)(maxSegmentCost[0] * noOfXSegments) % (Math.pow(10, 9) + 7);
				noOfYSegments++;
			}
		}
		return cost;
	}
	
	private static long[] maxFromTwo(Long[] costY, Long[] costX) {
		if(mIndex < costY.length) {
			if(nIndex < costX.length) {
				return findMax(costY[mIndex], costX[nIndex]);
			}
			else {
				long returnValue = costY[mIndex];
				mIndex++;
				return new long[]{returnValue, 1L};
			}
		}
		else {
			long returnValue = costX[nIndex];
			nIndex++;
			return new long[]{returnValue, 0L};
		}
	}
	
	private static long[] findMax(long a, long b) {
		if(a >= b) {
			mIndex++;
			return new long[]{a, 1L};
		}
		else {
			nIndex++;
			return new long[]{b, 0L};
		}
	}
}