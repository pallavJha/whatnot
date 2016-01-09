package pl.misc.hackerRank.heap;

public class HeapNode {

	int data;
	HeapNode left;
	HeapNode right;
	HeapNode parent;

	public HeapNode(int data) {
		this.data = data;
	}

	public String toString() {
		return String.valueOf(data);
	}
}