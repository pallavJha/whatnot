package pl.misc.hackerRank;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TheMaximumSubArray {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<int[]> list = new LinkedList<int[]>();
        int n = sc.nextInt();
        for (int i = 0 ; i < n ; i++) {
            int size = sc.nextInt();
            int arr[] = new int[size];
            for (int j = 0 ; j < size ; j++) {
                arr[j] = sc.nextInt();
            }
            list.add(calculate(arr, size));
        }
        sc.close();
        for (int i = 0 ; i < list.size() ; i++) {
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }
    }

    public static int[] calculate(int arr[], int size) {
        int sum = 0, non_sum = 0, max_sum = 0, old_sum = 0;
        boolean allNegative = true;
        boolean negativeTriggered = false;
        List<Integer> sumList = new LinkedList<Integer>();
        
        if (arr.length == 1) {
            int[] retArr = new int[2];
            retArr[0] = arr[0];
            retArr[1] = arr[0];
            return retArr;
        }

        for (int i = 0 ; i < size ; i++) {
            if (arr[i] > 0) {
                allNegative = false;
                break;
            }
        }

        if (allNegative) {
            int max = Integer.MIN_VALUE;
            for (int i = 0 ; i < size ; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            int[] retArr = new int[2];
            retArr[0] = max;
            retArr[1] = max;
            return retArr;
        }

        if (arr[0] < 0) {
            arr[0] = 0;
        }

        if (arr[size - 1] < 0) {
            arr[size - 1] = 0;
        }

        for (int i = 1 ; i < size ; i++) {
            if (arr[i] < 0 && arr[i - 1] == 0) {
                arr[i] = 0;
            }
        }
        for (int i = size - 2 ; i >= 0 ; i--) {
            if (arr[i] < 0 && arr[i + 1] == 0) {
                arr[i] = 0;
            }
        }
        for (int i = 0 ; i < size ; i++) {
            if (arr[i] >= 0) {
                non_sum += arr[i];
            }
            sum += arr[i];
            if (arr[i] < 0) {
                if(old_sum == 0){
                    old_sum = sum - arr[i];
                }
                negativeTriggered = true;
            }
            if (negativeTriggered && arr[i] > 0) {
                negativeTriggered = false;
                if (old_sum < sum) {
                    old_sum = 0;
                } else {
                    sumList.add(old_sum);
                    sum = 0;
                    old_sum = 0;
                }
            } 
        }
        max_sum = Collections.max(sumList); 
        int[] retArr = new int[2];
        retArr[0] = max_sum > sum ? max_sum : sum;
        retArr[1] = non_sum;
        return retArr;
    }

}
