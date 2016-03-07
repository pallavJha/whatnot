package pl.misc.hackerRank.regex;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienUsername {

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        List<String> output = new LinkedList<String>();
        int inputNumber = sc.nextInt();
        Pattern tagPattern = Pattern.compile("^[_\\.]\\d+[a-zA-Z]*_{0,1}$");
        for (int i = 0 ; i < inputNumber ; i++) {
            String s = sc.nextLine();
            if (s.trim().length() == 0) {
                s = sc.nextLine().trim();
            }
            Matcher matcher = tagPattern.matcher(s);
            if(matcher.find()){
            	output.add("Valid");
            }
            else{
            	output.add("Invalid");
            }
        }
        sc.close();
		for (String s : output) {
			System.out.println(s);
		}
    }
}
