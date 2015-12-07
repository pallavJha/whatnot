package pl.misc.sedgewick.chap01;

public class LinkedList<T> {

	private class Node {
		public T data;
		public Node next;
	}

	Node start;

	Node end;

	public int size;

	public LinkedList() {
		start = null;
		size = -1;
	}

	public void insertNode(Node node) {
		if (start == null) {
			start = node;
			end = node;
			node.next = null;
		} else {
			end.next = node;
			end = node;
		}
		size++;
		System.out.println(this);
	}

	public void insertData(T data) {
		Node node = new Node();
		node.data = data;
		if (start == null) {
			start = node;
			end = node;
			node.next = null;
		} else {
			end.next = node;
			end = node;
		}
		size++;
		System.out.println(toString());
	}

	public void deleteFromBegin() {
		start = start.next;
		size--;
	}

	public void delete(T data) {
		Node node = new Node();
		node.data = data;
		delete(node);
	}

	private void delete(Node node) {
		Node temp = start;
		Node prev = start;
		while (temp != null) {
			if (temp.data.equals(node.data)) {
				if (temp == prev) {
					start = temp.next;
					temp = start;
				} else {
					prev.next = temp.next;
				}
				size--;
			}
			prev = temp;
			temp = temp.next;
		}
	}

	public void delete(int k) {
		Node temp = start;
		Node prev = start;
		int i = 0;
		here: while (temp != null) {
			if (i == k) {
				if (i == 0) {
					start = temp.next;
					break here;
				} else {
					prev.next = temp.next;
					break here;
				}
			}
			prev = temp;
			temp = temp.next;
			i++;
		}
	}

	public boolean find(T item) {
		Node temp = start;
		while (temp != null) {
			if (temp.data.equals(item)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public Integer max() {
		int max = Integer.MIN_VALUE;

		if (start != null && start.data instanceof Integer) {
			Node temp = start;
			while (temp != null) {
				if (Integer.valueOf(temp.data.toString()) > max) {
					max = Integer.valueOf(temp.data.toString());
				}
				temp = temp.next;
			}
			return max;
		}
		return null;
	}

	public String toString() {
		String s = "";
		Node temp = start;
		while (temp != end) {
			s += temp.data.toString();
			s += " , ";
			temp = temp.next;
		}
		s += temp.data.toString();
		return s;
	}

	public void reverse() {
		Node temp = start;
		Node next_temp = null;
		Node c = null;
		end = start;
		next_temp = temp.next;
		while (temp != null) {
			if (temp == start) {
				temp.next = null;
				c = next_temp.next;
				next_temp.next = temp;
				temp = c;
			} else {
				c = temp.next;
				temp.next = next_temp;
				next_temp = temp;
				temp = c;
			}
			start = next_temp;
		}
	}

	public static void main(String... strings) {
		// int arr_temp[] = { 2122659265, 1110460187, 435986887, 130156984,
		// 1999182043, 1687024648, 1610090132, 1152146265, 633325892, 60259666
		// };
		int arr[] = { 1, 2, 3 };
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < 3; i++) {
			int data = arr[i];
			linkedList.insertData(Math.abs(data));
		}
		// linkedList.delete(2122659265);
		// linkedList.delete(0);
		// System.out.println(linkedList.toString());
		// System.out.println(linkedList.find(1999182043));
		// System.out.println(linkedList.max());
		linkedList.reverse();
		System.out.println(linkedList);
	}
}