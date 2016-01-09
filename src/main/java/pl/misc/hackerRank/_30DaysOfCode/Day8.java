package pl.misc.hackerRank._30DaysOfCode;

import java.util.*;

class Day8 {
	public static void main(String[] argh) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> keyList, outputList = new LinkedList<String>();
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			String name = in.next();
			int phone = in.nextInt();
			in.nextLine();
			map.put(name, phone);
		}
		keyList = new ArrayList<String>(map.keySet());
		while (in.hasNextLine()) {
		    String s = in.nextLine();
		    if (s.isEmpty())
		        break;
		    if (keyList.contains(s)) {
		        outputList.add(s + "=" + map.get(s));
		    } else {
		        outputList.add("Not found");
		    }
		}
		in.close();
		for (int i = 0; i < outputList.size(); i++) {
			System.out.println(outputList.get(i));
		}
	}
}
