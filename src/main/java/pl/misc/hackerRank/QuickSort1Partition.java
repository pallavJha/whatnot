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
package pl.misc.hackerRank;

import java.util.Scanner;

public class QuickSort1Partition {

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
        quickSort(arr, 0, sizeOfArray-1);
        
    }
    public static void quickSort(int arr[], int p, int r)
    {   
       
        if(p<r)
        {
            int q=partition(arr, p, r);
            if (p <= q && q <= r) {
                quickSort(arr, p, q - 1);
                quickSort(arr, q + 1, r);
                
            }
        }   printArray(arr, p, r);
    }
    public static int partition(int arr[], int p, int r)
    {
        
        
        int arrTemp[] = new int[r-p+1];
        int k=0, value=arr[p], toReturn;
        for(int i = p+1 ;i<=r;i++)
        {
            if(arr[i]<=value)
            {
                arrTemp[k++] = arr[i];
            }
        }
        toReturn = k;
        arrTemp[k++]=arr[p];
        for(int i = p+1 ;i<=r;i++)
        {
            if(arr[i]>value)
            {
                arrTemp[k++] = arr[i];
            }
        }
        for(int i = p ;i<=r;i++)
        {
            arr[i]=arrTemp[i-p];
        }
        
        return toReturn;
    }
    
    public static void printArray(int arr[], int p, int r)
    {   
        
        if(true)
        {
            for(int i = p ; i<=r;i++)
            {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
    public static void swap(int arr[], int p, int r)
    {
        if(p==r)
        {
            
        }
        else
        {
            int temp = arr[p];
            arr[p]=arr[r];
            arr[r]=temp;
        }
    }
    /*public static int partition(int arr[], int p, int r)
    {   
        
        int pivot=p-1, value;
        value = arr[r];
        boolean status = false;
        for(int i=p;i<r;i++)
        {
            if(arr[i]<=value)
            {
                pivot++;
                
                swap(arr,pivot, i);
            }
        }
        
        pivot++;
        swap(arr,pivot, r);
        
        return pivot;
    }*/

}
