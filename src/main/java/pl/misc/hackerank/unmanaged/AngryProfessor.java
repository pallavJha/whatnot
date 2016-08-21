package pl.misc.hackerank.unmanaged;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AngryProfessor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> stringList = new ArrayList<String>();
        int count = 0;
        int t = in.nextInt();
        for (int i = 0 ; i < t ; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            for (int j = 0 ; j < n ; j++) {
                if (in.nextInt() <= 0) {
                    count++;
                }
            }
            if (count >= k) {
                stringList.add("NO");
            } else {
                stringList.add("YES");
            }
            count = 0;
        }
        for (int i = 0 ; i < stringList.size() ; i++) {
            System.out.println(stringList.get(i));
        }
    }
}
