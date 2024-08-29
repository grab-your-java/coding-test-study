package swea_1949;

import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] mountain;
	static int maxDevelop;
	static int maxLen;
	// up right down left
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean developed;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			mountain = new int[N][N];
			maxDevelop = sc.nextInt();

			int maxHeight = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int height = sc.nextInt();
					if (height > maxHeight) {
						maxHeight = height;
					}
					mountain[r][c] = height;
				}
			}

			maxLen = 1;
			developed = false;
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (mountain[r][c] == maxHeight) {
						visited[r][c] = true;
						dfs(r, c, maxHeight, 1);
						visited[r][c] = false;
					}
				}
			}

			System.out.println("#" + t + " " + maxLen);

		}
	}

	static void dfs(int r, int c, int curHeight, int len) {
		maxLen = Math.max(maxLen, len);

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d], nc = c + dc[d];
			if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
				int nextHeight = mountain[nr][nc];
				if (nextHeight < curHeight) {
					visited[nr][nc] = true;
					dfs(nr, nc, nextHeight, len + 1);
					visited[nr][nc] = false;
				} else if (!developed && nextHeight - maxDevelop < curHeight) {
					int develop = 1;
					while (develop <= maxDevelop && nextHeight - develop >= curHeight) {
						develop++;
					}
					int newHeight = nextHeight - develop;
					developed = true;
					visited[nr][nc] = true;
					dfs(nr, nc, newHeight, len + 1);

					developed = false;
					visited[nr][nc] = false;

				}
			}
		}
	}
}
