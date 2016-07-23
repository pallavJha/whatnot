package pl.misc.hackerank;

import java.util.Scanner;

public class Median {

    public static void main(String[] args) 
    {
        int sizeOfArray;
        int q=0;
        Scanner sc = new Scanner(System.in);
        sizeOfArray = sc.nextInt();
        int arr[] = new int[sizeOfArray];
        for (int i = 0 ; i < sizeOfArray ; i++) 
        {
            arr[i] = sc.nextInt();
        }
         findMedian(arr, 0, sizeOfArray-1);
    }
    public static void findMedian(int[] arr, int start, int end)
    {
        int mid = end/2;
        System.out.println(mid);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }
        int q=0;
        while(1==1)
        {
            q=partition(arr, start, end);
            if(q!=mid)
            {
                end=end-1;
                
            }
            else
            {
                System.out.println(arr[q]);
                break;
            }
            
        }
    }
    

    public static void swap(int arr[], int p, int r) {
        if (p == r) {

        } else {
            int temp = arr[p];
            arr[p] = arr[r];
            arr[r] = temp;
        }
        
    }

    public static int partition(int arr[], int p, int r) {
        
        System.out.println("Calling for P : "+p+" r : "+r);
        System.out.println("****************Value at pivot : "+arr[r]);
        int pivot = p - 1, value;
        value = arr[r];
        boolean status = false;
        for (int i = p ; i < r ; i++) {
            if (arr[i] <= value) {
                pivot++;
                swap(arr, pivot, i);
            }
        }

        pivot++;
        swap(arr, pivot, r);
        System.out.println("****************Value Returned : "+pivot);
        return pivot;
    }

}
