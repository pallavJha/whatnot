package pl.misc.hackerank.dp;

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
public class StockMaximize {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long noOfShares = 0, expense = 0, earning = 0;
		int n = sc.nextInt();
		long arr[][] = new long[n][];
		for (int i = 0; i < n; i++) {
			int arr_size = sc.nextInt();
			arr[i] = new long[arr_size];
			for (int j = 0; j < arr_size; j++) {
				arr[i][j] = sc.nextLong();
			}
		}
		sc.close();
		
		for (int i = 0; i < arr.length; i++) {
			/*for (int j = 0; j < arr[i].length; j++) {
				if(j == (arr[i].length -1)){
					if(arr[i][j] > arr[i][j-1]){
						earning += (noOfShares * arr[i][j]);
						noOfShares = 0;
					}
				}
				else{
					if (arr[i][j] < arr[i][j + 1]) {
						noOfShares++;
						expense += arr[i][j];
					} 
					else if (arr[i][j] > arr[i][j + 1]) {
						earning += (noOfShares * arr[i][j]);
						noOfShares = 0;
					}
				}
			}*/
			System.out.println(maxProfitStrategy(arr[i]));
			System.out.println(earning - expense);
			earning = expense = noOfShares = 0;
		}
	}
	
	public static long maxProfitStrategy(long[] a) {
	    int n = a.length;
	    int memo[] = new int[n];
	    memo[0] = -1;
	    for (int i = 1; i < n; i++) {
	        int j = i - 1;
	        while (a[j] < a[i] && memo[j] != -1) {
	            j = memo[j];
	        }
	        if (a[j] > a[i]) {
	            memo[i] = j;
	        } else {
	            memo[i] = memo[j];
	        }
	    }
	    return calculateProfit(a,memo);
	}

	private static long calculateProfit(long[] a, int[] memo) {
	    long profit = 0;
	    int n = a.length;
	    for (int i = n - 1; i > 0; ) {
	        int end = i;
	        int start = memo[i] + 1;

	        for (int j = start; j < end; j++) {
	            profit += a[end] - a[j];
	        }
	        i = memo[i];
	    }
	    return profit;
	}
}