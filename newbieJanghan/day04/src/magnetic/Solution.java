package magnetic;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int result = 0;
			int N = 100;

			// Mapping
			int[][] grid = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					grid[r][c] = sc.nextInt();
				}
			}

			// N극은 stack에 저장하고
			// S극은 stack이 비어있지 않으면 충돌 후 stack 초기화
			for (int c = 0; c < N; c++) {
				int stacked = 0;
				for (int r = 0; r < N; r++) {
					// N극
					if (grid[r][c] == 1) {
						stacked++;
						continue;
					}
					// S극
					if (grid[r][c] == 2 && stacked > 0) {
						result++;
						stacked = 0;
					}
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}
}
