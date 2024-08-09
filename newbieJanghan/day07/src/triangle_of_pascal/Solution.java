package triangle_of_pascal;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] grid = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < r + 1; c++) {
					if (c == 0 || c == r) {
						grid[r][c] = 1;
						continue;
					}

					grid[r][c] = grid[r - 1][c - 1] + grid[r - 1][c];
				}
			}
			System.out.println("#" + t);
			for (int[] row : grid) {
				for (int e : row) {
					if (e == 0) {
						continue;
					}
					System.out.print(e + " ");
				}
				System.out.println();
			}
		}

	}

}
