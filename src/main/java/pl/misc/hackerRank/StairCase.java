package pl.misc.hackerRank;

import java.util.Scanner;

public class StairCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = n - 1;
        int p = 1;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                System.out.print(" ");
            }
            for (int j = 0 ; j < p ; j++) {
                System.out.print("#");
            }
            m--;
            p++;
            System.out.println();
        }
    }
}
