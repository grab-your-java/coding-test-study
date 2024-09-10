package swea_2806_NQueen;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[] colMemo; // memo which row is located
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			colMemo = new int[N];
			Arrays.fill(colMemo, -10);
			count = 0;

			locate(0);
			System.out.println("#" + t + " " + count);
		}
	}

	static void locate(int row) {
		if (row == N) { // baseline
			count++;
			return;
		}

		for (int col = 0; col < N; col++) {
			if (colMemo[col] >= 0 || !checkCrossline(row, col)) {
				continue;
			}
			int prevMemo = colMemo[col];
			colMemo[col] = row;
			locate(row + 1);
			colMemo[col] = prevMemo;
		}

	}

	static boolean checkCrossline(int row, int col) {
		for (int newCol = 0; newCol < N; newCol++) {
			if (newCol == col) {
				continue;
			}

			int colDiff = Math.abs(col - newCol);
			if (colMemo[newCol] == row - colDiff) {
				return false;
			}
		}

		return true;
	}
}