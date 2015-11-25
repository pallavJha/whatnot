package pl.misc.hackerRank;

import java.util.Scanner;

public class SherlockAndTheBeast {

    public static void main(String... strings) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long start = System.currentTimeMillis();
        String[] s = new String[t];
        for (int i = 0 ; i < t ; i++) {
            int n = in.nextInt();
            int m = n;
            s[i] = new String("");
            int k = 0;
            while (true) {
                int np3 = n % 3;
                int kp5 = k % 5;
                if (np3 == 0 && kp5 == 0) {
                    for (int j = 0 ; j < n ; j++) {
                        s[i] = s[i] + "5";
                    }
                    for (int j = 0 ; j < k ; j++) {
                        s[i] = s[i] + "3";
                    }
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
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        /*for (String a : s) {
            System.out.println(a);
        }*/
    }
}
