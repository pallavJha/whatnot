package pl.misc.hackerank.unmanaged;

import java.util.Scanner;

public class TimeConversion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Boolean period = null;
        boolean done = false;
        String time = in.next();
        String[] times = time.split(":");
        if (time.contains("AM")) {
            period = Boolean.TRUE;
        } else {
            period = Boolean.FALSE;
        }
        if (times[0].equals("12") && period) {
            times[0] = "00";
            done = true;
        } else if (times[0].equals("12") && !period) {
            times[0] = "12";
            done = true;
        }
        if (!done && !period) {
            Integer a = new Integer(times[0]);
            a = a + 12;
            times[0] = a.toString();
        }
        if(period)
            times[2] = times[2].replaceAll("AM", "");
        else
            times[2] = times[2].replaceAll("PM", "");
        
        for (int i = 0 ; i < times.length ; i++) {

            if (i == times.length - 1) {
                System.out.print(times[i]);
            } else {
                System.out.print(times[i] + ":");
            }
        }
    }

}
