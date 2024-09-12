package boj_1389;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static boolean[][] friendships;
	static int[][] distances;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt() + 1;
		friendships = new boolean[N][N];
		distances = new int[N][N];
		for (int[] row : distances) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		int M = sc.nextInt();
		while (M-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			friendships[a][b] = true;
			friendships[b][a] = true;

			distances[a][b] = 1;
			distances[b][a] = 1;
		}
		calculate();

		int minSum = Integer.MAX_VALUE;
		int minNum = N;
		for (int num = 1; num < N; num++) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (distances[num][i] == Integer.MAX_VALUE) {
					continue;
				}
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

			System.out.println("junction " + i);
			for (int from = 1; from < N; from++) {
				if (!friendships[i][from]) {
					continue;
				}

				for (int to = from+1; to < N; to++) {
					if (!friendships[i][to]) {
						continue;
					}
					
					int dist = distances[from][i] + distances[i][to];
					if (distances[from][to] > dist) {
						distances[from][to] = dist;
					}
					
					if (distances[to][from] > dist) {
						distances[to][from] = dist;
					}
					
					friendships[from][to] = friendships[to][from] = true;
					
				}
			}
		}

	}
}
