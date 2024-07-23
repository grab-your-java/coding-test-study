package kill_max_flies;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int result = 0;

			int[][] grid = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// mapping
					grid[r][c] = sc.nextInt();

					// sum M X M
					result = Math.max(result, sumMGrid(grid, M, r, c));
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

	public static int sumMGrid(int[][] grid, int M, int rowEnd, int colEnd) {
		if (M > grid.length)
			return 0;

		int rowStart = rowEnd - M + 1;
		int colStart = colEnd - M + 1;
		if (rowEnd > grid.length - 1 || rowStart < 0 || colEnd > grid.length - 1 || colStart < 0)
			return 0;

		int sum = 0;
		for (int r = rowStart; r <= rowEnd; r++) {
			for (int c = colStart; c <= colEnd; c++) {
				sum += grid[r][c];
			}
		}

		return sum;
	}
}
