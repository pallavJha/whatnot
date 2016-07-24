package pl.misc.hackerank.graph;

import java.util.*;

/**
 * @author pallav
 * @version 1.0
 * @since 24/7/16
 */
public class CityOfBlindingLightsFloydWarshall {

    private CityOfBlindingLightsFloydWarshall() {
    }


    /**
     * Main & Runtime Arguments
     *
     * @param args arguments
     */
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int noOfNodes = scanner.nextInt();
        int noOfEdges = scanner.nextInt();
        int[][] adjMatrix = new int[noOfNodes+1][noOfNodes+1];
        for (int i = 0; i < noOfEdges; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int weight = scanner.nextInt();
            adjMatrix[row][col] = weight;
        }
        int noOfTestCases = scanner.nextInt();
        List<Integer> output = new LinkedList<>();
        for (int i = 0; i < noOfTestCases; i++) {
            output.add(calculateShortestDistance(scanner.nextInt(), scanner.nextInt(), noOfNodes, adjMatrix));
        }

        //print resultList
        output.forEach(System.out::println);
    }

    private static int calculateShortestDistance(int startNode, int endNode, int nofNodes, int[][] adjMatrix) {
        return 0;
    }
}
