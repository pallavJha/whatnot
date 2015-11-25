package pl.misc.hackerRank;

import java.util.Scanner;

public class QuickSort {
    
    public static void main(String[] args) 
    {
        int sizeOfArray;
        Scanner sc = new Scanner(System.in);
        sizeOfArray = sc.nextInt();
        int arr[] = new int[sizeOfArray];

        for (int i = 0 ; i < sizeOfArray ; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, sizeOfArray - 1);

        System.out.println(arr[(sizeOfArray - 1) / 2]);
    }

    public static void quickSort(int arr[], int p, int r) 
    {
        if (p < r) {
            int q = partition(arr, p, r);

            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public static int partition(int arr[], int p, int r) {

        int pivot = p - 1, value;
        value = arr[r];
        for (int i = p ; i < r ; i++) {
            if (arr[i] <= value) {
                pivot++;
                swap(arr, pivot, i);
            }
        }

        pivot++;
        swap(arr, pivot, r);
        return pivot;
    }
    public static void printArray(int arr[]) 
    {
        for (int i = 0 ; i < arr.length ; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int arr[], int p, int r) {
        if (p == r) {

        } else {
            int temp = arr[p];
            arr[p] = arr[r];
            arr[r] = temp;
        }
        
    }

    
}
