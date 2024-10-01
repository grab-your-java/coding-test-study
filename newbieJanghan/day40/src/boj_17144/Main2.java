package boj_17144;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt(), C = sc.nextInt(), T = sc.nextInt();
		int A = -1, B = -1;

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int[][] room = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				int amount = sc.nextInt();
				if (amount > 0) {
					room[r][c] = amount;
				} else if (amount == -1) {
					if (A == -1) {
						A = r;
					} else {
						B = r;
					}
				}
			}
		}

		int[][] diffused = new int[R][C];

		while (T-- > 0) {
			// diffuse
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (room[r][c] > 0) {
						int diffusion = room[r][c] / 5;
						if (diffusion == 0) {
							continue;
						}

						for (int i = 0; i < 4; i++) {
							int nr = r + dr[i];
							int nc = c + dc[i];

							if (0 <= nr && nr < R && 0 <= nc && nc < C) {
								if (nc==0 && (nr == A || nr == B)) {
									continue;
								}
								diffused[nr][nc] += diffusion;
								room[r][c] -= diffusion;
							}
						}
					}
				}
			}

			// collect
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (diffused[r][c] > 0) {
						room[r][c] += diffused[r][c];
						diffused[r][c] = 0;
					}
				}
			}

			// move 1. column = 0
			for (int r = A - 2; r >= 0; r--) {
				room[r + 1][0] = room[r][0];
			}

			for (int r = B + 2; r < R; r++) {
				room[r - 1][0] = room[r][0];
			}

			// move 2. row = 0 || R -1
			for (int c = 0; c < C - 1; c++) {
				room[0][c] = room[0][c + 1];
				room[R - 1][c] = room[R - 1][c + 1];
			}

			// move 3. column = C -1
			for (int r = 0; r < A; r++) {
				room[r][C - 1] = room[r + 1][C - 1];
			}

			for (int r = R - 1; r > B; r--) {
				room[r][C - 1] = room[r - 1][C - 1];
			}

			// move 4. row = A || B
			for (int c = C - 1; c > 0; c--) {
				room[A][c] = room[A][c - 1];
				room[B][c] = room[B][c - 1];
			}

		}

		int sum = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sum += room[r][c];
			}
		}

		System.out.println(sum);

	}
}
