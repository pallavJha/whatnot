package pl.misc.hackerank.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author pallav
 * @version 1.0
 * @since 22/7/16
 */
/*
* Sample Input
10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8
*/
public class EvenTree {
    private EvenTree() {

    }

    /**
     * Main Method
     *
     * @param args Run Time Args
     */
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        calculateEvenTree(sc);
    }

    private static void calculateEvenTree(Scanner sc) {
        int noOfNodes = sc.nextInt();
        int noOfEdges = sc.nextInt();
        boolean[][] adjMatrix = new boolean[noOfNodes + 1][noOfNodes + 1];

        for (int i = 0; i < noOfEdges; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            adjMatrix[row][col] = adjMatrix[col][row] = true;
        }
        System.out.println(calculateNoOfEvenTree(noOfNodes, adjMatrix));
    }

    private static int calculateNoOfEvenTree(int noOfNodes, boolean[][] adjMatrix) {
        int evenTrees = 0;
        int currentNode = 1;
        while (currentNode <= noOfNodes) {
            for (int i = 1; i <= noOfNodes; i++) {
                if (adjMatrix[currentNode][i]) {
                    boolean removed = performRemovalOfEdge(currentNode, i, noOfNodes, adjMatrix);
                    evenTrees = removed ? evenTrees + 1 : evenTrees;
                }
            }
            currentNode++;
        }
        return evenTrees;
    }

    private static boolean performRemovalOfEdge(int currentNode, int i, int noOfNodes, boolean[][] adjMatrix) {
        adjMatrix[currentNode][i] = adjMatrix[i][currentNode] = false;
        int noOfNodesInSubTree = findNoOfNodesInSubTree(i, noOfNodes, adjMatrix);
        if (noOfNodesInSubTree % 2 == 0) {
            int noOfNeighbours = 0;
                for (int k = 0; k <= noOfNodes; k++) {
                    if (adjMatrix[currentNode][k]) {
                        noOfNeighbours++;
                    }
                }
            return noOfNeighbours > 0;
        } else {
            adjMatrix[currentNode][i] = adjMatrix[i][currentNode] = true;
            return false;
        }
    }

    /**
     * BFS to find the number of nodes.
     *
     * @param startNode start node
     * @param noOfNodes no. of nodes
     * @param adjMatrix adjacency matrix
     * @return number of nodes in the graph/sub-graph
     */
    private static int findNoOfNodesInSubTree(int startNode, int noOfNodes, boolean[][] adjMatrix) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[noOfNodes + 1];
        int nodesCount = 1;
        int currentNode;

        visited[startNode] = true;
        queue.add(startNode);


            while (!queue.isEmpty()) {
                currentNode = queue.poll();
                for (int i = 1; i <= noOfNodes; i++) {
                    if (!visited[i] && adjMatrix[currentNode][i]) {
                        queue.add(i);
                        visited[i] = true;
                        nodesCount++;
                    }
                }
            }
        return nodesCount;
    }
}
