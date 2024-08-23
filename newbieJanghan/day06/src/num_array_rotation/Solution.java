package num_array_rotation;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] grid = new int[N][N];
			
			// Mapping
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					grid[r][c] = sc.nextInt();
				}
			}
			
			// Print
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<N; i++) {
				// 90
				for (int r=N-1; r>=0; r--) {
					sb.append(grid[r][i]);
				}
				sb.append(" ");
				// 180
				for (int c=N-1; c>=0; c--) {
					sb.append(grid[N-1-i][c]);
				}
				sb.append(" ");
				// 270
				for (int r=0; r<N; r++) {
					sb.append(grid[r][N-1-i]);
				}
				sb.append("\n");
			}

			System.out.println("#" + t);
			System.out.print(sb);
		}
	}
}
