package pl.misc.sedgewick.chap01;

public class JosephusProblem<T> {

	private class Node {
		T data;
		Node next;
	}

	Node start;
	Node end;

	public void insert(T data) {
		Node node = new Node();
		node.data = data;
		node.next = null;

		if (start == null && start == end) {
			start = end = node;
			node.next = node;
		} else {
			end.next = node;
			end = node;
			node.next = start;
		}
	}

	public void josephus(int round) {
		Node temp = start;
		Node prev = start;
		temp = start.next;
		while (true) {
			if (temp.next == start) {
				prev = temp;
				break;
			}
			temp = temp.next;
		}
		int count = 0;
		temp = start;
		while (temp.next != null) {
			count++;
			if (count == round) {
				System.out.print(temp.data + " ");
				prev.next = temp.next;
				temp = temp.next;
				count = 0;
			} else {
				prev = temp;
				temp = temp.next;
			}
			if (temp.next == temp) {
				System.out.println(temp.data);
				break;
			}
		}
	}

	public void traverse() {
		Node temp = start;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		JosephusProblem<Integer> list = new JosephusProblem<Integer>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.josephus(2);
	}
}