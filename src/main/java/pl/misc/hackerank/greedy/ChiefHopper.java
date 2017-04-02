package pl.misc.hackerank.greedy;

import java.util.Scanner;

public class ChiefHopper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] arr = new double[n];
		for (int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextDouble();
		}
		
		double minimumBotEnergy = calcMinimumBotEnergy3(arr, n);
		System.out.println((long)minimumBotEnergy);
		sc.close();
	}
	
	private static double calcMinimumBotEnergy3(double[] arr, int size) {
		double energy = 0;
		for (int i = size - 1; i > -1 ; i--) {
			energy = Math.ceil((energy + arr[i])/2);
		}
		return energy;
	}
}