package pl.misc.hackerRank._30DaysOfCode;

import java.util.Scanner;

public class Day5loops {
	
	/*
	 * 
	Sample Input
	
	2    
	5 3 5
	0 2 10
	Sample Output
	
	8 14 26 50 98
	2 6 14 30 62 126 254 510 1022 2046
	Explanation
	
	There are two test cases. 
	In the first case: a=5, b=3 ,N=5 
	1st term =   5+(20×3)=8 
	2nd term =   5+(20×3)+(21×3)=14 
	3rd term =   5+(20×3)+(21×3)+(22×3)=26 
	4th term =   5+(20×3)+(21×3)+(22×3)+(23×3)=50 
	5th term =   5+(20×3)+(21×3)+(22×3)+(23×3)+(24×3)=98
	 
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int a[] = new int[T];
		int b[] = new int[T];
		int n[] = new int[T];
		
		for (int i = 0; i < T; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			n[i] = sc.nextInt();
		}
		
		sc.close();
		
		for (int i = 0; i < T; i++) {
			int sum = a[i];
			for (int j = 0; j < n[i]; j++) {
				sum += Math.pow(2, j) * b[i];
				System.out.print(sum + " ");
			}
			System.out.println();
		}
	}
}
