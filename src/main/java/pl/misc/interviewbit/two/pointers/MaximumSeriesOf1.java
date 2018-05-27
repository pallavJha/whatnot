package pl.misc.interviewbit.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Pallav Jha
 * @since 1/5/18
 */
public class MaximumSeriesOf1 {

    class Node {
        int[] arr;
        int noOfZeroesLeftToPick;
        int zeroesPicked = 0;


        @Override
        public String toString() {
            return "Node{" +
                    "arr=" + Arrays.toString(arr) +
                    ", noOfZeroesLeftToPick=" + noOfZeroesLeftToPick +
                    ", zeroesPicked=" + zeroesPicked +
                    '}';
        }
    }

    class ReturnObj  implements Comparable<ReturnObj> {
        int maxOnes;
        List<Integer> indices;

        public ReturnObj(int maxOnes) {
            this.maxOnes = maxOnes;
        }

        @Override
        public String toString() {
            return "ReturnObj{" +
                    "maxOnes=" + maxOnes +
                    ", indices=" + indices +
                    '}';
        }

        @Override
        public int compareTo(ReturnObj o) {
            System.out.println("Comparing");
            System.out.println(this);
            System.out.println(o);

            int returnValue;
            if (o == null) {
                returnValue = 1;
            }
             else if (this.maxOnes > o.maxOnes) {
                returnValue = 1;
            }
            else if (this.maxOnes < o.maxOnes) {
                returnValue = -1;
            }
            else if (o.indices == null || o.indices.isEmpty()) {
                returnValue = 1;
            }
            else if (this.indices == null || this.indices.isEmpty()) {
                returnValue = -1;
            } else {
                returnValue = Integer.compare(this.indices.size(), o.indices.size());
            }
            System.out.println(returnValue);
            return returnValue;
        }
    }

    private ArrayList<Integer> zerosLocation = new ArrayList<>();

    private void maxSeries(int[] arr, int n) {
        IntStream.range(0, arr.length)
                .filter(i -> arr[i] == 0)
                .forEach(zerosLocation::add);

        Node root = new Node();
        root.noOfZeroesLeftToPick = zerosLocation.size();
        root.arr = Arrays.copyOf(arr, arr.length);
        ReturnObj number = getNumber(root, 0, n);
        System.out.println(number);
    }

    private ReturnObj getNumber(Node node, int currentLocation, int n) {
        //System.out.println(node);

        ReturnObj leftValue = new ReturnObj(0);
        ReturnObj rightValue = new ReturnObj(0);
        if (currentLocation != zerosLocation.size()) {
            Node leftNode = new Node();
            leftNode.noOfZeroesLeftToPick = node.noOfZeroesLeftToPick - 1;
            leftNode.arr = Arrays.copyOf(node.arr, node.arr.length);
            leftNode.arr[zerosLocation.get(currentLocation)] = 0;
            leftNode.noOfZeroesLeftToPick = node.noOfZeroesLeftToPick - 1;
            leftValue = getNumber(leftNode, currentLocation + 1, n);
            //System.out.println("leftValue : " + leftValue);

            Node rightNode = new Node();
            rightNode.noOfZeroesLeftToPick = node.noOfZeroesLeftToPick - 1;
            rightNode.arr = Arrays.copyOf(node.arr, node.arr.length);
            rightNode.arr[zerosLocation.get(currentLocation)] = 1;
            rightNode.noOfZeroesLeftToPick = node.noOfZeroesLeftToPick - 1;
            rightNode.zeroesPicked = node.zeroesPicked + 1;
            rightValue = getNumber(rightNode, currentLocation + 1, n);
            //System.out.println("RightValue : " + rightValue);
        }

        else if (node.zeroesPicked == n) {
            ReturnObj returnObj = new ReturnObj(0);
            int maxOnes = 0;
            int temp = 0;
            List<Integer> indices = new LinkedList<>();
            List<Integer> tempIndices = new LinkedList<>();
            for (int i = 0; i < node.arr.length; i++) {
                if (node.arr[i] == 1) {
                    temp++;
                    tempIndices.add(i);
                } else {
                    maxOnes = temp > maxOnes ? temp : maxOnes;
                    indices = new ArrayList<>(tempIndices);
                    temp = 0;
                    tempIndices = new LinkedList<>();
                }
                if (i == node.arr.length - 1) {
                    maxOnes = temp > maxOnes ? temp : maxOnes;
                    if (maxOnes == temp) {
                        indices = new ArrayList<>(tempIndices);
                    }
                }
            }
            returnObj.maxOnes = maxOnes;
            returnObj.indices = indices;
            //System.out.println("Returning : " + returnObj);
            return returnObj;
        }

        //System.out.println("Returning : " + (Math.max(leftValue.maxOnes, rightValue.maxOnes) == leftValue.maxOnes ? leftValue : rightValue));
        //System.out.println("Returning : " + (leftValue.compareTo(rightValue) == -1 ? rightValue : leftValue));
        //return Math.max(leftValue.maxOnes, rightValue.maxOnes) == leftValue.maxOnes ? leftValue : rightValue;
        return leftValue.compareTo(rightValue) == -1 ? rightValue : leftValue;
    }

    public static void main(String[] args) {
        MaximumSeriesOf1 obj = new MaximumSeriesOf1();
        //obj.maxSeries(new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 1}, 2);
        obj.maxSeries(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 1);
    }
}
