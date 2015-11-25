package pl.misc.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {

    public static void main(String[] args) 
    {
        int noOfToys,bucks, toys=0;
        Scanner sc = new Scanner(System.in);
        noOfToys = sc.nextInt();
        bucks = sc.nextInt();
        int prices[] = new int[noOfToys];
        for(int i=0; i<noOfToys;i++)
        {
           prices[i] = sc.nextInt();
        }
        Arrays.sort(prices);
        for(int i=0;i<noOfToys;i++)
        {
            if(prices[i]<=bucks)
            {
                toys++;
                bucks=bucks-prices[i];
                if(bucks<=0)
                {
                    break;
                }
            }
        }
        System.out.println(toys);
        
    }

}
