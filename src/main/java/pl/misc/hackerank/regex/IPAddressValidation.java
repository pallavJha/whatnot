package pl.misc.hackerank.regex;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidation {

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        int number_of_attempts = sc.nextInt();
        LinkedList<String> list = new LinkedList<String>();
        Pattern p_ip4 = Pattern.compile("^((0|1|2){0,1}\\d{1,2}\\.){3}(0|1|2){0,1}\\d{1,2}$");
        Pattern p_ip6 = Pattern.compile("^([\\da-fA-F^_]{1,4}:){7}[\\da-fA-F^_]{1,4}$");
        for (int i = 0 ; i < number_of_attempts ; i++) {
            String input = sc.nextLine().trim();
            if(input.length() == 0){
                input = sc.nextLine().trim();
            }
            Matcher m_ip4 = p_ip4.matcher(input);
            Matcher m_ip6 = p_ip6.matcher(input);
            if (m_ip4.find()) {
                list.add("IPv4");
            } else if (m_ip6.find()) {
                list.add("IPv6");
            } else {
                list.add("Neither");
            }
        }
        sc.close();
        for (String s : list) {
            System.out.println(s);
        }
    }

}
