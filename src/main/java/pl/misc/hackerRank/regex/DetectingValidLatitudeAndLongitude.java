package pl.misc.hackerRank.regex;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectingValidLatitudeAndLongitude {

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        List<String> output = new LinkedList<String>();
        int inputNumber = sc.nextInt();
        Pattern tagPattern = Pattern.compile("\\([-\\+]{0,1}((90((\\.{0})|\\.{1}0+))|([0-8]{0,1}\\d(((\\.){0})|((\\.){1}\\d+)))),\\s[-\\+]{0,1}((180((\\.){0}|(\\.{1}0+)))|(((1{1,1}[0-7])|([0-9]{0,1}))[0-9](((\\.){0})|((\\.){1}\\d+))))\\)");
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
