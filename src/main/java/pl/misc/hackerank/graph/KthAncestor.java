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
class Node {
    public int data;
    public Node next;

    public static Node build(int data) {
        Node node = new Node();
        node.data = data;
        return node;
    }
}

public class KthAncestor {

    private static HashMap<Integer, Integer> nodeParentMap = new HashMap<>();
    private static HashMap<Integer, Node> parentListMap = new HashMap<>();
    private static LinkedList<Integer> output = new LinkedList<>();

    private KthAncestor() {
    }
    /**
     * Main method
     *
     * @param args run time args
     */
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
            if (operation == 0) {
                fetchNewInput(sc);

            } else if (operation == 1) {
                deleteNode(sc);

            } else if (operation == 2) {
                findKthParent(sc);

            }
        }
    }

    private static void fetchNewInput(Scanner sc) {
        int parentData = sc.nextInt();
        int newNodeData = sc.nextInt();
        nodeParentMap.put(newNodeData, parentData);
        Node parent = Node.build(parentData);
        parent.next = parentListMap.get(parentData);
        parentListMap.put(newNodeData, parent);
    }

    private static void deleteNode(Scanner sc) {
        int delNodeData = sc.nextInt();
        nodeParentMap.remove(delNodeData);
        parentListMap.remove(delNodeData);
    }

    private static void findKthParent(Scanner sc) {
        int nodeData = sc.nextInt();
        int K = sc.nextInt();
        Node parent = parentListMap.get(nodeData);
        if (parent == null) {
            nodeData = 0;
        } else {
            for (int i = 0; i < K; i++) {
                if (parent == null) {
                    nodeData = 0;
                    break;
                }
                nodeData = parent.data;
                parent = parent.next;
            }
        }
        output.add(nodeData);
    }

    private static void prepareInput(Scanner sc) {
        int noOfNodes = sc.nextInt();
        Map<Integer, Integer> missedPairs = new HashMap<>();
        for (int i = 0; i < noOfNodes; i++) {
            int newNodeData = sc.nextInt();
            int parentData = sc.nextInt();
            if (parentData != 0) {
                if (nodeParentMap.get(parentData) != null) {
                    nodeParentMap.put(newNodeData, parentData);
                    Node parent = Node.build(parentData);
                    parent.next = parentListMap.get(parentData);
                    parentListMap.put(newNodeData, parent);
                } else {
                    missedPairs.put(newNodeData, parentData);
                }
            } else {
                nodeParentMap.put(newNodeData, parentData);
                parentListMap.put(newNodeData, null);
            }
        }

        while (!missedPairs.isEmpty()) {
            addMissedNodes(missedPairs);
        }
    }

    private static void addMissedNodes(Map<Integer, Integer> missedPairs) {
        for (Map.Entry<Integer, Integer> pair : missedPairs.entrySet()) {
            int newNodeData = pair.getKey();
            int parentData = pair.getValue();
            if (nodeParentMap.get(parentData) != null) {
                nodeParentMap.put(newNodeData, parentData);
                Node parent = Node.build(parentData);
                parent.next = parentListMap.get(parentData);
                parentListMap.put(newNodeData, parent);
                missedPairs.remove(newNodeData);
            }
        }
    }
}
