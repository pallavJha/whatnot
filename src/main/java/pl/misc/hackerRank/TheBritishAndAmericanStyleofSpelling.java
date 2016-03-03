package pl.misc.hackerRank;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheBritishAndAmericanStyleofSpelling {

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        int number_of_lines = sc.nextInt();
        String str = "";
        LinkedList<String> cases = new LinkedList<String>();
        LinkedList<Integer> output = new LinkedList<Integer>();
        for (int i = 0 ; i < number_of_lines ; i++) {
            String input = sc.nextLine();
            if (input.length() == 0) {
                input = sc.nextLine().trim();
            }
            str += input + " "; 
        }
        str = str.trim();
        int number_of_cases = sc.nextInt();
        for (int i = 0 ; i < number_of_cases ; i++) {
            String input = sc.nextLine();
            if (input.length() == 0) {
                input = sc.nextLine().trim();
            }
            cases.add(input); 
        }
        sc.close();
        for(String s : cases){
            s = s.substring(0, s.length()-2)+"[sSzZ]e";
            Pattern p = Pattern.compile(s);
            Matcher m = p.matcher(str);
            int count = 0;
            while(m.find()) {
                count++;
                //System.out.println("found: " + count + " : "+ matcher.start() + " - " + matcher.end());
            }
            output.add(count);
        }
        for (Integer out : output) {
            System.out.println(out);
        }
    }
}
