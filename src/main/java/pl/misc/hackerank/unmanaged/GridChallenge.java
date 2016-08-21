/**
 * Input Format

Sample Input

1
5
e b a c d
f g h i j
o l m k n
t r p q s
x y w u v
Sample Output

YES
Explanation

The grid in the first and only testcase can be reordered to

a b c d e
f g h i j
k l m n o
p q r s t
u v w x y
This fulfills the condition since the rows 1, 2, ..., 5 and the columns 1, 2, ..., 5 are all lexicographically sorted.
 */
package pl.misc.hackerank.unmanaged;

import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int noOfTCases = sc.nextInt();
		String[][] s_arr = new String[noOfTCases][];
		boolean[] b_arr = new boolean[noOfTCases];

		for (int i = 0; i < noOfTCases; i++) {

			int n = sc.nextInt();
			s_arr[i] = new String[n];

			for (int j = 0; j < n; j++) {
				s_arr[i][j] = sc.next();
			}

		}

		for (int i = 0; i < noOfTCases; i++) {

			s_arr[i][0] = new String(sort(s_arr[i][0]));

			inner: for (int j = 0; j < s_arr[i].length - 1; j++) {
				s_arr[i][j + 1] = new String(sort(s_arr[i][j + 1]));

				boolean isEqual = compare(s_arr[i][j], s_arr[i][j + 1]);
				if (!isEqual) {
					b_arr[i] = true;
					break inner;
				}
			}
		}

		printResult(b_arr);
	}

	public static char[] sort(String str) {
		char[] c_arr = str.toCharArray();
		Arrays.sort(c_arr);
		return c_arr;
	}

	public static boolean compare(String str1, String str2) {

		for (int i = 0; i < str1.length(); i++) {

			if (str1.charAt(i) > str2.charAt(i)) {
				return false;
			}

		}
		return true;
	}

	public static void printResult(boolean[] b_arr) {
		for (int i = 0; i < b_arr.length; i++) {
			if (b_arr[i]) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}

}