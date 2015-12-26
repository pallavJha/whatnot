package pl.misc.hackerRank;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MaximumElement {

	public static void main(String... strings) {

		Stack stack = new Stack();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int input = 0;
		int max = 0;
		boolean inputChanged = false;

		for (int i = 0; i < n; i++) {
			input = sc.nextInt();
			if (input == 1) {
				int data = sc.nextInt();
				stack.push(data);
				inputChanged = true;
			} else if (input == 2) {
				stack.pop();
				inputChanged = true;
			} else if (input == 3) {
				if (inputChanged) {
					max = stack.max();
				}
				System.out.println(max);
				inputChanged = false;
			}
		}
		sc.close();
	}
}

class Stack {
	private class Node {
		Integer data;
		Node next;
	}

	Node top;

	public void push(Integer data) {
		Node node = new Node();
		node.data = data;
		node.next = top;
		top = node;
	}

	public int pop() {
		int data = -1;
		if (top != null) {
			data = top.data;
			top = top.next;
		}
		return data;
	}

	public List<Integer> getElements() {
		List<Integer> elementData = new LinkedList<Integer>();
		Node temp = top;
		while (temp != null) {
			elementData.add(temp.data);
		}
		return elementData;
	}

	public int max() {
		Integer max = null;
		Node temp = top;
		if (top != null) {
			max = top.data;
		}
		while (temp != null) {
			if (temp.data > max) {
				max = temp.data;
			}
			temp = temp.next;
		}
		return max;
	}

	public void print() {
		Node temp = top;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		return;
	}
}