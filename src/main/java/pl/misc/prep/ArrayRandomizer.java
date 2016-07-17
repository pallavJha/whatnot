package pl.misc.prep;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayRandomizer {
	public static void main(String args[]) {
		int[] solutionArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

		shuffleArray(solutionArray);
		for (int i = 0; i < solutionArray.length; i++) {
			System.out.print(solutionArray[i] + " ");
		}
		System.out.println();
		
		shuffleArray(solutionArray);
		for (int i = 0; i < solutionArray.length; i++) {
			System.out.print(solutionArray[i] + " ");
		}
		System.out.println();
		
		shuffleArray(solutionArray);
		for (int i = 0; i < solutionArray.length; i++) {
			System.out.print(solutionArray[i] + " ");
		}
		System.out.println();
		
		shuffleArray(solutionArray);
		for (int i = 0; i < solutionArray.length; i++) {
			System.out.print(solutionArray[i] + " ");
		}
		System.out.println();
	}

	// Implementing Fisher Yates shuffle
	static void shuffleArray(int[] ar) {
		// If running on Java 6 or older, use `new Random()` on RHS here
		Random rnd = ThreadLocalRandom.current();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}
}