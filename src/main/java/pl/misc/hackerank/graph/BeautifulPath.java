package pl.misc.hackerank.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author pallav
 * @version 1.0
 * @since 31/7/16
 */
public class BeautifulPath {


    /**
     * Main Method
     *
     * @param args Run Time Args
     */
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        calculateShortestPath(sc);
    }

    private static void calculateShortestPath(Scanner sc) {
        int noOfNodes = sc.nextInt();
        int noOfEdges = sc.nextInt();
        int[][] adjacencyMatrix = new int[noOfNodes + 1][noOfNodes + 1];


        for (int i = 0; i < noOfEdges; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int weight = sc.nextInt();
            if ((adjacencyMatrix[row][col] == 0) || (adjacencyMatrix[row][col] > weight)) {
                adjacencyMatrix[col][row] = adjacencyMatrix[row][col] = weight;
            }
        }

        IntStream.rangeClosed(0, noOfNodes)
                .forEach(i -> adjacencyMatrix[i][i] = 0);

        int startNode = sc.nextInt();
        int endNode = sc.nextInt();
        System.out.println(runDijkstraAlgorithm(noOfNodes, adjacencyMatrix, startNode, endNode));
    }

    private static int runDijkstraAlgorithm(int noOfNodes, int[][] adjMatrix, int startNode, int endNode) {
        int[] distance = getDistanceArray(noOfNodes);

        boolean[] visited = new boolean[noOfNodes + 1];
        int[] parent = new int[noOfNodes + 1];
        int currentNode = startNode;
        distance[startNode] = 0;
        visited[startNode] = true;
        parent[startNode] = 0;
        int total = 1;
        int shortestDistance = -1;
        while (total < noOfNodes) {
            for (int i = 1; i <= noOfNodes; i++) {
                if (!visited[i]
                        && adjMatrix[currentNode][i] > 0
                        && distance[i] > (adjMatrix[currentNode][i] + distance[currentNode])) {
                    distance[i] = adjMatrix[currentNode][i] + distance[currentNode];
                    parent[i] = currentNode;
                }
            }

            currentNode = getNextNodeToVisit(noOfNodes, distance, visited);
            visited[currentNode] = true;
            total++;
            if (currentNode == endNode) {
                shortestDistance = distance[endNode];
                break;
            }
        }
        if (shortestDistance != -1){
            List<Integer> costList = new LinkedList<>();
            prepareCostList(costList, endNode, parent, adjMatrix);
            return costList.stream()
                    .reduce(0, (a, b) -> a | b);

        }
        return -1;
    }

    private static void prepareCostList(List<Integer> costList, int endNode, int[] parent, int[][] adjMatrix){
        if (parent[endNode] != 0){
            costList.add(adjMatrix[endNode][parent[endNode]]);
            prepareCostList(costList, parent[endNode], parent, adjMatrix);
        }
        System.out.println(endNode);
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
        IntStream.rangeClosed(0, noOfNodes)
                .forEach(i -> distance[i] = Integer.MAX_VALUE);
        return distance;
    }

}