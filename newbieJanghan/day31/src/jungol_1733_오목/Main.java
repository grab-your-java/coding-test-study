package jungol_1733_오목;

import java.util.Scanner;

public class Main {
	// right, down direction
	static int[] dr = { -1, 0, 1, 1 };
	static int[] dc = { 1, 1, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[20][20];
		for (int r = 1; r <= 19; r++) {
			for (int c = 1; c <= 19; c++) {
				board[r][c] = sc.nextInt();
			}
		}

		for (int r = 1; r <= 19; r++) {
			for (int c = 1; c <= 19; c++) {
				int stone = board[r][c];
				if (stone == 0) {
					continue;
				}

				for (int d = 0; d < 4; d++) {
					int count = 1;
					int nr = r + dr[d];
					int nc = c + dc[d];
					while (nr >= 1 && nr <= 19 && nc >= 1 && nc <= 19 && board[nr][nc] == stone) {
						count++;
						nr += dr[d];
						nc += dc[d];
					}
					
					// check opposite direction
					int oppositeCount = 0;
					nr = r - dr[d];
					nc = c - dc[d];
					while (nr >= 1 && nr <= 19 && nc >= 1 && nc <= 19 && board[nr][nc] == stone) {
						oppositeCount++;
						nr -= dr[d];
						nc -= dc[d];
					}

					if (count == 5 && oppositeCount == 0) {
						System.out.println(stone);
						System.out.println(r + " " + c);
						return;
					}
				}
			}
		}

		System.out.println(0);
	}
}
