package pl.misc.geeksforgeeks.google;

import java.util.Scanner;

/**
 * @author Pallav Jha
 * @since 27/5/18
 */
public class SubArrayWithGivenSum {

    private SubArrayWithGivenSum() {

    }

    private static int[] getSubArrayIndices(int[] arr, int sum) {
        int currentSum = 0;
        int startIndex = 0;
        int endIndex;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            endIndex = i;
            if (currentSum == sum) {
                return new int[]{startIndex + 1, endIndex + 1};
            }
            if (currentSum > sum) {
                for (int j = startIndex; j < endIndex; j++) {
                    startIndex = j + 1;
                    currentSum -= arr[j];
                    if (currentSum == sum) {
                        return new int[]{startIndex + 1, endIndex + 1};
                    }
                    if (currentSum < sum) {
                        break;
                    }
                }
            }
        }
        return null;
    }

    public static void main2(String[] args) {
        int[] result = getSubArrayIndices(new int[]{1, 2, 3, 7, 5}, 12);
        printArr(result);
        result = getSubArrayIndices(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15);
        printArr(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfTests = sc.nextInt();
        for (int i = 0; i < numOfTests; i++) {
            int length = sc.nextInt();
            int sum = sc.nextInt();
            int[] arr = new int[length];
            for (int j = 0; j < length; j++) {
                arr[j] = sc.nextInt();
            }
            int[] result = getSubArrayIndices(arr, sum);
            printArr(result);
        }
    }

    private static void printArr(int[] result) {
        if (result != null) {
            System.out.println(result[0] + " " + result[1]);
        } else {
            System.out.println("-1");
        }
    }
}
