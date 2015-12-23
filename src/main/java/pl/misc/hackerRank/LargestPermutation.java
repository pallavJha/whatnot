package pl.misc.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class LargestPermutation {

	static class Node implements Comparable<Node> {
		public Integer position;
		public Integer data;

		public int compareTo(Node that) {
			return this.data.compareTo(that.data);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		Node org_arr[] = new Node[n];
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			org_arr[i] = new Node();
			org_arr[i].data = sc.nextInt();
			org_arr[i].position = i;
			arr[i] = org_arr[i].data;
		}
		sc.close();

		if (k > n) {
			k = n;
		}

		Arrays.sort(org_arr);

		for (int i = 0; i < k; i++) {
			Node node = findSmallest(org_arr, n, i);
			arr[node.position] = arr[i];
			arr[i] = node.data;
		}

		printArray(arr);
	}

	public static Node findSmallest(Node[] arr, int size, int index) {
		Node newNode = new Node();
		newNode.data = arr[size - 1 - index].data;
		newNode.position = arr[size - 1 - index].position;
		return newNode;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}