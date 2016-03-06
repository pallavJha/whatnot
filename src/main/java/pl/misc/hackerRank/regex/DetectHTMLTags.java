package pl.misc.hackerRank.regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectHTMLTags {

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> indexes = new LinkedList<Integer>();
        List<String> output = new LinkedList<String>();
        int inputNumber = sc.nextInt();
        String str = "";
        Pattern tagPattern = Pattern.compile("<\\s*[a-zA-Z0-9]\\s*");
        for (int i = 0 ; i < inputNumber ; i++) {
            String s = sc.nextLine();
            if (s.trim().length() == 0) {
                s = sc.nextLine().trim();
            }
            str += s + " ";
        }
        Matcher matcher = tagPattern.matcher(str);
        while(matcher.find()){
            indexes.add(matcher.start());
        }
        sc.close();
		for (Integer index : indexes) {
			String tag = "";
			here:for (int i = index + 1; i < str.length(); i++) {
				if(str.charAt(i) != ' ' && str.charAt(i) != '>'){
					tag += str.charAt(i); 
				}
				else{
					break here;
				}
			}
			output.add(tag);
		}
		output = new ArrayList<String>(new LinkedHashSet<String>(output));
        Collections.sort(output);
        str = "";
        for(String s : output){
        	str += s+";"; 
        }
        str = str.substring(0, str.length()-1);
        
        System.out.print(str);
    }
}
