package pl.misc.hackerRank;

import java.util.Scanner;

public class ServiceLane {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        int n = in.nextInt();
        int t = in.nextInt();
        int min = 10000011;
        int width[] = new int[n];
        int arr[] = new int[t];
        for (int i = 0 ; i < n ; i++) {
            width[i] = in.nextInt();
        }
        for (int a0 = 0 ; a0 < t ; a0++) {
            int i = in.nextInt();
            int j = in.nextInt();
            for (int a = i ; a <= j ; a++) {
                if (width[a] < min) {
                    min = width[a];
                }
            }
            arr[count++] = min;
            min = 10000011;
        }
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}