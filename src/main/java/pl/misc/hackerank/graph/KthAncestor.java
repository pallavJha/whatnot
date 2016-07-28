package pl.misc.hackerank.graph;

import java.util.*;

/**
 * @author pallav
 * @version 1.0
 * @since 29/7/16
 */
/*
Sample Input
1
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
    private static LinkedList<Integer> output = new LinkedList<>();

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        for (int i = 0; i < noOfTestCases; i++) {
            prepareInput(sc);
            execute(sc);
        }
        sc.close();

        output.forEach(System.out::println);
    }

    private static void execute(Scanner sc) {
        int noOfQueries = sc.nextInt();
        for (int i = 0; i < noOfQueries; i++) {
            int operation = sc.nextInt();
            switch (operation) {
                case 0:
                    fetchNewInput(sc);
                    break;
                case 1:
                    deleteNode(sc);
                    break;
                case 2:
                    findKthParent(sc);
                    break;
            }
        }
    }

    private static void fetchNewInput(Scanner sc) {
        int newNodeData = sc.nextInt();
        int parentData = sc.nextInt();
        Node node = new Node(newNodeData);
        nodeParentMap.put(newNodeData, parentData);
        dataNodeMap.put(newNodeData, node);
        dataNodeMap.get(parentData).children.add(node);
    }

    private static void deleteNode(Scanner sc) {
        int delNodeData = sc.nextInt();

        int parentData = nodeParentMap.get(delNodeData);
        nodeParentMap.remove(delNodeData);

        Node nodeToDelete = dataNodeMap.get(delNodeData);
        dataNodeMap.remove(delNodeData);
        dataNodeMap.get(parentData).children.remove(nodeToDelete);
    }

    private static void findKthParent(Scanner sc) {
        int nodeData = sc.nextInt();
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            Integer parentData = nodeParentMap.get(nodeData);
            if (parentData != null) {
                nodeData = parentData;
            }
            else {
                nodeData = 0;
                break;
            }
        }
        output.add(nodeData);
    }

    private static Node prepareInput(Scanner sc) {
        Node root = null;
        int noOfNodes = sc.nextInt();
        for (int i = 0; i < noOfNodes; i++) {
            int newNodeData = sc.nextInt();
            int parentData = sc.nextInt();
            Node node = new Node(newNodeData);
            if (parentData == 0) {
                root = node;
                dataNodeMap.put(newNodeData, node);
            } else {
                nodeParentMap.put(newNodeData, parentData);
                dataNodeMap.put(newNodeData, node);
                Node parentNode = dataNodeMap.get(parentData);
                node.parent = parentNode;
                parentNode.children.add(node);
            }
        }
        return root;
    }


}
