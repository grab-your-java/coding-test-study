package word_puzzle;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int result = 0;

			int[][] map = new int[N][N];
			// mapping
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			for (int r = 0; r < N; r++) {
				int horizontalCount = 0;
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 1) {
						horizontalCount++;
					} else {
						if (horizontalCount == K) {
							result++;
						} 
						horizontalCount = 0;
					}
				}
				
				if (horizontalCount == K) {
					result++;
				}
			}
			
			for (int c = 0; c<N; c++) {
				int verticalCount = 0;
				for (int r=0; r<N; r++) {
					if (map[r][c] == 1) {
						verticalCount++;
					} else {
						if (verticalCount == K) {
							result++;
						} 
						verticalCount = 0;
					}
				}
				
				if (verticalCount == K) {
					result++;
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}
}
