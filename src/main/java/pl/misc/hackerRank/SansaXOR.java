package pl.misc.hackerRank;

import java.util.Scanner;
public class SansaXOR {

    public static void main(String[] args) 
    {
        int noOfTestcases, arraySize;
        Scanner sc = new Scanner(System.in);
        noOfTestcases = sc.nextInt();
        Integer arr[][] = new Integer[noOfTestcases][];
        for(int i= 0 ; i< noOfTestcases ; i++)
        {
            arraySize=sc.nextInt();
            arr[i] = new Integer[arraySize];
            for(int j = 0 ; j < arraySize ; j++)
            {
                arr[i][j]= sc.nextInt();
            }
            
        }
        calculateXOR(arr);
        //System.out.println(88792264^86676);
    }
    public static void calculateXOR(Integer[][] arr)
    {
        int size, sum;
        for(int w=0;w<arr.length;w++)
        {
            sum=0;
            size = arr[w].length;
            if(size%2==0)
            {
                System.out.println("0");
            }
            else
            {
                for(int i=0;i<arr[w].length;i++)
                {
                    if(i%2==0)
                    {
                        sum=sum^arr[w][i];
                    }
                }
                System.out.println(sum);
                sum=0;
            }
        }
    }

}
