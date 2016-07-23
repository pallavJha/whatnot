package pl.misc.hackerank;

import java.util.Scanner;

public class CaesarCipher {

    public static int k;

    public static void main(String[] args) {
        // String s = "middle-Outz";
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        k = in.nextInt();
        for (int i = 0 ; i < s.length() ; i++) {
            System.out.print(convert(s.charAt(i)));
        }
    }

    public static char convert(char c) {
        int c_int = c;
        int max = 0;
        int min = 0;
        k = k % 26;
        Boolean zone = null;
        if (c_int >= 65 && c_int <= 90) {
            zone = true;
            max = 90;
            min = 65;
        } else if (c_int >= 97 && c_int <= 122) {
            zone = true;
            max = 122;
            min = 97;
        }
        if (zone != null) {
            if (c_int + k > max) {
                c_int = c_int + k - max + min - 1;
            } else {
                c_int = c_int + k;
            }
            return (char) c_int;
        } else {
            return c;
        }
    }
}
