package SWEA;

import java.util.Scanner;

public class SWEA_2105_디저트카페_for규 {
	static int N;
	static int[][] map;
	static boolean[] dessert;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			max = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					dessert = new boolean[101];
					dfs(i, j, 0, 1, i, j);
				}
			}

			if (max == 0) {
				System.out.println("#" + tc + " -1");
			} else {
				System.out.println("#" + tc + " " + max);
			}

		}
	}

	static void dfs(int r, int c, int currDir, int dessertCnt, int startR, int startC) {
		if (dessert[map[r][c]])
			return;
		dessert[map[r][c]] = true;
		for (int i = 0; i < 2; i++) {
			int way = (currDir + i) % 4;
			int nr = r + dr[way];
			int nc = c + dc[way];
			if (currDir == 3 && (nr < startR || nc > startC)) {
				break;
			}
			if (nr == startR && nc == startC && dessertCnt >= 4) { // 원점에 돌아왔고, 조건 충족
				max = Math.max(max, dessertCnt);
				continue;
			}

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !dessert[map[nr][nc]]) {
				dfs(nr, nc, way, dessertCnt + 1, startR, startC);
			}
		}
		dessert[map[r][c]] = false;
	}
}
