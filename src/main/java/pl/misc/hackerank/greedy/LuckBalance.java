package pl.misc.hackerank.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LuckBalance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long luckBalance = 0;
		List<Integer> imp = new ArrayList<>(n);
		List<Integer> unImp = new ArrayList<>(n);

		IntStream.range(0, n).forEach(i -> {
			int luck = sc.nextInt();
			int t = sc.nextInt();
			if (t == 1) {
				imp.add(luck);
			} else {
				unImp.add(luck);
			}
		});

		Collections.sort(imp, Collections.reverseOrder());
		
		if (k <= imp.size()) {
			for (int i = 0; i < k; i++) {
				luckBalance += imp.get(i);
			}
			for (int i = k; i < imp.size(); i++) {
				luckBalance -= imp.get(i);
			}
			luckBalance += unImp.stream().mapToInt(i -> i.intValue()).sum();
		}
		
		else {
			luckBalance += imp.stream().mapToInt(i -> i.intValue()).sum();
			/*int loopCount = k - imp.size();
			for (int i = 0; i < loopCount; i++) {
				luckBalance += unImp.get(i);
			}
			for (int i = loopCount; i < unImp.size(); i++) {
				luckBalance += unImp.get(i);
			}*/
			luckBalance += unImp.stream().mapToInt(i -> i.intValue()).sum();
		}
		
		System.out.println(luckBalance);

		sc.close();
	}

}