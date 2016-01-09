package pl.misc.hackerRank.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QHeap {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Heap heap = new Heap();
		List<Integer> outputList = new ArrayList<Integer>();
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			int data = 0;
			if (input == 1) {
				data = sc.nextInt();
				heap.insert(data);
			} else if (input == 2) {
				data = sc.nextInt();
				heap.deleteNode(data);
			} else {
				outputList.add(heap.min());
			}
		}
		sc.close();
		for(int i = 0 ;i<outputList.size();i++){
			System.out.println(outputList.get(i));
		}
	}
}