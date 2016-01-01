//3 5 1 4 2 6
//1 4 5 6 2 3
/*
 *	        3
 *  	  /   \
 * 	     5     2
 *      / \   /
 *     1   4 6
 */
package pl.misc.hackerrank.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

	public static void main(String[] args) {
		  TreeNode root = new TreeNode(3);
			  root.left = new TreeNode(5);
		     root.right = new TreeNode(2);
		 root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		levelOrder(root);
	}
	
	static public void preOrder(TreeNode root) {
		TreeNode temp = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(temp);
		while (!stack.isEmpty()) {
			temp = stack.pop();
			System.out.print(temp.data + " ");
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
	}
	/*
	 *	        3
	 *  	  /   \
	 * 	     5     2
	 *      / \   /
	 *     1   4 6
	 *     
	 *     1 4 5 6 2 3
	 *     1 4 5 1 4 6 2 6 3  
	 */	
	static public void postOrder(TreeNode root) {
		TreeNode temp = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<TreeNode> dataList = new ArrayList<TreeNode>();
		stack.push(temp);
		while (!stack.isEmpty()) {
			temp = stack.peek();
			if (!dataList.contains(temp)) {
				dataList.add(temp);
			}
			else{
				System.out.print(stack.pop().data+" ");
				continue;
			}
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
			if (temp.left == null && temp.right == null) {
				System.out.print(stack.pop().data + " ");
			}
		}
	}
	/*
	 *	        3
	 *  	  /   \
	 * 	     5     2
	 *      / \   /
	 *     1   4 6
	 *     
	 *     1 5 4 3 6 2
	 */	
	static public void inOrder(TreeNode root) {
		TreeNode temp = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(temp != null){
			stack.push(temp);
			temp = temp.left;
		}
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			System.out.print(node.data+" ");
			if(node.right != null){
				node = node.right;
				while(node!=null){
					stack.push(node);
					node = node.left;
				}
			}
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
	
	/*
	 *	        3
	 *  	  /   \
	 * 	     5     2
	 *      / \   /
	 *     1   4 6
	 *     
	 *     3 5 2 1 4 6
	 */	
	static public void levelOrder(TreeNode root){
		TreeNode temp = root;
		Queue<TreeNode> tempQueue, thisQueue = new LinkedList<TreeNode>(), nextQueue = new LinkedList<TreeNode>();
		
		thisQueue.add(temp);
		while(!thisQueue.isEmpty()){
			temp = thisQueue.poll();
			System.out.print(temp.data +" ");
			if(temp.left != null){
				nextQueue.add(temp.left);
			}
			if(temp.right != null){
				nextQueue.add(temp.right);
			}
			if(thisQueue.isEmpty()){
				tempQueue = thisQueue;
				thisQueue = nextQueue;
				nextQueue = tempQueue;
			}
		}
	}
}