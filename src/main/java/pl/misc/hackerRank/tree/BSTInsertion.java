package pl.misc.hackerRank.tree;

public class BSTInsertion {
    /*
       			4
	          /   \
	         2     7
	        / \   /
	       1   3 6
    */
	public static void main(String[] args) {
		TreeNode root = insert(null, 4);
		root = insert(root, 2);
		root = insert(root, 7);
		root = insert(root, 1);
		root = insert(root, 3);
		root = insert(root, 6);
		TreeTraversal.inOrder(root);
	}

	public static TreeNode insert(TreeNode root, int value) {
		TreeNode node = new TreeNode(value);
		if (root == null) {
			root = node;
		} else {
			TreeNode temp = root;
			while (true) {
				if (temp.data > node.data) {
					if (temp.left == null) {
						temp.left = node;
						break;
					} else {
						temp = temp.left;
					}
				} else {
					if (temp.right == null) {
						temp.right = node;
						break;
					} else {
						temp = temp.right;
					}
				}
			}
		}
		return root;
	}

}