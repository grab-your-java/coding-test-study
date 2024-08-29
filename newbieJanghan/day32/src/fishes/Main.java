package fishes;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] accFishes = new int[N + (M - 1) * 2][N + (M - 1) * 2];
		int result = 0;

		for (int r = M - 1; r < N + M - 1; r++) {
			int colAcc = 0;
			for (int c = M - 1; c < N + M - 1; c++) {
				colAcc += sc.nextInt();
				int acc = accFishes[r - 1][c] + colAcc;
				accFishes[r][c] = acc;

				int prevRowAcc = r - M < 0 ? 0 : accFishes[r - M][c];
				int prevColAcc = c - M < 0 ? 0 : accFishes[r][c - M];

				result = Math.max(result, (accFishes[r][c] - (prevColAcc + prevRowAcc)));
			}
		}
		for (int[] row: accFishes) {
			System.out.println(Arrays.toString(row));
		}
		
		System.out.println(result);
	}
}
