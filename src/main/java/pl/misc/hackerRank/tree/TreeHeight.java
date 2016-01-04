package pl.misc.hackerRank.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeHeight {

	public static void main(String[] args) {
			TreeNode root = new TreeNode(3);
			  root.left = new TreeNode(5);
		     root.right = new TreeNode(2);
		 root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		System.out.println(calculateHeight(root));
	}

	public static int calculateHeight(TreeNode root) {
		if (root != null) {
			int height = 0;
			Queue<TreeNode> tempList = null, thisList = new LinkedList<TreeNode>(), nextList = new LinkedList<TreeNode>();
			thisList.add(root);
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
					height++;
					tempList = thisList;
					thisList = nextList;
					nextList = tempList;
				}
			}
			return height;
		}
		else{
			return -1;
		}
	}
}
