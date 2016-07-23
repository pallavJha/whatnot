package pl.misc.hackerank;

import java.util.Arrays;
import java.util.Scanner;

public class IceCreamParlor {

    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int noOfTestCases;
        noOfTestCases = sc.nextInt();
        int arr[][] = new int[noOfTestCases][];
        int m[] = new int[noOfTestCases];
        int n[] = new int[noOfTestCases];
        for(int i=0;i<noOfTestCases;i++)
        {
            m[i] = sc.nextInt();
            n[i] = sc.nextInt();
            arr[i] = new int[n[i]];
            for(int j= 0 ; j < n[i] ; j++)
            {
                arr[i][j]  = sc.nextInt();
            }
        }
       
    }
    public static void findThePair(int arr[][], int m[], int n[], int noOfTestCases)
    {
        int temp[];
        for(int i = 0 ; i < noOfTestCases ; i++)
        {
            temp = new int[n[i]];
            System.arraycopy( arr, 0, temp, 0, arr.length );
            Arrays.sort(temp);
            for(int j = 0; j < n[i]; j++)
            {
                int foundIndex = Arrays.binarySearch(temp,(m[i]-arr[i][j]));
                if(foundIndex >= 0)
                {
                    linearSearch(arr[i], (m[i]-arr[i][j]));
                }
            }
        }
    }
    static int linearSearch(int[] arr, int target)
    { 
      int i = 0;
      while (i < arr.length) {
        if (arr[i] == target) {
          return i;
        } 
        ++i;
      } 
      return -1;
    }

}
