package pl.misc.hackerank.unmanaged;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TheMaximumSubArray {

    public static final long max_long_here = 100000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<long[]> list = new LinkedList<long[]>();
        int n = sc.nextInt();
        for (int i = 0 ; i < n ; i++) {
            int size = sc.nextInt();
            long arr[] = new long[size];
            for (int j = 0 ; j < size ; j++) {
                arr[j] = sc.nextLong();
            }
            list.add(calculate(arr, size));
            // consise(arr);
        }
        sc.close();
        for (int i = 0 ; i < list.size() ; i++) {
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }
    }

    public static long[] calculate(long arr[], int size) {
        long sum = 0, non_sum = 0, max_sum = 0, old_sum = 0;
        boolean allNegative = true;
        boolean negativeTriggered = false;
        List<Long> sumList = new LinkedList<Long>();

        if (arr.length == 1) {
            long[] retArr = new long[2];
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
            long max = Long.MIN_VALUE;
            for (int i = 0 ; i < size ; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            long[] retArr = new long[2];
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

        /*for (int i = 1 ; i < size ; i++) {
            if (arr[i] < 0 && arr[i - 1] == 0) {
                arr[i] = 0;
            }
        }
        for (int i = size - 2 ; i >= 0 ; i--) {
            if (arr[i] < 0 && arr[i + 1] == 0) {
                arr[i] = 0;
            }
        }*/

        arr = consise(arr);
        size = arr.length;
        for (int i = 0 ; i < size ; i++) {
            if (arr[i] >= 0) {
                non_sum += arr[i];
            }
            sum += arr[i];
            if (arr[i] < 0) {
                if (old_sum == 0) {
                    old_sum = sum - arr[i];
                }
                negativeTriggered = true;
            }
            if (negativeTriggered && arr[i] > 0) {
                negativeTriggered = false;
                if (old_sum < sum) {
                    old_sum = 0;
                    if (sum < arr[i]) {
                        sumList.add(sum);
                        sum = arr[i];
                    }
                } else {
                    sumList.add(old_sum);
                    sum = 0;
                    old_sum = 0;
                }
            }
        }
        if (sumList.size() > 0) {
            max_sum = Collections.max(sumList);
        } else {
            max_sum = sum;
        }

        long[] retArr = new long[2];
        retArr[0] = max_sum > sum ? max_sum : sum;
        retArr[1] = non_sum;

        return retArr;
    }

    public static long[] consise(long arr[]) {
        int zeroCount = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == 0L) {
                zeroCount++;
            }
        }
        if (zeroCount > 0) {
            long arr2[] = new long[arr.length - zeroCount];
            int j = 0;
            for (int i = 0 ; i < arr.length ; i++) {
                if (arr[i] != 0L) {
                    arr2[j++] = arr[i];
                }
            }
            arr = arr2;
        }

        for (int i = 0 ; i < arr.length - 1 ; i++) {
            if (isPositive(arr[i]) && isPositive(arr[i + 1])) {
                arr[i + 1] += arr[i];
                arr[i] = 0;
            } else if (isNegative(arr[i]) && isNegative(arr[i + 1])) {
                arr[i + 1] += arr[i];
                arr[i] = 0;
            }
        }

        zeroCount = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == 0L) {
                zeroCount++;
            }
        }
        if (zeroCount > 0) {
            long arr2[] = new long[arr.length - zeroCount];
            int j = 0;
            for (int i = 0 ; i < arr.length ; i++) {
                if (arr[i] != 0L) {
                    arr2[j++] = arr[i];
                }
            }
            arr = arr2;
        }
        
        return arr;
        // printArray(list.toArray());
        // prepare(arr);
    }

    public static boolean isPositive(long a) {
        return a >= 0L;
    }

    public static boolean isNegative(long a) {
        return a <= 0L;
    }

    public static void prepare(long[] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == max_long_here) {
                arr[i] = 0L;
            }
        }
    }

    public static void printArray(Object[] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

}
