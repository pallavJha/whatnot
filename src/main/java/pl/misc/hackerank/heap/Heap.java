package pl.misc.hackerank.heap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Heap {

	public HeapNode root;

	private HeapNode searchNode;
	private boolean search = true;

	public void insert(int data) {
		HeapNode node = new HeapNode(data);
		if (root == null) {
			root = node;
		} else {
			HeapNode temp = root;
			Stack<HeapNode> stack = new Stack<HeapNode>();
			while (temp != null) {
				
				if (temp.left != null) {
					stack.add(temp.left);
				} else {
					temp.left = node;
					node.parent = temp;
					break;
				}
				if (temp.right != null) {
					HeapNode pushLater = stack.pop();
					stack.add(temp.right);
					stack.add(pushLater);
				} else {
					temp.right = node;
					node.parent = temp;
					break;
				}
				temp = stack.pop();
			}

			temp = node;
			refreshHeap(temp);
		}
	}

	private void refreshHeap(HeapNode temp) {
		while (temp.parent != null) {
			if (temp.parent.data > temp.data) {
				int a = temp.parent.data;
				temp.parent.data = temp.data;
				temp.data = a;
				temp = temp.parent;
			} else {
				break;
			}
		}
	}

	public void deleteNode(int data) {
		if (root.data == data && root.left == null && root.right == null) {
			root = null;
			return;
		}
		search(root, data);
		if (searchNode != null) {
			HeapNode lastNode = findLastNode(root);
			if (lastNode.parent.left.data == lastNode.data) {
				lastNode.parent.left = null;
			} else {
				lastNode.parent.right = null;
			}
			searchNode.data = lastNode.data;
			lastNode = null;
			while (true) {
				if (searchNode.left != null && searchNode.right != null) {
					if (searchNode.left.data < searchNode.right.data) {
						if (searchNode.left.data < searchNode.data) {
							int temp = searchNode.data;
							searchNode.data = searchNode.left.data;
							searchNode.left.data = temp;
							searchNode = searchNode.left;
						} else {
							break;
						}
					} else {
						if (searchNode.right.data < searchNode.data) {
							int temp = searchNode.data;
							searchNode.data = searchNode.right.data;
							searchNode.right.data = temp;
							searchNode = searchNode.right;
						} else {
							break;
						}
					}
				} else if (searchNode.left == null && searchNode.right == null) {
					break;
				} else if (searchNode.left == null && searchNode.right != null) {
					if (searchNode.right.data < searchNode.data) {
						int temp = searchNode.data;
						searchNode.data = searchNode.right.data;
						searchNode.right.data = temp;
						searchNode = searchNode.right;
					} else {
						break;
					}
				} else if (searchNode.left != null && searchNode.right == null) {
					if (searchNode.left.data < searchNode.data) {
						int temp = searchNode.data;
						searchNode.data = searchNode.left.data;
						searchNode.left.data = temp;
						searchNode = searchNode.left;
					} else {
						break;
					}
				}
			}
		}
		searchNode = null;
		search = true;
	}

	private void search(HeapNode temp, int data) {
		if (temp.data == data) {
			searchNode = temp;
			search = false;
			return;
		}
		if (search && temp.left != null) {
			search(temp.left, data);
		}
		if (search && temp.right != null) {
			search(temp.right, data);
		}
	}

	private HeapNode findLastNode(HeapNode root) {
		if (root.left == null) {
			return root;
		}
		Queue<HeapNode> q = new LinkedList<HeapNode>();
		HeapNode n = null;
		q.add(root);
		while (!q.isEmpty()) {
			n = q.poll();
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}
		return n;
	}

	public int min() {
		return root.data;
	}
}