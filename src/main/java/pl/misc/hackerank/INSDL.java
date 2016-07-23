package pl.misc.hackerank;

public class INSDL {

	static class Node {
		int data;
		Node next;
		Node prev;
	}

	static Node SortedInsert(Node head, int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			boolean flag = true;
			while (true) {
				if (temp.data > newNode.data) {
					break;
				}
				if (temp.next == null) {
					flag = false;
					break;
				}
				temp = temp.next;
			}
			if (flag) {
				if(temp.prev !=null){
					temp.prev.next = newNode;
				}
				newNode.prev = temp.prev;
				newNode.next = temp;
				temp.prev = newNode;
			} else {
				temp.next = newNode;
				newNode.prev = temp;
			}
		}
		while(head.prev != null){
			head = head.prev;
		}
		return head;
	}

	public static void main(String[] args) {

		Node head = SortedInsert(null, 2);
		print(head);
		head = SortedInsert(head, 1);
		print(head);
		head = SortedInsert(head, 4);
		print(head);
		head = SortedInsert(head, 3);
		print(head);
	}

	public static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
}