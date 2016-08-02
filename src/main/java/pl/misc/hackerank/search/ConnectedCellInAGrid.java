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
        int[][] arr = collectInput(rows, cols, sc);
        System.out.println(findLargestRegion(rows, cols, arr));
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

    private static int[][] prepareAdjMatrix(int[][] arr) {
        int[][] adjMatrix = new int[][]
    }

    private static int findLargestRegion(int rows, int cols, int[][] adjMatrix) {
        int indexSize = rows > cols ? rows : cols;
        boolean[] visited = new boolean[indexSize];
        int currentNode = fetchFirstNode(adjMatrix);
        visited[currentNode] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(currentNode);
        List<Integer> lengthList = new LinkedList<>();
        int count = 1;
        int oldCount;
        while (!stack.isEmpty()) {
            currentNode = stack.peek();
            int nextElement = getUnvisitedChildNode(currentNode, adjMatrix, visited);
            if (nextElement != -1) {
                visited[nextElement] = true;
                stack.push(nextElement);
                count += 2;
            } else {
                stack.pop();
                oldCount = count;
                count -= 2;
                lengthList.add(oldCount);
            }
        }
        return lengthList.isEmpty() ? 0 : Collections.max(lengthList);
    }

    private static int getUnvisitedChildNode(int currentNode, int[][] adjMatrix, boolean[] visited) {
        for (int j = 0; j < adjMatrix.length; j++) {
            if (adjMatrix[currentNode][j] > 0 && !visited[j] && Math.abs(j - currentNode) <= 1) {
                return j;
            }
        }
        return -1;
    }

    private static int fetchFirstNode(int[][] adjMatrix) {
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (adjMatrix[j][i] == 1) {
                    return j;
                }
            }
        }
        return 0;
    }
}