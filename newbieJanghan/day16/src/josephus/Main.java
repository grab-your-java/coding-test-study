package josephus;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		// Circular Link Nodes
		Node first = new Node(1, null, null);
		Node temp = first;
		for (int i = 2; i <= N; i++) {
			Node node = new Node(i, null, null);
			if (i > 1) {
				temp.next = node;
				node.before = temp;
				temp = node;
			}
		}
		temp.next = first;
		first.before = temp;

		String result = "<";

		Node target = first.before;
		while (N-- > 0) {
			// move target
			int count = M;
			while (count-- > 0) {
				target = target.next;
			}

			// for print
			if (N == 0) {
				result += target.value + ">";
			} else {
				result += target.value + ", ";
			}
			
			// remove target
			target.before.next = target.next;
			target.next.before = target.before;
		}
		System.out.println(result);
	}

	static class Node {
		public int value;
		public Node before;
		public Node next;

		Node(int value, Node before, Node next) {
			this.value = value;
			this.before = before;
			this.next = next;
		}
	}

}
