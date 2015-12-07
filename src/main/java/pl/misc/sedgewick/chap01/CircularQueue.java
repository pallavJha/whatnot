package pl.misc.sedgewick.chap01;

import java.util.Random;

public class CircularQueue<T> {

	private class Node {
		T data;
		Node next;
	}

	Node first;
	Node last;

	public void enqueue(T data) {
		Node node = new Node();
		node.data = data;
		if (first == last && first == null) {
			first = last = node;
			node.next = node;
		} else {
			node.next = last.next;
			last.next = node;
			last = node;
		}
		System.out.println(this);
	}

	public T dequeue() {
		T toReturn;
		if (last == last.next) {
			toReturn = last.data;
			first = last = null;
			return toReturn;
		} else if (last == null) {
			return null;
		} else {
			toReturn = last.next.data;
			last.next = last.next.next;
			return toReturn;
		}
	}

	public String toString() {
		String s = "";
		Node temp = last;
		if (temp == null) {
			return "";
		}
		here: while (true) {
			s += temp.next.data + " ";
			temp = temp.next;
			if (temp == last) {
				break here;
			}
		}
		return s;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		Random r = new Random();
		int arr[] = {1,2,3}; 
		for (int i = 0; i < 10; i++) {
			queue.enqueue(r.nextInt());
		}
	}
}