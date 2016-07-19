package pl.misc.hackerRank;

/**
 * @author pallav
 * @version 1.0
 * @since 19/7/16
 */

import java.util.*;

/**
 * Input
 * 1
 * 3
 * 32 62
 * 42 68
 * 12 98
 * 7
 * 95 13
 * 97 25
 * 93 37
 * 79 27
 * 75 19
 * 49 47
 * 67 17
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
            calculateShortestPath(sc);
        }
        sc.close();
    }

    private static void calculateShortestPath(Scanner sc) {
        //Collection of Ladders
        int noOfLadders = sc.nextInt();
        List<Edge> ladders = new LinkedList<>();
        for (int i = 0; i < noOfLadders; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            ladders.add(new Edge(start, end, Math.abs(end - start)));
        }
        Collections.sort(ladders);

        //Collection of snakes
        int noOfSnakes = sc.nextInt();
        List<Edge> snakes = new LinkedList<>();
        Set<Integer> snakeBitePoints = new HashSet<>();
        for (int i = 0; i < noOfSnakes; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            snakes.add(new Edge(start, end, Math.abs(end - start)));
            snakeBitePoints.add(start);
        }
    }

    private static void calculateShortestPath(List<Edge> ladders, Set<Integer> snakeBitePoints, List<Edge> snakes){
        int currentPosition = 1;

    }

    private static void getNextStep(List<Edge> ladders, Set<Integer> snakeBitePoints, int currentPosition){

    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int length;

    public Edge(int start, int end, int length){
        this.start = start;
        this.end = end;
        this.length = length;
    }

    @Override
    public int compareTo(Edge o) {
        return -(Integer.compare(this.length, o.length));
    }
}