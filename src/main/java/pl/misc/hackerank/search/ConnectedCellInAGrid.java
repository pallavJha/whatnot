package pl.misc.hackerank.search;

import java.util.*;

/**
 * @author pallav
 * @version 1.0
 * @since 1/8/16
 */
/*
Sample Input
4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0
*/
public class ConnectedCellInAGrid {

    private ConnectedCellInAGrid() {
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] inputArray = collectInput(rows, cols, sc);
        int[][] adjMatrix = buildAdjMatrix(rows, cols, inputArray);
        System.out.println(findLargestRegion(rows, cols, adjMatrix));
        sc.close();
    }

    private static int[][] collectInput(int rows, int cols, Scanner sc) {
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }

    private static int[][] buildAdjMatrix(int rows, int cols, int[][] arr) {
        int noOfNodes = rows * cols;
        int[][] adjMatrix = new int[noOfNodes][noOfNodes];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int adjX = getNodeIndex(cols, i, j);
                if (arr[i][j] == 1) {
                    if (i > 0 && j > 0 && arr[i - 1][j - 1] == 1) {
                        int adjY = getNodeIndex(cols, i - 1, j - 1);
                        adjMatrix[adjX][adjY] = 1;
                        adjMatrix[adjY][adjX] = 1;
                    }
                    if (i > 0 && arr[i - 1][j] == 1) {
                        int adjY = getNodeIndex(cols, i - 1, j);
                        adjMatrix[adjX][adjY] = 1;
                        adjMatrix[adjY][adjX] = 1;
                    }
                    if (i > 0 && (j + 1) < cols && arr[i - 1][j + 1] == 1) {
                        int adjY = getNodeIndex(cols, i - 1, j + 1);
                        adjMatrix[adjX][adjY] = 1;
                        adjMatrix[adjY][adjX] = 1;
                    }
                    if (j > 0 && arr[i][j - 1] == 1) {
                        int adjY = getNodeIndex(cols, i, j - 1);
                        adjMatrix[adjX][adjY] = 1;
                        adjMatrix[adjY][adjX] = 1;
                    }
                    if ((j + 1) < cols && arr[i][j + 1] == 1) {
                        int adjY = getNodeIndex(cols, i, j + 1);
                        adjMatrix[adjX][adjY] = 1;
                        adjMatrix[adjY][adjX] = 1;
                    }
                    if ((i + 1) < rows && j > 0 && arr[i + 1][j - 1] == 1) {
                        int adjY = getNodeIndex(cols, i + 1, j - 1);
                        adjMatrix[adjX][adjY] = 1;
                        adjMatrix[adjY][adjX] = 1;
                    }
                    if ((i + 1) < rows && arr[i + 1][j] == 1) {
                        int adjY = getNodeIndex(cols, i + 1, j);
                        adjMatrix[adjX][adjY] = 1;
                        adjMatrix[adjY][adjX] = 1;
                    }
                    if ((i + 1) < rows && (j + 1) < cols && arr[i + 1][j + 1] == 1) {
                        int adjY = getNodeIndex(cols, i + 1, j + 1);
                        adjMatrix[adjX][adjY] = 1;
                        adjMatrix[adjY][adjX] = 1;
                    }
                }
            }
        }
        return adjMatrix;
    }

    private static int getNodeIndex(int cols, int i, int j) {
        return (cols * i) + j;
    }


    private static int findLargestRegion(int rows, int cols, int[][] adjMatrix) {
        int indexSize = rows * cols;
        List<Integer> lengthList = new LinkedList<>();
        for (int currentNode = 0; currentNode < indexSize; currentNode++) {
            boolean[] visited = new boolean[indexSize];
            int node = currentNode;
            visited[node] = true;
            Stack<Integer> stack = new Stack<>();
            stack.push(node);
            int count = 1;
            int oldCount;
            while (!stack.isEmpty()) {
                node = stack.peek();
                int nextElement = getUnvisitedChildNode(node, adjMatrix, visited);
                if (nextElement != -1) {
                    visited[nextElement] = true;
                    stack.push(nextElement);
                    count++;
                } else {
                    stack.pop();
                    oldCount = count;
                    count--;
                    lengthList.add(oldCount);
                }
            }
        }
        return lengthList.isEmpty() ? 0 : Collections.max(lengthList);
    }

    private static int getUnvisitedChildNode(int currentNode, int[][] adjMatrix, boolean[] visited) {
        List<Integer> unvisitedNodes = new LinkedList<>();
        for (int j = 0; j < adjMatrix.length; j++) {
            if (adjMatrix[currentNode][j] > 0 && !visited[j]) {
                unvisitedNodes.add(j);
            }
        }
        if (unvisitedNodes.size() == 2) {
            int a = unvisitedNodes.get(0);
            int b = unvisitedNodes.get(1);
            List<Integer> aList = getUnvisitedNodes(a, adjMatrix, visited);
            List<Integer> bList = getUnvisitedNodes(b, adjMatrix, visited);
            if (aList.contains(b) && bList.contains(a)) {
                return aList.size() > bList.size() ? b : a;
            } else {
                return aList.size() > bList.size() ? a : b;
            }
        } else {
            return !unvisitedNodes.isEmpty() ? unvisitedNodes.get(0) : -1;
        }
    }

    private static List<Integer> getUnvisitedNodes(int currentNode, int[][] adjMatrix, boolean[] visited) {
        List<Integer> unvisitedNodes = new LinkedList<>();
        for (int j = 0; j < adjMatrix.length; j++) {
            if (adjMatrix[currentNode][j] > 0 && !visited[j]) {
                unvisitedNodes.add(j);
            }
        }
        return unvisitedNodes;
    }

}