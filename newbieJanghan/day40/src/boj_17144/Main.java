package boj_17144;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C;
	static int A, B; // row index of air cleaner
	static Queue<Dust>[][] room;
	static int[][] diffused;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Dust {
		int r, c, amount;

		Dust(int r, int c, int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}

		void diffuse() {
			int diffusion = this.amount / 5;
			if (diffusion == 0) {
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0 <= nr && nr < R && 0 <= nc && nc < C) {
					if (nc == 0 && (nr == A || nr == B)) {
						continue;
					}
					diffused[nr][nc] += diffusion;
					this.amount -= diffusion;
				}
			}
		}

		void winded() {
			int nc = c, nr = r;

			if (0 < c && c <= C - 1 && (r == 0 || r == R - 1)) {
				nc--;
			}

			else if (0 < c && c < C - 1 && (r == A || r == B)) {
				nc++;
			}

			else if (c == 0) {
				if (0 <= r && r < A) {
					nr++;
				} else if (B < r && r <= R - 1) {
					nr--;
				}
			}

			else if (c == C - 1) {
				if (0 < r && r <= A) {
					nr--;
				} else if (B <= r && r < R - 1) {
					nr++;
				}
			}

			if (nc == 0 && (nr == A || nr == B)) {
				this.amount = 0;
				return;
			}
			
			this.r = nr;
			this.c = nc;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		int T = sc.nextInt();

		room = new LinkedList[R][C];
		diffused = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				room[r][c] = new LinkedList<Dust>();
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				int dustAmount = sc.nextInt();
				if (dustAmount == -1) {
					if (A == 0) {
						A = r;
					} else {
						B = r;
					}
				}

				else if (dustAmount > 0) {
					room[r][c].add(new Dust(r, c, dustAmount));
				}

			}
		}

		while (T-- > 0) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (room[r][c].size() > 0) {
						while (room[r][c].peek() == null) {
							room[r][c].poll();
						}
						room[r][c].peek().diffuse();
					}
				}
			}

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (diffused[r][c] > 0) {
						if (room[r][c].size() == 0) {
							room[r][c].add(new Dust(r, c, diffused[r][c]));
						} else {
							room[r][c].peek().amount += diffused[r][c];
						}
						diffused[r][c] = 0;
					}
				}
			}

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (room[r][c].size() > 0) {
						Dust dust = room[r][c].poll();
						if (dust == null) {
							continue;
						}
						dust.winded();
						if (dust.amount > 0) {
							room[dust.r][dust.c].add(null);
							room[dust.r][dust.c].add(dust);
						}
					}
				}
			}

		}

		int sum = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (room[r][c].size() > 0) {
					while(room[r][c].peek() == null) {
						room[r][c].poll();
					}
					sum += room[r][c].peek().amount;
				}
			}
		}

		System.out.println(sum);
	}
}
