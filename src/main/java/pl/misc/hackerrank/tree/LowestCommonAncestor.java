package pl.misc.hackerrank.tree;

public class LowestCommonAncestor {

	public static void main2(String[] args) {
		TreeNode root = new TreeNode(4);
		root	.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		System.out.println(lca(root,1, 3));
	}
	
	
	public static void main(String[] args) {
		//23 16 15 9 6 17 10 13 8 26 18 2 22 24 12 5 20 25 21 4 19 1 3 14 7
		//4 2 3 1 7 6
		//int arr[] = {23,16,15,9,6,17,10,13,8,26,18,2,22,24,12,5,20,25,21,4,19,1,3,14,7};
		int arr[] = {4, 2, 3, 1, 7, 6};
		TreeNode root = new TreeNode(4);
		for(int i=1;i<arr.length;i++){
			root = BSTInsertion.insert(root, arr[i]); 
		}
		System.out.println(lca(root,1, 7));
	}
	/*
		  	  4
		    /   \
		   2     7
		  / \   /
		 1   3 6
		 
		 124
		 74
	 */

	public static TreeNode lca(TreeNode root, int val1, int val2) {
		TreeNode temp = root;
		String path1[] = findPath(temp, val1).split(",");
		temp = root;
		String path2[] = findPath(temp, val2).split(",");
		Integer commonNode = -1;
		outer: for (int i = 0; i < path2.length; i++) {
			for (int j = 0; j < path1.length; j++) {
				if (path2[i].equals(path1[j])) {
					commonNode = new Integer(String.valueOf(path2[i]));
					break outer;
				}
			}
		}
		temp = root;
		return findNode(temp, commonNode);
	}

	public static String findPath(TreeNode root, int val) {
		TreeNode temp = root;
		if (temp != null) {
			if (temp.data == val) {
				return String.valueOf(val);
			} else {
				if (val > temp.data) {
					return findPath(root.right, val) +","+ temp.data;
				} else {
					return findPath(root.left, val) +","+ temp.data;
				}
			}
		} else {
			return null;
		}
	}
	
	public static TreeNode findNode(TreeNode root, int val) {
		TreeNode temp = root;
		if (temp != null) {
			if (temp.data == val) {
				return temp;
			} else {
				if (val > temp.data) {
					return findNode(root.right, val);
				} else {
					return findNode(root.left, val);
				}
			}
		} else {
			return null;
		}
	}
}