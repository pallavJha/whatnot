/*
Input Format 
The first line contains an integer N. 
The second line contains an integer K.
N lines follow. Each line contains an integer that denotes the candy in the ith packet.
Output Format 
An integer that denotes the minimum possible value of unfairness.*/
package pl.misc.hackerank.unmanaged;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AngryChildren {

    public static void main(String[] args)
    {
        int n, k;
        long temp=0L;
        List<Long> longList  = new ArrayList<Long>();
        List<Long> shortList  = new ArrayList<Long>();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        for(int i=0;i<n;i++)
        {
             temp=sc.nextLong();
             longList.add(temp);
        }
        Collections.sort(longList);
        for(int i=0;i<=n-k;i++)
        {
            shortList.add(longList.get(i+k-1)-longList.get(i));
        }
        System.out.println(Collections.min(shortList));
        
    }

}
