package pl.misc.hackerank.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author pallav
 * @version 1.0
 * @since 29/7/16
 */
/*
Sample Input
2
7
2 0
5 2
3 5
7 5
9 8
8 2
6 8
10
0 5 15
2 15 2
1 3
0 15 20
0 20 13
2 13 4
2 13 3
2 6 10
2 11 1
2 9 1
*/


class Node implements Comparable<Node> {
    /**
     * Value of the node
     */
    public int data = 0;

    /**
     * Children of the node
     */
    public Set<Node> children = new HashSet<>();

    /**
     * Parent of the node
     */
    public Node parent;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.data, o.data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }

        Node node = (Node) o;
        return data == node.data;

    }

    @Override
    public int hashCode() {
        return data;
    }
}

public class KthAncestor {

    private static HashMap<Integer, Integer> nodeParentMap = new HashMap<>();
    private static HashMap<Integer, Node> dataNodeMap = new HashMap<>();

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        for (int i = 0; i < noOfTestCases; i++) {
            Node root = prepareInput(sc);
        }

        sc.close();
    }

    private static Node prepareInput(Scanner sc) {
        Node root = null;
        int noOfNodes = sc.nextInt();
        for (int i = 0; i < noOfNodes; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Node node = new Node(x);
            if (y == 0) {
                root = node;
                dataNodeMap.put(x, node);
            }
            else {
                nodeParentMap.put(x, y);
                dataNodeMap.get(y).children.add(node);
            }
        }
        return root;
    }


}
