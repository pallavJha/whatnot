package pl.misc.hackerank.regex;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindHackerRank {

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<String> output = new LinkedList<String>();
        int inputNumber = sc.nextInt();
        Pattern p2 = Pattern.compile("^hackerrank[\\w\\s]+$");
        Pattern p1 = Pattern.compile("^[\\w\\s]+hackerrank$");
        Pattern p0_1 = Pattern.compile("^hackerrank$");
        Pattern p0_2 = Pattern.compile("^hackerrank[\\w\\s]*hackerrank$");
        for (int i = 0 ; i < inputNumber ; i++) {
            String s = sc.nextLine();
            if (s.trim().length() == 0) {
                s = sc.nextLine();
            }
            Matcher m2 = p2.matcher(s);
            if (m2.find()) {
                output.add("1");
            } else {
                Matcher m1 = p1.matcher(s);
                if (m1.find()) {
                    output.add("2");
                } else {
                    Matcher m0_1 = p0_1.matcher(s);
                    Matcher m0_2 = p0_2.matcher(s);
                    if (m0_1.find() || m0_2.find()) {
                        output.add("0");
                    } else {
                        output.add("-1");
                    }
                }
            }
        }
        sc.close();
        for (String s : output) {
            System.out.println(s);
        }
    }
}
