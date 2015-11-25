package pl.misc.hackerRank;

import java.util.Scanner;

public class CountingSort1 {

    public static void main(String[] args) 
    {
        int arraySize,sum=0;;
        String s=null;
        Scanner sc = new Scanner(System.in);
        arraySize=sc.nextInt();
        int buffer[] = new int[100];
        for(int i=0;i<arraySize;i++)
        {
            ++buffer[sc.nextInt()];
            s=sc.next();
        }
        for(int i=0;i<buffer.length;i++)
        {
            for(int j=0;j<=i;j++)
            {
                sum+=buffer[j];
            }
            System.out.print(sum+" ");
            sum=0;
        }
    }

}
