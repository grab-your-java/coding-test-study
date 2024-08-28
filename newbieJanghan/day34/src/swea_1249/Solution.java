package swea_1249;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] costs;
	static int[][] minAccCosts;
	// up right down left
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			costs = new int[N][N];
			minAccCosts = new int[N][N];
			for (int r = 0; r < N; r++) {
				char[] chars = sc.next().toCharArray();
				for (int c = 0; c < N; c++) {
					costs[r][c] = chars[c] - '0';
					minAccCosts[r][c] = Integer.MAX_VALUE;
				}
			}
			minAccCosts[0][0] = 0;

			bfs();
			System.out.println("#" + t + " " + minAccCosts[N - 1][N - 1]);

		}
	}

	static void bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> costs[a[0]][a[1]] - costs[b[0]][b[1]]);
		pq.add(new int[] { 0, 0, 0 });

		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			int r = poll[0], c = poll[1];
            int curCost = minAccCosts[r][c];
			if (curCost > minAccCosts[r][c]) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i], nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					continue;
				}

				int accCost = curCost + costs[nr][nc];
				if (accCost < minAccCosts[nr][nc]) {
					minAccCosts[nr][nc] = accCost;
					pq.add(new int[] { nr, nc });
				}
			}
		}
	}
}
