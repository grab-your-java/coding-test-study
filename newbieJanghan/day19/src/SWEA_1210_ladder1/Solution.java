package SWEA_1210_ladder1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int T = sc.nextInt();
			int result = 0;

			int[][] Map = new int[102][102];
			int[] start = { 0, 0 };

			for (int i = 0; i < 102; i++) {
				for (int j = 0; j < 102; j++) {
					if (i == 0 || i == 101 || j == 0 || j == 101) {
						Map[i][j] = -1;
						continue;
					}
					int value = sc.nextInt();
					if (value == 2) {
						start[0] = i;
						start[1] = j;
					}
					Map[i][j] = value;
				}
			}

			boolean goLeft = false;
			boolean goRight = false;

			while (true) {
				if (start[0] <= 1) {
					result = start[1];
					break;
				}
				int leftValue = Map[start[0]][start[1] - 1];
				int rightValue = Map[start[0]][start[1] + 1];

				if (goLeft && leftValue <= 0) {
					start[0] -= 1;
					goLeft = false;
					continue;
				}

				if (goRight && rightValue <= 0) {
					start[0] -= 1;
					goRight = false;
					continue;
				}

				if (!goRight && leftValue == 1) {
					goLeft = true;
					start[1] -= 1;
				} else if (!goLeft && rightValue == 1) {
					goRight = true;
					start[1] += 1;
				} else {
					start[0] -= 1;
				}
			}

			System.out.println("#" + T + " " + (result - 1));
		}
	}
}
