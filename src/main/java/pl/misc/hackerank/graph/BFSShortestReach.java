package pl.misc.hackerank.graph;

/**
 * @author pallav
 * @version 1.0
 * @since 17/7/16
 */
// BFS

import java.util.*;

/**
 * Sample Input
 * 2
 * 4 2
 * 1 2
 * 1 3
 * 1
 * 3 1
 * 2 3
 * 2
 * Sample Output
 * 6 6 -1
 * -1 6
 */
@SuppressWarnings("unused")
public class BFSShortestReach {

    private BFSShortestReach() {
    }

    private static Scanner sc;
    private static List<List<Integer>> outputList = new LinkedList<>();

    static {
        sc = new Scanner(System.in);
    }

    /**
     * Main
     *
     * @param args run time args
     */
    public static void main(String... args) {
        int noOfTestsCases = sc.nextInt();
        for (int i = 0; i < noOfTestsCases; i++) {
            outputList.add(calculateDistance());
        }
        printOutPut();
    }

    private static LinkedList<Integer> calculateDistance() {
        int noOfNodes = sc.nextInt();
        int noOfEdges = sc.nextInt();
        boolean[][] adjacencyMatrix = new boolean[noOfNodes + 1][noOfNodes + 1];
        for (int i = 0; i < noOfEdges; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            adjacencyMatrix[row][col] = true;
            adjacencyMatrix[col][row] = true;
        }
        int startNode = sc.nextInt();
        Map<Integer, Integer> distanceMap = bfs(startNode, noOfNodes, adjacencyMatrix);
        LinkedList<Integer> output = new LinkedList<>();
        for (int i = 1; i <= noOfNodes; i++) {
            if (i == startNode) {
                continue;
            }
            output.add(distanceMap.get(i) == null ? -1 : 6 * distanceMap.get(i));
        }
        return output;
    }

    private static Map<Integer, Integer> bfs(int startNode, int noOfNodes, boolean[][] adjMatrix) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> nextQueue = new LinkedList<>();
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        Map<Integer, Integer> distanceMap = new HashMap<>();
        int currentMultiple = 1;
        queue.add(startNode);
        Integer currentNode = queue.peek();
        while (!queue.isEmpty()) {
            for (int i = 1; i <= noOfNodes; i++) {
                boolean currentNeighbourVisited = visitedMap.get(i) == null ? false : visitedMap.get(i);
                if ((adjMatrix[currentNode][i]) && !currentNeighbourVisited) {
                    nextQueue.add(i);
                    visitedMap.put(i, true);
                    if (distanceMap.get(i) == null) {
                        distanceMap.put(i, currentMultiple);
                    }
                }
            }
            visitedMap.put(queue.poll(), true);
            currentNode = queue.peek();
            if (currentNode == null) {
                queue = nextQueue;
                currentNode = queue.peek();
                nextQueue = new LinkedList<>();
                currentMultiple++;
            }
        }
        return distanceMap;
    }

    private static void printOutPut() {
        for (List<Integer> list : outputList) {
            for (Integer a : list) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
