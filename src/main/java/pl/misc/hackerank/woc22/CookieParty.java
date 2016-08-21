package pl.misc.hackerank.woc22;

import java.util.Scanner;

/**
 * Created by Pallav
 * on 21-08-2016.
 */
/*
Sample Input

3 2
Sample Output

1
*/
public class CookieParty {

    private CookieParty() {
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int noOfGuests = sc.nextInt();
        int noOfCookies = sc.nextInt();
        int diff = Math.abs(noOfGuests - noOfCookies);
        if (noOfCookies > noOfGuests) {
            diff = noOfGuests - (noOfCookies % noOfGuests);
        }
        if (diff > 0 && (diff % noOfGuests != 0)) {
            System.out.println(diff);
        } else {
            System.out.println(0);
        }
    }

}
