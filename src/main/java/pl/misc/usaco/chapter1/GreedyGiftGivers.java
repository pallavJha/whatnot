/*
ID: pkjustp1
LANG: JAVA
TASK: gift1
*/
package pl.misc.usaco.chapter1;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Pallav
 * on 21-09-2016.
 */
public class GreedyGiftGivers {

    public static void main(String... args) throws IOException {
        Scanner sc = new Scanner(new File("gift1.in"));
        Map<String, Integer> map = new LinkedHashMap<>();

        int NP = Integer.parseInt(sc.nextLine());

        fetchNames(sc, map, NP);

        while (sc.hasNextLine()) {
            String donor = sc.nextLine();
            int sum = sc.nextInt();
            int people = sc.nextInt();
            if (people > 0) {
                int amount = sum / people;
                int rem = sum % people;
                for (int i = 0; i < people; i++) {
                    String receiver = sc.nextLine();
                    if (isEmpty(receiver)){
                        receiver = sc.nextLine();
                    }
                    map.put(receiver, map.get(receiver) + amount);
                }
                map.put(donor, map.get(donor) + rem - sum);
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        for (Map.Entry<String, Integer> es : map.entrySet()) {
            out.println(es.getKey() + " " + es.getValue());
        }

        sc.close();
        out.close();
    }

    private static void fetchNames(Scanner sc, Map<String, Integer> map, int NP) {
        for (int i = 0; i < NP; i++) {
            map.put(sc.nextLine(), 0);
        }
    }

    private static boolean isEmpty(String string){
        return string == null || string.length() == 0;
    }

}
