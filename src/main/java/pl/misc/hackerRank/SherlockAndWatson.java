package pl.misc.hackerRank;

import java.util.Scanner;

public class SherlockAndWatson {

    public static void main(String[] args) 
    {
        Scanner sc =new Scanner(System.in);
        int n, q, k;
        n=sc.nextInt();
        k=sc.nextInt();
        q=sc.nextInt();
        
        int arr[] = new int[n];
        int arr2[] = new int[n];
        int qArray[] = new int[q];
        for(int i = 0; i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0; i< q; i++)
        {
            qArray[i] = sc.nextInt(); 
        }
        rightCircularRotation(arr,arr2, k);
        for(int i = 0; i< q; i++)
        {
            System.out.println(arr2[qArray[i]]); 
        }
    }
    public static void rightCircularRotation(int arr[], int arr2[], int k)
    {
        int n = arr.length;
        if(k>n)
        {
            k=k%n;
        }
        for(int i=0;i<n-k;i++)
        {
            arr2[i+k] = arr[i];
        }
        for(int i=n-k;i<n;i++)
        {
            arr2[i-(n-k)]=arr[i];
        }
    }

}
