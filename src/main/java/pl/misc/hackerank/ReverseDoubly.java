package pl.misc.hackerank;

public class ReverseDoubly {

	static class Node {
		int data;
		Node prev;
		Node next;
	}

	static Node add(Node head, int data) {
		Node newNode = new Node();
		newNode.data = data;

		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp;
		}

		return head;
	}

	static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	static Node reverse(Node head) {

		Node temp = head;
		Node temp_prev = null;
		Node temp_next = temp.next;
		while (temp != null) {
			temp.prev = temp_next;
			temp.next = temp_prev;
			temp_prev = temp;
			temp = temp.prev;
			if(temp.next == null){
				temp.next = temp_prev;
				temp.prev = null;
				head = temp;
				break;
			}
			else{
				temp_next = temp.next;
			}
		}
		return head;
	}

	public static void main(String[] strings) {
		Node head = null;
		head = add(head, 1);
		print(head);
		head = add(head, 2);
		print(head);
		head = add(head, 3);
		print(head);
		head = add(head, 4);
		print(head);
		head = add(head, 5);
		print(head);
		head = add(head, 6);
		print(head);
		head = reverse(head);
		print(head);
	}
}
