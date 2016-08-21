package pl.misc.hackerank.unmanaged;

import java.util.Scanner;

public class MakeItAnagram {

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String s[] = new String[2];
        Integer arr[][] = new Integer[2][26];
        arr[0] = new Integer[26];
        arr[1] = new Integer[26];
        int sum = 0, k=0;
        while(k<2)
        {
            for(int i = 0 ; i < 26 ; i++)
            {
                arr[k][i] = 0;
            }
            k++;
        }
        for(int i = 0; i< 2; i++)
        {
            s[i] = new String(sc.next()); 
        }
        for(int j = 0; j  <2;j++)
        {
            for(int i = 0; i < s[j].length(); i++)
            {
                ++arr[j][((int)s[j].charAt(i))-97];
            }
        }
        for(int i = 0 ; i < 26 ; i++)
        {
            sum+=Math.abs(arr[0][i]-arr[1][i]);
        }
        System.out.println(sum);
    }

}
