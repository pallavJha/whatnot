/*
ID: pkjustp1
LANG: JAVA
TASK: ride
*/

package pl.misc.usaco.chapter1;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Pallav
 * on 21-09-2016.
 */
public class YourRideIsHere {

    public static void main(String... args) throws IOException {
        Scanner sc = new Scanner(new File("ride.in"));
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        int product1, product2;
        product1 = product2 = 1;

        product1 = getProductModValue(line1, product1);

        product2 = getProductModValue(line2, product2);

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));

        if (product1 == product2) {
            out.println("GO");
        } else {
            out.println("STAY");
        }

        out.close();
    }

    private static int getProductModValue(String line, int product) {
        for (int i = 0; i < line.length(); i++) {
            product *= ((int) line.charAt(i) - 64);
        }
        return product % 47;
    }
}
