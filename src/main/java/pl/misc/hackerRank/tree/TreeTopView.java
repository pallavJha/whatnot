/*			 3
		   /   \
		  5     2
		 / \   / \
		1   4 6   7
		 \       /
		  9     8
  
  	   1->5->3->2->7
 */

package pl.misc.hackerRank.tree;

import java.util.Stack;

public class TreeTopView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.left.right = new TreeNode(9);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(8);
		top_view(root);
	}

	public static void top_view(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;
		while (temp != null) {
			stack.push(temp);
			temp = temp.left;
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().data+" ");
		}
		temp=root.right;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.right;
		}
	}
}