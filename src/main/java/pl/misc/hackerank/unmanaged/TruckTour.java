/*
 *	Sample Input
 *	
 *	3
 *	1 5
 *	10 3
 *	3 4
 *
 *	Sample Output
 *	
 *	1 
 */
package pl.misc.hackerank.unmanaged;

import java.util.Scanner;

public class TruckTour {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		CircularQueue queue = new CircularQueue();

		for (int i = 0; i < n; i++) {
			long arr[] = new long[3];
			arr[0] = new Long(i);
			arr[1] = sc.nextLong();
			arr[2] = sc.nextLong();
			queue.enQueue(arr);
		}
		sc.close();

		// queue.traverse();
		queue.doTheTour();
	}
}

class CircularQueue {

	private class Node {
		long[] arr;
		Node next;

		public Node(long[] arr) {
			this.arr = arr;
			this.next = null;
		}
	}

	Node start, end;

	public void enQueue(long arr[]) {
		Node node = new Node(arr);
		if (start == null && end == null) {
			start = end = node;
		} else {
			end.next = node;
			end = node;
		}
		end.next = start;
	}

	public void traverse() {
		Node temp = start;
		traverseLoop: while (temp != null) {
			System.out.println(temp.arr[0] + " " + temp.arr[1] + " "
					+ temp.arr[2]);
			temp = temp.next;
			if (temp == start) {
				break traverseLoop;
			}
		}
	}

	public void doTheTour() {
		Node point = start;
		Node temp = point;
		long totalPetrol = 0L;
		while (temp != null) {
			totalPetrol += temp.arr[1];
			if (totalPetrol < temp.arr[2]) {
				temp = temp.next;
				point = temp;
				totalPetrol = 0L;
				continue;
			} else {
				totalPetrol -= temp.arr[2];
				temp = temp.next;
			}
			if (temp == point) {
				System.out.println(point.arr[0]);
				break;
			}
		}
	}
}