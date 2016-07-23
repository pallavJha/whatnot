package pl.misc.hackerank;

import java.util.Scanner;

public class PlusMinus {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        float pos = 0, neg = 0, zero = 0;
        for (int i = 0 ; i < n ; i++) {
            a[i] = in.nextInt();
            if(a[i] > 0){
                pos++;
            }
            else if(a[i] == 0){
                zero++;
            }
            else if(a[i] < 0){
                neg++;
            }
        }
        System.out.printf("%.3f\n", new Float(pos/a.length));
        System.out.printf("%.3f\n", new Float(neg/a.length));
        System.out.printf("%.3f\n", new Float(zero/a.length));
    }

}
