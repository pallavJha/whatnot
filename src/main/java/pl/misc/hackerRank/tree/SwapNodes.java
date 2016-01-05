package pl.misc.hackerRank.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SwapNodes {

	/*
	 * 
	    3
 	    2  3
	   -1 -1
	   -1 -1
	    2
	    1
	    1
	    
	    5
		2  3
	   -1  4
	   -1  5
	   -1 -1
	   -1 -1
		1
		2
		
			  1 
		   /    \
		  2      3
		 / \    / \
	   -1   4 -1   5
	   
	    11
		2  3
		4 -1
		5 -1
		6 -1
		7  8
	   -1  9
	   -1 -1
	   10 11
	   -1 -1
	   -1 -1
	   -1 -1
		2
		2
		4
	 */
	public static void main(String... strings) {
		// Input Begins.. Scanner opened and will be closed
		// when input is not be available.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[(2 * n) + 1];
		arr[0] = 1;
		for (int i = 1; i <= 2 * n; i++) {
			arr[i] = sc.nextInt();
		}
		int T = sc.nextInt();
		int K[] = new int[T];
		for (int i = 0; i < T; i++) {
			K[i] = sc.nextInt();
		}
		sc.close();

		// 1 2 3 -1 4 -1 5 -1 -1 -1 -1
		// 0 1 2 3 4 5 6 7 8 9 10
		int count = 1;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(1);
		queue.add(root);
		outer: while (count < arr.length) {
			TreeNode temp = queue.poll();
			while (temp == null) {
				temp = queue.poll();
				if(temp != null){
					continue;
				}
				if (queue.isEmpty()) {
					break outer;
				}
			}
			int leftData = arr[count++];
			if (temp != null && leftData != -1) {
				temp.left = new TreeNode(leftData);
				queue.add(temp.left);
			} else {
				queue.add(null);
			}
			int rightData = arr[count++];
			if (temp != null && rightData != -1) {
				temp.right = new TreeNode(rightData);
				queue.add(temp.right);
			} else {
				queue.add(null);
			}
		}

		TreeTraversal.inOrder(root);
		System.out.println();
		//TreeTraversal.preOrder(root);
		//System.out.println();
		//System.out.println(TreeHeight.calculateHeight(root));
		swapNode(root, K);
	}
	
	public static void swapNode(TreeNode root, int[] K) {
		TreeNode temp = root;
		Queue<TreeNode> tempList = null, thisList = new LinkedList<TreeNode>(), nextList = new LinkedList<TreeNode>();
		List<Queue<TreeNode>> queueList = new LinkedList<Queue<TreeNode>>();
		thisList.add(temp);
		queueList.add(new LinkedList<TreeNode>(thisList));
		TreeNode node = null;

		while (!thisList.isEmpty()) {
			node = thisList.poll();
			if (node.left != null) {
				nextList.add(node.left);
			}
			if (node.right != null) {
				nextList.add(node.right);
			}
			if (thisList.isEmpty()) {
				tempList = thisList;
				thisList = nextList;
				nextList = tempList;
				if (!thisList.isEmpty()) {
					queueList.add(new LinkedList<TreeNode>(thisList));
				}
			}
		}
		
		//System.out.println(queueList);
		//System.out.println(queueList.size());
		
		int height = queueList.size();
		
		for (int i = 0; i < K.length; i++) {
			for (int j = 1; j < height; j++) {
				int queueNumber = j * K[i];
				if (queueNumber < height) {
					Queue<TreeNode> currentQueue = queueList.get(queueNumber - 1);
					Queue<TreeNode> tempQueue = new LinkedList<TreeNode>();
					while (!currentQueue.isEmpty()) {
						TreeNode tempNode = currentQueue.poll();
						TreeNode a = tempNode.left;
						tempNode.left = tempNode.right;
						tempNode.right = a;
						tempQueue.add(tempNode);
					}
					currentQueue = tempQueue;
					queueList.set(queueNumber-1, currentQueue);
				}
			}
			inOrder_processed(root);
			System.out.println();
		}
	}
	
	static public void inOrder_processed(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		while(current != null || !stack.isEmpty()){
		  if(current != null){
		    stack.push(current);
		    current = current.left;
		  } else if(!stack.isEmpty()) {
		    current = stack.pop();
		    System.out.print(current.data+" ");
		    current = current.right;
		  }
		}
	}
}