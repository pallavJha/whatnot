package pl.misc.hackerank.greedy;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class JimAndTheOrders {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Node> nodeList = new ArrayList<Node>();

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			Node node = new Node((i + 1), (a + b));
			nodeList.add(node);
		}

		Collections.sort(nodeList);
		showResult(nodeList);
	}

	public static void showResult(List<Node> nodeList) {
		for (int i = 0; i < nodeList.size(); i++) {
			System.out.print(nodeList.get(i).order + " ");
		}
	}
}

class Node implements Comparable<Node> {
	public Integer order;
	public Integer number;

	public Node(int a, int b) {
		this.order = a;
		this.number = b;
	}

	public int compareTo(Node arg0) {
		return this.number.compareTo(arg0.number);
	}
}