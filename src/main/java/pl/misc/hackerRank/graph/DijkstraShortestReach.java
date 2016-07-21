package pl.misc.hackerRank.graph;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author pallav
 * @version 1.0
 * @since 21/7/16
 */


/**
 * Sample Input
 * 1
 * 4 4
 * 1 2 24
 * 1 4 20
 * 3 1 3
 * 4 3 12
 * 1
 */

public class DijkstraShortestReach {

    private DijkstraShortestReach(){

    }

    /**
     * Main Method
     * @param args Run Time Args
     */
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        for (int i = 0; i < noOfTestCases; i++) {
            calculateShortestPathToAllEdges(sc);
        }
    }

    private static void calculateShortestPathToAllEdges(Scanner sc) {
        int noOfNodes = sc.nextInt();
        int noOfEdges = sc.nextInt();
        int[][] adjMatrix = new int[noOfNodes + 1][noOfNodes + 1];

        for (int i = 0; i < noOfEdges; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int weight = sc.nextInt();
            if ((adjMatrix[row][col] == 0) || (adjMatrix[row][col] > weight)) {
                adjMatrix[row][col] = weight;
                adjMatrix[col][row] = weight;
            }
        }
        int startNode = sc.nextInt();
        printArray(runDijkstraAlgorithm(noOfNodes, adjMatrix, startNode), startNode);
    }

    private static int[] runDijkstraAlgorithm(int noOfNodes, int[][] adjMatrix, int startNode) {
        int[] distance = getDistanceArray(noOfNodes);

        boolean[] visited = new boolean[noOfNodes + 1];
        int currentNode = startNode;
        distance[startNode] = 0;
        visited[startNode] = true;
        int total = 1;
        while (total < noOfNodes) {
            for (int i = 1; i <= noOfNodes; i++) {
                if (!visited[i]
                        && adjMatrix[currentNode][i] > 0
                        && distance[i] > (adjMatrix[currentNode][i] + distance[currentNode])) {
                    distance[i] = adjMatrix[currentNode][i] + distance[currentNode];
                }
            }

            currentNode = getNextNodeToVisit(noOfNodes, distance, visited);
            visited[currentNode] = true;
            total++;
        }
        return distance;
    }

    private static int getNextNodeToVisit(int noOfNodes, int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int nextNode = 0;
        for (int i = 1; i <= noOfNodes; i++) {
            if (!visited[i] && min > distance[i]) {
                min = distance[i];
                nextNode = i;
            }
        }
        return nextNode;
    }

    private static int[] getDistanceArray(int noOfNodes) {
        int[] distance = new int[noOfNodes + 1];
        IntStream.range(0, noOfNodes + 1)
                .forEach(i -> distance[i] = Integer.MAX_VALUE);
        return distance;
    }

    private static void printArray(int[] arr, int startNode) {
        IntStream.range(0, arr.length)
                .filter(i -> arr[i] == Integer.MAX_VALUE)
                .forEach(i -> arr[i] = -1);

        IntStream.range(0, arr.length)
                .filter(i -> i != 0 && i != startNode)
                .forEach(i -> System.out.print(arr[i] + " "));
        System.out.println();
    }
}
