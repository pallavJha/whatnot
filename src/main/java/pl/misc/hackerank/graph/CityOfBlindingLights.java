package pl.misc.hackerank.graph;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author pallav
 * @version 1.0
 * @since 23/7/16
 */
/*
Sample Input
4 5
1 2 5
1 4 24
2 4 6
3 4 4
3 2 7
3
1 2
3 1
1 4
*/
public class CityOfBlindingLights {

    private CityOfBlindingLights() {
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
        HashMap<Integer, HashSet<Edge>> adjMatrix = prepareAdjMatrix(noOfNodes);
        for (int i = 0; i < noOfEdges; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int weight = scanner.nextInt();
            Edge e = new Edge(row, col, weight);
            Set<Edge> edgeSet = adjMatrix.get(row);
            if (!edgeSet.add(e)) {
                edgeSet.remove(e);
                edgeSet.add(e);
            }
        }
        int noOfTestCases = scanner.nextInt();
        List<Integer> output = new LinkedList<>();
        for (int i = 0; i < noOfTestCases; i++) {
            output.add(calculateShortestDistance(scanner.nextInt(), scanner.nextInt(), noOfNodes, adjMatrix));
        }

        //print resultList
        output.forEach(System.out::println);
    }

    private static int calculateShortestDistance(int startNode, int endNode, int nofNodes, HashMap<Integer, HashSet<Edge>> adjMatrix) {
        boolean[] visited = new boolean[nofNodes + 1];
        Set<Integer> knownNodes = new HashSet<>();
        int[] distance = createDistanceArray(nofNodes);

        visited[startNode] = true;
        distance[startNode] = 0;
        knownNodes.add(startNode);

        int currentNode = startNode;
        while (true) {
            Set<Edge> edgeSet = adjMatrix.get(currentNode);
            for (Edge e : edgeSet) {
                if (!visited[e.end]
                        && (distance[e.end] > (distance[currentNode] + e.weight))) {
                    distance[e.end] = distance[currentNode] + e.weight;
                    knownNodes.add(e.end);
                }
            }

            int min = Integer.MAX_VALUE;
            int prevCurrentNode = currentNode;
            for (int i : knownNodes) {
                if (!visited[i] && (distance[i] < min)) {
                    min = distance[i];
                    currentNode = i;
                }
            }

            if (currentNode == endNode) {
                return distance[currentNode];
            } else if (prevCurrentNode == currentNode) {
                return -1;
            } else {
                visited[currentNode] = true;
            }
        }
    }

    private static int[] createDistanceArray(int noOfNodes) {
        int[] returnArr = new int[noOfNodes + 1];
        IntStream.rangeClosed(0, noOfNodes)
                .forEach(i -> returnArr[i] = Integer.MAX_VALUE);
        return returnArr;
    }

    private static HashMap<Integer, HashSet<Edge>> prepareAdjMatrix(int noOfNodes) {
        HashMap<Integer, HashSet<Edge>> adjMatrix = new HashMap<>();
        IntStream.rangeClosed(0, noOfNodes)
                .forEach(i -> adjMatrix.put(i, new HashSet<>()));
        return adjMatrix;
    }
}
