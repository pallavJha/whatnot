package pl.misc.hackerrank.tree;

public class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		left      = null;
		right     = null;
	}
	
	public String toString(){
		return String.valueOf(data);
	}
}