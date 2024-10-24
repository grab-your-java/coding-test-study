package SWEA_5650;

import java.util.Scanner;

public class Solution {
	static interface Area {
	}

	static Area[][] map;

	// up right down left
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int N;

	static class Ball {
		int startR, startC, r, c, direction, score;

		Ball(int r, int c, int direction) {
			this.startR = r;
			this.startC = c;
			this.r = r;
			this.c = c;
			this.direction = direction;
			this.score = 0;
		}

		boolean move() {
			int nr = this.r + dr[direction], nc = this.c + dc[direction];

			if (nr < 0) {
				score++;
				direction = 2;
				this.r = nr;
				this.c = nc;
			} else if (nr >= N) {
				score++;
				direction = 0;
				this.r = nr;
				this.c = nc;
			} else if (nc < 0) {
				score++;
				direction = 1;
				this.r = nr;
				this.c = nc;
			} else if (nc >= N) {
				score++;
				direction = 3;
				this.r = nr;
				this.c = nc;
			} else if (nr == startR && nc == startC) {
				return false;
			}

			else if (map[nr][nc] == null) {
				this.r = nr;
				this.c = nc;
			} else if (map[nr][nc] instanceof Block) {
				score++;
				this.direction = ((Block) map[nr][nc]).hit(this.direction);
				this.r = nr;
				this.c = nc;
			} else if (map[nr][nc] instanceof Wormhole) {
				this.r = ((Wormhole) map[nr][nc]).pair.r;
				this.c = ((Wormhole) map[nr][nc]).pair.c;
			} else if (map[nr][nc] instanceof Blackhole) {
				return false;
			}

			return true;
		}
	}

	static class Block implements Area {
		int type;

		Block(int type) {
			this.type = type;
		}

		int hit(int fromDir) {
			switch (fromDir) {
			case 0: // up
				if (this.type == 2) {
					return 1; // right
				} else if (this.type == 3) {
					return 3; // left
				} else {
					return 2; // down
				}
			case 1: // right
				if (this.type == 3) {
					return 2; // down
				} else if (this.type == 4) {
					return 0; // up
				} else {
					return 3; // left
				}
			case 2: // down
				if (this.type == 1) {
					return 1; // right
				} else if (this.type == 4) {
					return 3; // left
				} else {
					return 0; // up
				}
			default: // left
				if (this.type == 2) {
					return 2; // down
				} else if (this.type == 1) {
					return 0; // up
				} else {
					return 1; // right
				}
			}

		}
	}

	static class Wormhole implements Area {
		Wormhole pair;
		int r, c;

		Wormhole(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Blackhole implements Area {

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = sc.nextInt();
			map = new Area[N][N];
			Wormhole[] wormholes = new Wormhole[5];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int num = sc.nextInt();
					if (num == 0) {
						continue;
					} else if (num < 0) {
						map[r][c] = new Blackhole();
					} else if (1 <= num && num <= 5) {
						map[r][c] = new Block(num);
					} else {
						Wormhole wormhole = new Wormhole(r, c);
						if (wormholes[num - 6] != null) {
							wormholes[num - 6].pair = wormhole;
							wormhole.pair = wormholes[num - 6];
						} else {
							wormholes[num - 6] = wormhole;
						}
						map[r][c] = wormhole;
					}
				}
			}

			int maxScore = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] != null) {
						continue;
					}
					for (int i = 0; i < 4; i++) {
						Ball ball = new Ball(r, c, i);
						while (ball.move()) {
						}

						maxScore = Math.max(maxScore, ball.score);
					}

				}
			}

			sb.append(maxScore).append("\n");
		}

		System.out.println(sb);
	}
}
