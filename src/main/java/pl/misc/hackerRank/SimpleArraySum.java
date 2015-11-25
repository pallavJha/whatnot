package pl.misc.hackerRank;

import java.util.Scanner;

public class SimpleArraySum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        int arr[] = new int[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0 ; i < n ; i++) {
            sum = sum + arr[i];
        }
        System.out.println(sum);
    }
}
