package boj_1389;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
	static int N;
	static boolean[][] friendships;
	static int[][] distances;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt() + 1;
		friendships = new boolean[N][N];

		int M = sc.nextInt();
		while (M-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			friendships[a][b] = true;
			friendships[b][a] = true;
		}

		distances = new int[N][N];
		calculate();

		int minSum = Integer.MAX_VALUE;
		int minNum = N;
		for (int num = 1; num < N; num++) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += distances[num][i];
			}
			if (sum < minSum) {
				minSum = sum;
				minNum = num;
			}
		}
		
		System.out.println(minNum);
	}

	static void calculate() {
		for (int i = 1; i < N; i++) {
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			q.add(1);

			while (!q.isEmpty()) {
				int from = q.poll();
				int distance = q.poll();
				for (int to = 0; to < N; to++) {
					if (friendships[from][to] && to != i) {
						if (distances[i][to] == 0 || distances[i][to] > distance) {
							distances[i][to] = distance;
							q.add(to);
							q.add(distance + 1);
						}
					}
				}
				distance++;
			}
		}

	}
}
