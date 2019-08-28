package pl.misc.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Next Greater Element I - LeetCode
 *
 * @author Pallav Jha
 * @apiNote https://leetcode.com/problems/next-greater-element-i/
 * @since August 28, 2019
 */
public class NextGreaterElementI {

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2.length == 0) {
            int[] returnArr = new int[nums1.length];
            Arrays.fill(returnArr, -1);
            return returnArr;
        }
        int[] lastGrtArr = new int[1000];
        int currentPointer = -1;

        Map<Integer, Integer> nextGrtElemMap = new HashMap<>();
        nextGrtElemMap.put(nums2[nums2.length - 1], -1);
        int lastElem = nums2[nums2.length - 1];
        int lastGrtElem = -1;
        for (int i = nums2.length - 2; i > -1; i--) {
            if (nums2[i] < lastElem) {
                nextGrtElemMap.put(nums2[i], lastElem);
                if (currentPointer == -1 || lastGrtArr[currentPointer] != lastElem) {
                    lastGrtArr[++currentPointer] = lastElem;
                }
                lastElem = nums2[i];
                lastGrtElem = lastElem;
            } else if (nums2[i] < lastGrtElem) {
                nextGrtElemMap.put(nums2[i], lastGrtElem);
                if (currentPointer == -1 || lastGrtArr[currentPointer] != lastGrtElem) {
                    lastGrtArr[++currentPointer] = lastGrtElem;
                }
                lastElem = nums2[i];
                lastGrtElem = lastElem;
            } else {
                int j;
                for (j = currentPointer; j > -1; j--) {
                    if (nums2[i] < lastGrtArr[j]) {
                        nextGrtElemMap.put(nums2[i], lastGrtArr[j]);
                        break;
                    }
                }
                if (j == -1) {
                    nextGrtElemMap.put(nums2[i], -1);
                }
                lastElem = nums2[i];
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGrtElemMap.get(nums1[i]);
        }
        return nums1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{})));
    }
}
