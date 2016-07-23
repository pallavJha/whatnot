package pl.misc.hackerank;

import java.util.Scanner;

public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int arr[] = new int[t];
        for (int a0 = 0 ; a0 < t ; a0++) {
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            int numberOfChocolates = n / c;
            int numberOfWrappers = numberOfChocolates;
            while (numberOfWrappers / m >= 1) {
                numberOfChocolates += (numberOfWrappers/m);
                numberOfWrappers = numberOfWrappers / m + numberOfWrappers % m;
            }
               arr[a0] = numberOfChocolates;
        }
        for (int i = 0 ; i < t ; i++) {
            System.out.println(arr[i]);
        }
    }
}
