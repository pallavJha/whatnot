/*
Input Format 
You will be given an array of integers. The number p is the first element in ar.

There are 2 lines of input:

n - the number of elements in the array ar
the n elements of ar (including p at the beginning)
Output Format 
Print out the numbers of the partitioned array on one line.

Constraints 
1<=n<=1000 
-1000<=x<= 1000 , x ∈ ar 
All elements will be distinct

Sample Input

5
4 5 3 7 2
Sample Output

3 2 4 5 7
*/
package pl.misc.hackerank.unmanaged;

import java.util.Scanner;

public class QuickSort1PartitionTemp {

    public static void main(String[] args) 
    {
        int sizeOfArray;
        Scanner sc = new Scanner(System.in);
        sizeOfArray = sc.nextInt();
        int arr[] = new int[sizeOfArray];
        for(int i = 0; i<sizeOfArray;i++)
        {
            arr[i] = sc.nextInt();
        }
        partition(arr);
        
    }
    public static void partition(int arr[])
    {
        int arrTemp[] = new int[arr.length];
        int k=0;
        for(int i = 1 ;i<arr.length;i++)
        {
            if(arr[i]<=arr[0])
            {
                arrTemp[k++] = arr[i];
            }
        }
        arrTemp[k++]=arr[0];
        for(int i = 1 ;i<arr.length;i++)
        {
            if(arr[i]>arr[0])
            {
                arrTemp[k++] = arr[i];
            }
        }
        printArray(arrTemp);
    }
    public static void printArray(int arr[])
    {
        for(int i = 0 ; i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    

}
