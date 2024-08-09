package depth_of_water_tank;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// input
			int N = sc.nextInt();
			char[][] grid = new char[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					grid[r][c] = sc.next().charAt(0);
				}
			}

			// measure
			Tank tank = new Tank(grid);
			int result = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					result = Math.max(result, tank.depth(r, c));
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

	static class Tank {
		private char[][] grid;
		private int size;
		public Tank(char[][] grid) {
			this.grid = grid;
			this.size = grid.length;
		}

		// clockwise delta search
		static int[] dr = { 1, 1, 0, -1, -1, -1, 0, 1 };
		static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
		
		int depth(int r, int c) {
			if (grid[r][c] == 'G') {
				return 0;
			}
			
			int result = 0;
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (valid(nr, nc) && grid[nr][nc] == 'W') {
					result++;
				}
			}
			return result > 0 ? result : 1;
		}
		
		private boolean valid(int r, int c) {
			return 0 <= r && r < size && 0 <= c && c < size;
		}
	}

}
