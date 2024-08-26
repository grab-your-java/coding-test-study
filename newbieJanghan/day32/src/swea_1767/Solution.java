package swea_1767;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int minLen;
	static List<int[]> cores;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= sc.nextInt(); t++) {
			N = sc.nextInt();
			map = new int[N][N];
			cores = new ArrayList<>();
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
					if (map[r][c] == 1) {
						visited[r][c] = true;
						cores.add(new int[] { r, c });
					}
				}
			}

			minLen = Integer.MAX_VALUE;
			dfs(0, 0);

			System.out.println("#" + t + " " + minLen);
		}
	}

	static void dfs(int index, int len) {
		if (index == cores.size()) {
			System.out.println(index);
			minLen = Math.min(minLen, len);
			return;
		}

		int[] core = cores.get(index);
		int r = core[0], c = core[1];
		System.out.println("index " + index + "[" + r + "," + c + "]");
		// 가장자리
		if (r == 0 || r == N - 1 || c == 0 || c == N - 1) {
			System.out.println("case 1: no len");
			dfs(index + 1, len);
		}

		// 북, 남, 동, 서 순회
		else {
			int tempR = r, tempC = c, tempLen = 0;
			// 1. 북쪽으로
			while (tempR-- >= 0) {
				if (visited[tempR][c]) {
					break;
				}
				visited[tempR][c] = true;
				tempLen++;
			}
			// 북쪽 진행 성공 시
			if (tempR < 0) {
				System.out.println("index" + index + " north way paved");
				dfs(index + 1, len + tempLen);
			} else {
				while (tempR++ < r) {
					visited[tempR][c] = false;
				}
			}

			// 2. 남쪽으로
			tempLen = 0;
			while (tempR++ < N - 1) {
				if (visited[tempR][c]) {
					break;
				}
				visited[tempR][c] = true;
				tempLen++;
			}
			if (tempR == N) {
				System.out.println("index" + index + " south way paved");
				dfs(index + 1, len + tempLen);
			} else {
				while (tempR-- > r) {
					visited[tempR][c] = false;
				}
			}

			// 3. 동쪽으로
			tempLen = 0;
			while (tempC++ < N - 1) {
				if (visited[r][tempC]) {
					break;
				}
				visited[r][tempC] = true;
				tempLen++;
			}
			if (tempC == N) {
				System.out.println("index" + index + " east way paved");
				dfs(index + 1, len + tempLen);
			} else {
				while (tempC-- > c) {
					visited[r][tempC] = false;
				}
			}

			// 4. 서쪽
			tempLen = 0;
			while (tempC-- >= 0) {
				if (visited[r][tempC]) {
					break;
				}
				visited[r][tempC] = true;
				tempLen++;
			}
			if (tempC < 0) {
				System.out.println("index" + index + " west way paved");
				dfs(index + 1, len + tempLen);
			} else {
				while (tempC++ < c) {
					visited[r][tempC] = false;
				}
			}
		}
	}
}
