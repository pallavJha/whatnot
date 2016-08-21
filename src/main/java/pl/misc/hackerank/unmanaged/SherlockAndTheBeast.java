package pl.misc.hackerank.unmanaged;

import java.util.Scanner;

public class SherlockAndTheBeast {

	public static void main1(String... strings) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		//long start = 0L;
		//long end = 0L;
		String[] s = new String[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();

			int m = n;
			s[i] = new String("");
			int k = 0;
			while (true) {
				int np3 = n % 3;
				int kp5 = k % 5;
				if (np3 == 0 && kp5 == 0) {
					// start = System.currentTimeMillis();
					s[i] = new String(new char[n]).replace('\0', '5');
					for (int j = 0; j < k; j++) {
						s[i] = s[i] + "3";
					}
					// end = System.currentTimeMillis();
					break;
				} else {
					int a = 1;
					if (np3 == 2) {
						a = 2;
					} else if (np3 == 0) {
						if (kp5 == 1) {
							a = 9;
						} else if (kp5 == 2) {
							a = 3;
						} else if (kp5 == 3) {
							a = 12;
						} else if (kp5 == 4) {
							a = 6;
						}
					}
					n = n - a;
					k = k + a;
				}
				if (k > m) {
					s[i] = s[i] + "-1";
					break;
				}
			}
		}
		// System.out.println(start);
		// System.out.println(end);
		// System.out.println(end - start);
		for (String a : s) {
			System.out.println(a);
		}
	}

	public static void main2(String args[]) {
		long start = System.currentTimeMillis();
		int n = 57634;
		int k = 10;
		/*
		 * String s = ""; for (int j = 0; j < n; j++) { s = s + "5"; } for (int
		 * j = 0; j < k; j++) { s = s + "3"; }
		 */
		String space10 = new String(new char[57634]).replace('\0', '5');

		System.out.println("[" + space10 + "]");
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	public static void main(String args[]) {
	    System.out.println(Boolean.parseBoolean(null));
	}
}
