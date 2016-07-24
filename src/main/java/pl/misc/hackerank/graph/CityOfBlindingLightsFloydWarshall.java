package pl.misc.hackerank.graph;

import java.util.*;
import java.util.stream.IntStream;

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
        int[][] adjMatrix = prepareAdjMatrix(noOfNodes);
        for (int i = 0; i < noOfEdges; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int weight = scanner.nextInt();
            adjMatrix[row][col] = weight;
        }
        int noOfTestCases = scanner.nextInt();

        adjMatrix = calculateShortestDistance(noOfNodes, adjMatrix);

        //print result list
        for (int i = 0; i < noOfTestCases; i++) {
            int output = adjMatrix[scanner.nextInt()][scanner.nextInt()];
            System.out.println(output == 9999 ? -1 : output);
        }

    }

    private static int[][] calculateShortestDistance(int nofNodes, int[][] adjMatrix) {
        for (int i = 1; i <= nofNodes; i++) {
            for (int j = 1; j <= nofNodes; j++) {
                for (int k = 1; k <= nofNodes; k++) {
                    if ((adjMatrix[j][i] + adjMatrix[i][k]) < adjMatrix[j][k]) {
                        adjMatrix[j][k] = adjMatrix[j][i] + adjMatrix[i][k];
                    }
                }
            }
        }

        //Diagonal
        for (int i = 0; i <= nofNodes; i++) {
            adjMatrix[i][i] = 0;
        }

        return adjMatrix;
    }

    private static int[][] prepareAdjMatrix(int noOfNodes) {
        int[][] adjMatrix = new int[noOfNodes + 1][noOfNodes + 1];
        for (int[] arr : adjMatrix) {
            IntStream.rangeClosed(0, noOfNodes)
                    .forEach(i -> arr[i] = 9999);
        }
        return adjMatrix;
    }
}
