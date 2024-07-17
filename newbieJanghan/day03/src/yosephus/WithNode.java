package yosephus;

import java.util.Scanner;

public class WithNode {
	public static class Node {
		private int item;
		public Node prev;
		public Node next;
		
		public Node(int item) {
			this.item = item;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Node first = new Node(1);
		Node prev = first;
		int[] result = new int[N];
		
		for (int i=2; i<=N; i++) {
			Node node = new Node(i);
			
			prev.next = node;
			node.prev = prev;
			prev = node;
			
			if (i==N) {
				node.next = first;
				first.prev = node;
			}
		}
		
		Node flag = first;
		int counter = N;
		while (counter > 0) {
			for (int i=0; i<K-1; i++) {
				flag = flag.next;
			}
			
			result[N-counter] = flag.item;
			counter--;
			
			if (counter==0) continue;
			
			flag.prev.next = flag.next;
			flag.next.prev = flag.prev;
			flag = flag.next;
		}
		
		System.out.print("<");
		for (int i=0; i<result.length; i++) {
			System.out.print(result[i]);
			if (i <result.length-1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}
	
	
}
