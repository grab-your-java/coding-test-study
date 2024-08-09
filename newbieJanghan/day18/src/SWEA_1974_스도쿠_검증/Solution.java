package SWEA_1974_스도쿠_검증;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int[][] rowCount = new int[9][9];
			int[][] colCount = new int[9][9];
			int[][] gridCount = new int[9][9];

			boolean result = true;

			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					int num = sc.nextInt();
					if (!result) {
						continue;
					}

					// check number already exist in row and column
					if (rowCount[r][num - 1]++ > 0 || colCount[num - 1][c]++ > 0) {
						result = false;
					}

					// check number already exist in 3*3 grid
					int gridIdx = (r / 3) * 3 + c / 3;
					if (gridCount[gridIdx][num - 1]++ > 0) {
						result = false;
					}

				}
			}

			System.out.println("#" + t + " " + (result ? 1 : 0));
		}
	}
}