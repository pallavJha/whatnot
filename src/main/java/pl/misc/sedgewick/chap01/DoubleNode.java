package pl.misc.sedgewick.chap01;

public class DoubleNode<T> {

	private class Node {
		T data;
		Node left;
		Node right;
	}

	Node start;
	Node end;

	public void insertBeginning(T data) {
		Node node = new Node();
		node.data = data;
		node.right = null;
		node.left = null;

		if (start == null && start == end) {
			start = node;
			end = node;
		} else {
			start.left = node;
			node.right = start;
			start = node;
		}
		print(toString(true));
		print(toString(false));
	}

	public void insertEnd(T data) {
		Node node = new Node();
		node.data = data;
		node.right = null;
		node.left = null;

		if (start == null && start == end) {
			start = node;
			end = node;
		} else {
			end.right = node;
			node.left = end;
			end = node;
		}
		print(toString(true));
		print(toString(false));
	}

	public T removeBeginning() {

		if (start == null && start == end) {
			return null;
		} else {
			Node node = start;
			start = start.right;
			start.left = null;
			node.right = null;
			return node.data;
		}
	}

	public T removeEnd() {

		if (start == null && start == end) {
			return null;
		} else {
			Node node = end;
			end = end.left;
			end.right = null;
			node.left = null;
			return node.data;
		}
	}

	public void insertAfter(T data1, T data2) {

		Node node = new Node();
		node.data = data2;
		Node temp = start;

		while (temp != null) {
			if (temp.data.equals(data1)) {
				Node temp_right = temp.right;
				node.left = temp;
				node.right = temp_right;
				temp_right.left = node;
				temp.right=node;
				break;
			}
			temp = temp.right;
		}
		
		print(toString(true));
		print(toString(false));
	}

	public void remove(T data) {
		Node temp = start;

		while (temp != null) {
			if (temp.data.equals(data)) {
				Node leftNode = temp.left;
				Node rightNode = temp.right;

				leftNode.right = rightNode;
				rightNode.left = leftNode;

				temp.right = temp.left = null;
				break;
			}
			temp = temp.right;
		}
	}

	public String toString(boolean asc) {
		String s = "";
		if (asc) {
			s += "start -> ";
			Node temp = start;
			while (temp != null) {
				s += temp.data + " ";
				temp = temp.right;
			}
			s+="<- end";
		} else {
			s += "end   -> ";
			Node temp = end;
			while (temp != null) {
				s += temp.data + " ";
				temp = temp.left;
			}
			s+="<-start";
		}
		return s;
	}
	
	public static void main(String...strings) {
		DoubleNode<Integer> dn = new DoubleNode<Integer>();
		dn.insertBeginning(1);
		dn.insertBeginning(2);
		dn.insertBeginning(3);
		dn.insertAfter(3,4);
		
	}
	
	public void print(Object o){
		System.out.println(o);
	}
}
