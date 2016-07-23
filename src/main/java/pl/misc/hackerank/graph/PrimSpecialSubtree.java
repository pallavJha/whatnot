package pl.misc.hackerank.graph;

import java.util.Scanner;

/**
 * @author pallav
 * @version 1.0
 * @since 20/7/16
 */
/*
* Sample Input
5 6
1 2 3
1 3 4
4 2 6
5 2 2
2 3 5
3 5 7
1
*/
public class PrimSpecialSubtree {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        calculateMinimumWeight(sc);
    }

    private static void calculateMinimumWeight(Scanner sc) {
        int noOfNodes = sc.nextInt();
        int noOfEdges = sc.nextInt();
        int[][] adjMatrix = new int[noOfNodes + 1][noOfNodes + 1];
        for (int i = 0; i < noOfNodes + 1; i++) {
            for (int j = 0; j < noOfNodes + 1; j++) {
                adjMatrix[i][j] = -1;
            }
        }
        for (int i = 0; i < noOfEdges; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int weight = sc.nextInt();
            if ((adjMatrix[row][col] == -1) || (adjMatrix[row][col] > weight)) {
                adjMatrix[row][col] = weight;
                adjMatrix[col][row] = weight;
            }
        }
        int startNode = sc.nextInt();
        System.out.println(primAlgorithm(noOfNodes, adjMatrix, startNode));
    }

    private static int primAlgorithm(int noOfNodes, int[][] adjMatrix, int startNode) {
        int minimumDistance = 0;
        int[] parent = new int[noOfNodes + 1];
        int[] distance = new int[noOfNodes + 1];
        int total = 1;
        boolean[] visited = new boolean[noOfNodes + 1];
        parent[startNode] = 0;
        visited[startNode] = true;
        for (int i = 1; i <= noOfNodes; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[startNode] = 0;
        int currentNode = startNode;
        while (total < noOfNodes) {
            for (int i = 1; i <= noOfNodes; i++) {
                if (!visited[i] && adjMatrix[currentNode][i] != -1 && adjMatrix[currentNode][i] < distance[i]) {
                    distance[i] = adjMatrix[currentNode][i];
                    parent[i] = currentNode;
                }
            }

            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= noOfNodes; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    currentNode = i;
                }
            }

            visited[currentNode] = true;
            minimumDistance += min;
            total++;
        }
        return minimumDistance;
    }
}