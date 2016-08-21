package pl.misc.hackerank.unmanaged;

import java.util.Arrays;
import java.util.Scanner;

public class PriyankaAndToys {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
		}
		sc.close();

		Arrays.sort(w);
		
		int money = 1;
		int min = w[0];
		
		for (int i = 1; i < n; i++) {
			if(w[i]-min >= 5){
				money++;
				min = w[i];
			}
		}
		
		System.out.println(money);
	}
}