package pl.misc.pi;

/**
 * @author Pallav Jha
 * @since 13/5/18
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TestClass {
    public static void main(String args[]) throws Exception {
        solution("E7=[16], WWWW=[4,2], ABCD=[0,8,12]22");
    }

    static String solution(String string) {
        Pattern p = Pattern.compile("[\\w\\d]*=\\[\\d*(,\\d*)*\\]");
        Matcher matcher = p.matcher(string);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(string.substring(start, end));
            string.substring(start, end);
        }

        return "NONE";
    }

    static String dedup(String inputStr, int chunkSize) {
        Map<String, List<Integer>> chunkWithLocation = new HashMap<>();
        for (int i = 0; i < inputStr.length(); i += chunkSize) {
            String text;
            if (i + chunkSize < inputStr.length()) {
                text = inputStr.substring(i, i + chunkSize);
            } else {
                text = inputStr.substring(i, inputStr.length());
            }
            List<Integer> list = chunkWithLocation.getOrDefault(text, new ArrayList<>());
            list.add(i);
            chunkWithLocation.put(text, list);
        }
        return chunkWithLocation.size() == 0 ? inputStr : chunkWithLocation.toString().replaceAll("\\s*", "") + "~" + inputStr.length();
    }

    private static Pattern p = Pattern.compile("[\\w\\d]*=\\[\\d*(,\\d*)*\\]");

    static String redup(String deduplicatedStr, int chunkSize) {

        int size = Integer.parseInt(deduplicatedStr.split("~")[1]);
        char[] arr = new char[size];
        Matcher matcher = p.matcher(deduplicatedStr);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String comp = deduplicatedStr.substring(start, end);
            String[] strs = comp.split("=");
            String str = strs[0];
            String[] locations = strs[1].replaceAll("\\[", "").replaceAll("\\]", "").split(",");
            for (int i = 0; i < locations.length; i++) {
                int loc = Integer.parseInt(locations[i]);
                System.arraycopy(str.toCharArray(), 0, arr, loc, chunkSize);
            }

        }

        return new String(arr);
    }
}

