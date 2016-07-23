package pl.misc.hackerank;

import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if(i == j){
                    sum1 += a[i][j];
                }
                if((i+j) == n-1){
                    sum2 += a[i][j];
                }
            }
        }
        int sum3 = sum1 -sum2;
        System.out.println(Math.abs(sum3));
    }
}
