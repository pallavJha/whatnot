package pl.misc.hackerank.regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectTheEmailAddresses {

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> indexes = new LinkedHashMap<Integer, Integer>();
        List<String> output = new LinkedList<String>();
        int inputNumber = sc.nextInt();
        String str = "";
        Pattern tagPattern = Pattern.compile("[\\w.-]+@\\w+\\.[\\w-]*(\\.[a-zA-Z0-9]+){0,15}");
        for (int i = 0 ; i < inputNumber ; i++) {
            String s = sc.nextLine();
            if (s.trim().length() == 0) {
                s = sc.nextLine().trim();
            }
            str += s + " ";
        }
        Matcher matcher = tagPattern.matcher(str);
        while(matcher.find()){
            indexes.put(matcher.start(), matcher.end());
        }
        sc.close();
		for (Entry<Integer, Integer> index : indexes.entrySet()) {
			output.add(str.substring(index.getKey(), index.getValue()));
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
