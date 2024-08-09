package SWEA_1249_보급로;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = sc.nextInt();
		
		int[][] nums = new int[N][N];
		
		for (int i=0; i<N; i++) {
			char[] numChars = sc.next().toCharArray();
		}

	}

	static class Node {
		int value;
		Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
}
