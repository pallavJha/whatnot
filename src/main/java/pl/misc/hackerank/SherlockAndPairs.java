package pl.misc.hackerank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndPairs 
{
    
    public static void main(String[] args) 
    {
        int noOfTestCase,j;
        ArrayList<Integer> list = new ArrayList<Integer>();
        long sum = 0L;
        Scanner sc = new Scanner(System.in);
        int count =0 ;
        noOfTestCase = sc.nextInt();
        int n[] = new int[noOfTestCase];
        int arr[][] = new int[noOfTestCase][];
        for(int i = 0 ; i < noOfTestCase; i++)
        {
            n[i] = sc.nextInt();
            arr[i] = new int[n[i]];
            for(j = 0 ; j<n[i] ; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 0 ; i < noOfTestCase; i++)
        {
            if(arr[i].length==1)
            {
                System.out.println("0");
                continue;
            }
            Arrays.sort(arr[i]);
            if(arr[i][0]==arr[i][1])
            {
                count++;
            }
            for(j = 1 ; j<n[i]-1 ; j++)
            {
                if((arr[i][j-1]==arr[i][j])&&arr[i][j]!=arr[i][j+1])
                {
                    count++;
                    list.add(count);
                    count=0;
                }
                if(arr[i][j]==arr[i][j+1])
                {
                    count++;
                }
            }
            if(arr[i][j]==arr[i][j-1])
            {
                count++;
                list.add(count);
                count=0;
            }
            count=0;
            System.out.println("Lsit contains :"+list);
            for(int k = 0 ; k < list.size();k++)
            {
                System.out.println("lsit.get" + list.get(k));
                sum+=((long)list.get(k))*((long)(list.get(k)-1));
                System.out.println("sum is :"+sum);
            }
            System.out.println(sum);
           
            list.clear();
            sum = 0;
        }
        
    }

}
