package pl.misc.hackerank.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReverseShuffleMerge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		Map<Character, Integer> charCountMap = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			Integer count = charCountMap.get(input.charAt(i));
			if(count == null) {
				count = 1;
			}
			else {
				count++;
			}
			charCountMap.put(input.charAt(i), count);
		}
		
		List<Character> characters = new ArrayList<>(input.length() / 2);
		charCountMap.keySet()
					.stream()
					.forEach(i -> {
						int actualCount = charCountMap.get(i);
						for(int j = 0 ; j < actualCount / 2 ;j++) {
							characters.add(i);
						}
					});
		
		Collections.sort(characters);
		characters.stream()
					.forEach(t -> {
						System.out.print(t);
					});
		sc.close();
	}
}