package pl.misc.hackerRank;

import java.util.Scanner;

public class BalancedParentheses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		CharacterStack stack = new CharacterStack();
		boolean[] status = new boolean[n];
		String[] _data = new String[n];
		
		for (int i = 0; i < n; i++) {
			_data[i] = sc.next();
		}
		sc.close();
		
		for (int i = 0; i < n; i++) {
			String data = _data[i];
			inner: for (int j = 0; j < data.length(); j++) {
				char input = data.charAt(j);
				if (input == '[' || input == '{' || input == '(') {
					stack.push(input);
				} else if (input == ']' || input == '}' || input == ')') {
					if (stack.peek() == null) {
						status[i] = true;
						break inner;
					} else {
						char top = stack.peek();
						if ((top == '(' && input == ')')
								|| (top == '{' && input == '}')
								|| (top == '[' && input == ']')) {
							stack.pop();
						} else {
							status[i] = true;
							break inner;
						}
					}
				}
			}
			if(!stack.isEmpty()){
				status[i] = true;
			}
			stack.clear();
		}

		for (int i = 0; i < n; i++) {
			System.out.println(status[i] ? "NO" : "YES");
		}
	}

}

class CharacterStack {
	private class Node {
		Character data;
		Node next;
	}

	Node top;

	public Character peek() {
		return top == null ? null : top.data;
	}
	
	public boolean isEmpty() {
		return top == null ? true : false;
	}

	public void clear() {
		top = null;
	}

	public void push(Character data) {
		Node node = new Node();
		node.data = data;
		node.next = top;
		top = node;
	}

	public int pop() {
		Character data = null;
		if (top != null) {
			data = top.data;
			top = top.next;
		}
		return data;
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
