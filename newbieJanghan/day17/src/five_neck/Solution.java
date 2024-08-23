package five_neck;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// iteration name for unnecessary search
		Case: for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			char[][] grid = new char[N][N];
			for (int r = 0; r < N; r++) {
				grid[r] = sc.next().toCharArray();
			}

			// clockwise directions
			int[] dr = { 1, 1, 0, -1, -1, -1, 0, 1 };
			int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					char stone = grid[r][c];
					if (stone == '.') {
						continue;
					}

					// search for all directions
					for (int d = 0; d < 8; d++) {
						int count = 1;
						int nr = r + dr[d];
						int nc = c + dc[d];
						while (0 <= nr && nr < N && 0 <= nc && nc < N && grid[nr][nc] != '.') {
							count++;
							// find fine stones
							if (count == 5) {
								System.out.println("#" + t + " YES");
								continue Case; // go next case
							}

							nr += dr[d];
							nc += dc[d];
						}

					}

				}
			}

			System.out.println("#" + t + " NO");

		}
	}

}
