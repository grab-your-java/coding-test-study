package swea_1767;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N;
	static boolean[][] cells;
	static boolean[][] paved;
	static List<int[]> cores;
	static int[] lenByCoreCnt;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			cells = new boolean[N][N];
			paved = new boolean[N][N];
			cores = new ArrayList<>();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (sc.nextInt() == 1) {
						cores.add(new int[] { r, c });
						cells[r][c] = true;
						paved[r][c] = true;
					}
				}
			}

			lenByCoreCnt = new int[cores.size() + 1];
			dfs(0, 0, 0);
			for (int i = cores.size(); i > 0; i--) {
				if (lenByCoreCnt[i] > 0) {
					System.out.println("#" + t + " " + lenByCoreCnt[i]);
					break;
				}
			}

		}
	}

	static void dfs(int index, int accLen, int coreCnt) {
		if (index == cores.size()) {
			if (lenByCoreCnt[coreCnt] == 0 || lenByCoreCnt[coreCnt] > accLen) {
				lenByCoreCnt[coreCnt] = accLen;
			}

			return;
		}

		int r = cores.get(index)[0], c = cores.get(index)[1];
		if (r == 0 || r == N - 1 || c == 0 || c == N - 1) {
			dfs(index + 1, accLen, coreCnt + 1);
		}
		//
		else {
			for (int d = 0; d < dr.length; d++) {
				int nr = r + dr[d], nc = c + dc[d];
				int curLen = 0;
				boolean connected = true; // suppose this core is connected
				while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (paved[nr][nc]) {
						curLen = 0;
						connected = false;
						break;
					}

					paved[nr][nc] = true;
					curLen++;
					nr += dr[d];
					nc += dc[d];
				}

				dfs(index + 1, accLen + curLen, coreCnt + (connected ? 1 : 0));

				// roll back
				nr -= dr[d];
				nc -= dc[d];
				while (!(nr == r && nc == c)) {
					paved[nr][nc] = false;
					nr -= dr[d];
					nc -= dc[d];
				}
			}
		}
	}

}
