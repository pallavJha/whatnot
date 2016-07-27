package pl.misc.hackerank.graph;

/**
 * @author pallav
 * @version 1.0
 * @since 19/7/16
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
  Input
1
3
32 62
42 68
12 98
7
95 13
97 25
93 37
79 27
75 19
49 47
67 17
 */
@SuppressWarnings("unused")
public class SnakesAndLadders {

    private SnakesAndLadders() {
    }

    /**
     * Main
     *
     * @param args runtime args
     */
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        for (int i = 0; i < noOfTestCases; i++) {
            HashMap<Integer, LinkedList<Integer>> adjList = prepareInput(sc);
            int movesCount = findNoOfMovesToReach100(adjList);
            System.out.println(movesCount);
        }
        sc.close();
    }

    private static HashMap<Integer, LinkedList<Integer>> prepareInput(Scanner sc) {

        HashMap<Integer, LinkedList<Integer>> adjList = prepareAdjList();

        //Collection of Ladders
        int noOfLadders = sc.nextInt();
        modifyAdjList(sc, adjList, noOfLadders);

        //Collection of snakes
        int noOfSnakes = sc.nextInt();
        modifyAdjList(sc, adjList, noOfSnakes);

        return adjList;
    }

    private static void modifyAdjList(Scanner sc, HashMap<Integer, LinkedList<Integer>> adjList, int noOfLaddersOrSnakes) {
        for (int i = 0; i < noOfLaddersOrSnakes; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            IntStream.range(start - 6, start)
                    .filter(point -> point > 0 && point <= 100)
                    .forEach(point -> {
                        LinkedList<Integer> neighbours = adjList.get(point);
                        neighbours.set(Math.abs(start - point - 6), end);
                    });
        }
    }

    private static HashMap<Integer, LinkedList<Integer>> prepareAdjList() {
        HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();
        IntStream.rangeClosed(1, 100)
                .forEach(i -> adjList.put(i, prepareEdgeList(i)));
        return adjList;
    }

    private static LinkedList<Integer> prepareEdgeList(int node) {
        LinkedList<Integer> list = IntStream.rangeClosed(node + 1, node + 6)
                .mapToObj(i -> i <= 100 ? i : 100)
                .collect(Collectors.toCollection(LinkedList::new));

        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    private static int findNoOfMovesToReach100(HashMap<Integer, LinkedList<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size() + 1];
        int[] parent = new int[adjList.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> nextQueue = new LinkedList<>();

        int distance = 0;
        int currentNode = 1;
        visited[currentNode] = true;
        parent[currentNode] = 0;
        while (true) {
            LinkedList<Integer> neighbours = adjList.get(currentNode);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    nextQueue.add(neighbour);
                    parent[neighbour] = currentNode;
                }
            }

            if (queue.isEmpty()) {
                queue = nextQueue;
                nextQueue = new LinkedList<>();
                distance++;
            }
            if (queue.isEmpty()) {
                distance = -1;
                break;
            }
            currentNode = queue.poll();
            if (currentNode == 100){
                return distance;
            }
        }
        return distance;
    }
}