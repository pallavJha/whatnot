package pl.misc.hackerank.unmanaged;

import java.util.Scanner;

public class QuickInsertionComparison {


    public static int insertCount;
    public static int quickCount;
    public static void main(String[] args) {
        int sizeOfArray;
        Scanner sc = new Scanner(System.in);
        sizeOfArray = sc.nextInt();
        int arr[] = new int[sizeOfArray];
        int arr2[] = new int[sizeOfArray];
        for (int i = 0 ; i < sizeOfArray ; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0 ; i < sizeOfArray ; i++) {
            arr2[i] = arr[i];
        }
        quickSort(arr, 0, sizeOfArray - 1);
        insertIntoSorted(arr2);
        System.out.println(insertCount-quickCount);
    }

    public static void quickSort(int arr[], int p, int r) {

        if (p < r) {
            int q = partition(arr, p, r);
           // printArray(arr);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
            
        }
        
    }

    public static void printArray(int arr[]) {

        if (true) {
            for (int i = 0 ; i < arr.length ; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void swap(int arr[], int p, int r) {
        if (p == r) {

        } else {
            int temp = arr[p];
            arr[p] = arr[r];
            arr[r] = temp;
        }
        quickCount++;
    }

    public static int partition(int arr[], int p, int r) {

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

        return pivot;
    }
    public static void insertIntoSorted(int[] ar) {
        
        int n = ar.length;
        for (int j = 1; j < n; j++)
        {
            int key = ar[j];
            int i = j-1;
            while ( (i > -1) && ( ar [i] > key ) )
            {
                ar [i+1] = ar [i];
                i--;
                insertCount++;
            }
            ar[i+1] = key;
           
        }
    
      
    }


}
