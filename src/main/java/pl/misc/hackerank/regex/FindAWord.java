package pl.misc.hackerank.regex;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAWord {

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> output = new LinkedList<Integer>();
		int inputNumber = sc.nextInt();
		String str = "";
		for (int i = 0; i < inputNumber; i++) {
			String s = sc.nextLine();
			if (s.trim().length() == 0) {
				s = sc.nextLine().trim();
			}
			str += s + " ";
		}
		inputNumber = sc.nextInt();
		for (int i = 0; i < inputNumber; i++) {
			String s = sc.nextLine();
			if (s.trim().length() == 0) {
				s = sc.nextLine().trim();
			}
			Pattern p = Pattern.compile(s);
			Matcher m = p.matcher(str);
			int count = 0;
			while (m.find()) {
				boolean start = false, end = false;
				if(m.start() == 0){
					start = true;
				}
				else{
					start = !Character.isLetter(str.charAt(m.start() - 1))&& 
							!Character.isDigit(str.charAt(m.start() - 1))
							&& str.charAt(m.start() - 1) != '_';
				}
				if(m.end() == str.length() -1){
					end = true;
				}
				else{
					end = !Character.isLetter(str.charAt(m.end()))
							&& !Character.isDigit(str.charAt(m.end()))
							&& str.charAt(m.end()) != '_';
				}
				
				if (start && end){
					count++;
				}
			}
			output.add(count);
		}
		sc.close();
		for (Object x : output) {
			System.out.println(x);
		}
	}
}