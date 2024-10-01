package swea_4014_활주로건설;

import java.util.Scanner;

public class Solution {
	static int N, X;
	static int[][] map;
	static boolean[][] paved;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			X = sc.nextInt();
			int count = 0;

			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			paved = new boolean[N][N];
			row: for (int r = 0; r < N; r++) {
				int[] row = map[r];
				for (int c = 0; c <= N; c++) {
					if (c == N) {
						count++;
						continue;
					}
					// check left
					if (c - 1 >= 0) {
						if (row[c] - row[c - 1] == 1) { // can build descending slope
							if (!checkAvailable(r, c, 0, -1, row[c - 1])) {
								continue row;
							} else {
								pave(r, c, 0, -1);
							}
						}

						else if (Math.abs(row[c] - row[c - 1]) > 1) {
							continue row;
						}

					}
					// check right
					if (c + 1 < N) {
						if (row[c] - row[c + 1] == 1) {
							if (!checkAvailable(r, c, 0, 1, row[c + 1])) {
								continue row;
							} else {
								pave(r, c, 0, 1);
							}
						}

						else if (Math.abs(row[c] - row[c + 1]) > 1) {
							continue row;
						}

					}
				}
			}

			paved = new boolean[N][N];
			col: for (int c = 0; c < N; c++) {
				for (int r = 0; r <= N; r++) {
					if (r == N) {
						count++;
						continue;
					}
					// check up
					if (r - 1 >= 0) {
						if (map[r][c] - map[r - 1][c] == 1) {
							if (!checkAvailable(r, c, -1, 0, map[r - 1][c])) {
								continue col;
							} else {
								pave(r, c, -1, 0);
							}
						}

						else if (Math.abs(map[r][c] - map[r - 1][c]) > 1) {
							continue col;
						}
					}
					// check down
					if (r + 1 < N) {
						if (map[r][c] - map[r + 1][c] == 1) {
							if (!checkAvailable(r, c, 1, 0, map[r + 1][c])) {
								continue col;
							} else {
								pave(r, c, 1, 0);
							}
						}
						//
						else if (Math.abs(map[r][c] - map[r + 1][c]) > 1) {
							continue col;
						}
					}
				}
			}

			System.out.println("#" + t + " " + count);
		}

	}

	static boolean checkAvailable(int r, int c, int dr, int dc, int heightRequirement) {
		int slopeSize = X;
		int nr = r + dr;
		int nc = c + dc;
		
		while (slopeSize > 0 && 0 <= nr && nr < N && 0 <= nc && nc < N) {	
			if (map[nr][nc] != heightRequirement || paved[nr][nc]) {
				return false;
			}

			slopeSize--;
			nr += dr;
			nc += dc;
		}

		return slopeSize == 0;
	}

	static void pave(int r, int c, int dr, int dc) {
		int slopeSize = X;
		int nr = r + dr;
		int nc = c + dc;

		while (slopeSize > 0 && 0 <= nr && nr < N && 0 <= nc && nc < N) {
			paved[nr][nc] = true;

			slopeSize--;
			nr += dr;
			nc += dc;
		}

	}
}
