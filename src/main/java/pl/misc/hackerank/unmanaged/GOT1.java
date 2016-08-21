package pl.misc.hackerank.unmanaged;

import java.util.Scanner;

public class GOT1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        StringBuilder sb1=new StringBuilder(s1);
          checkPalinDrome(sb1);
        
    }
    public static void checkPalinDrome(StringBuilder sb1)
    {
        int a[]=new int[26];
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            a[i]=0;
        }
        for(int i=0;i<sb1.length();i++)
        {
            ++a[((int)sb1.charAt(i))-97];
        }
        for(int i=0;i<a.length;i++)
        {
            if(a[i]%2==1)
            {
                ++count;
            }
        }
        if(count>1)
        {
            System.out.println("NO");
        }
        else if(count<=1)
        {
            System.out.println("YES");
        }

    }

}
