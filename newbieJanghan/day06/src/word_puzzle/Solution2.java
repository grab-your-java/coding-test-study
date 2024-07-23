package word_puzzle;

import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int result = 0;

			// Mapping
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			// Calculating
			int[] countByCol = new int[N];
			for (int r = 0; r < N; r++) {
				int countInRow = 0;
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 0) {
						if (countInRow == K) {
							result++;
						}
						if (countByCol[c] == K) {
							result++;
						}
						countInRow = 0;
						countByCol[c] = 0;
					} else {
						countInRow++;
						countByCol[c]++;
						

						if (r == N - 1 && countByCol[c] == K) {
							result++;
						}

						if (c == N - 1 && countInRow == K) {
							result++;
						}
					}
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}
}
