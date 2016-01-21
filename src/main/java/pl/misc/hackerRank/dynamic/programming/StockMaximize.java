package pl.misc.hackerRank.dynamic.programming;

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
		int noOfShares = 0, expense = 0, earning = 0;
		int n = sc.nextInt();
		int arr[][] = new int[n][];
		for (int i = 0; i < n; i++) {
			int arr_size = sc.nextInt();
			arr[i] = new int[arr_size];
			for (int j = 0; j < arr_size; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
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
			}
			System.out.println(earning - expense);
			earning = expense = noOfShares = 0;
		}
	}
}