package pl.misc.hackerRank;

import java.util.Scanner;

public class CutTheSticks {

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
         
        int sizeToCut, temp, count=0, tempTemp;
        
        sizeToCut = min(sticks);
        while(sizeToCut>0)
        {
            for(int i = 0 ; i < sticks.length ; i++)
            {
                if(sticks[i]>0)
                {
                    sticks[i]=sticks[i]-sizeToCut;
                    count++;
                }
            }
            System.out.println(count);
            count=0;
            sizeToCut = min(sticks);
        }
    }
    public static int min(int[] array) 
    {
        
        int count=0;
        int min;
        if(array[0]==0)
        {
            min = 1;
        }
        else
        {
            min = array[0];
        }
        for (int i = 0; i < array.length; i++) 
        {
            if(array[i]>0)
            {
                if (array[i] < min)
                {
                    min = array[i];
                }
            }
        }
        if(min==1)
        {
            for(int i = 0 ; i  < array.length;i++)
            {
                if(array[i]==0)
                {
                    count++;
                }
            }
            if(count==array.length)
            {
                min=0;
            }
            else if(count==array.length-1)
            {
                min=max(array);
            }
        }
        return min;
    }
    
    public static int max(int[] array)
    {

        int max = array[0];
        for (int i = 1 ; i < array.length ; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;

    }

}
