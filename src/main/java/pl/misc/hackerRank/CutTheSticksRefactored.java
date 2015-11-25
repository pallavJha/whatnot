package pl.misc.hackerRank;

import java.util.Scanner;

public class CutTheSticksRefactored {

    public static void main(String[] args) 
    {
        int noOfSticks;
        Scanner sc = new Scanner(System.in);
        noOfSticks = sc.nextInt();
        int[] sticks = new int[noOfSticks];
        for(int i = 0; i< noOfSticks ;i++)
        {
            sticks[i] = sc.nextInt();
        }
        cut(sticks);
    }
    public static void cut(int[] sticks)
    {
         
        int sizeToCut, temp, tempTemp;
        
        sizeToCut = minForOneTime(sticks);
        while(sizeToCut>0)
        {
            for(int i = 0 ; i < sticks.length ; i++)
            {
                    sticks[i]=sticks[i]-sizeToCut;
            }
            System.out.println(countArray(sticks));
            sizeToCut = min(sticks);
        }
    }
    public static int minForOneTime(int[] array) 
    {
        int min = array[0];
        for (int i = 0; i < array.length; i++) 
        {
                if (array[i] < min)
                {
                    min = array[i];
                }
        }
        
        return min;
    }
    public static int min(int[] array) 
    {
        
        int min=array[0];
        
        int newI=0;
        if(min<=0)
        for (int i = 0; i < array.length; i++) 
        {
            if (array[i] > 0)
            {
                min = array[i];
                break;
            }
            newI=i;
        }
        if(newI==array.length)
        {
            return 0;
        }
        for (int i = 0; i < array.length; i++) 
        {
                if (array[i] < min && array[i]>0)
                {
                    min = array[i];
                }
        }
        
        return min;
    }
    
    public static int countArray(int[] array)
    {

        int count=0;
        for (int i = 0 ; i < array.length ; i++) 
        {
            
            if (array[i] >= 0) 
            {
                count++;
            }
        }
        return count;

    }

}
