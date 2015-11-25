package pl.misc.hackerRank;

import java.util.Scanner;

public class AVeryBigSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long sum = 0;
        long arr[] = new long[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = in.nextLong();
        }
        for (int i = 0 ; i < n ; i++) {
            sum = sum + arr[i];
        }
        System.out.println(sum);
    }
}
