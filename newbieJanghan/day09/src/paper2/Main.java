package paper2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// input
		int N = sc.nextInt();
		// if [100,100] is border, [100,101] would be referred.
		// and also if [1, 1] is border, [1,0] would be referred.
		// so make empty index for code simplicity.
		int[][] matrix = new int[102][102];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int r = y; r < y + 10; r++) {
				for (int c = x; c < x + 10; c++) {
					matrix[r][c] = 1;
				}
			}
		}
//		for (int i = 99; i >= 0; i--) {
//			System.out.println(Arrays.toString(matrix[i]));
//		}

		int result = 0;
		for (int r = 1; r <= 100; r++) {
			for (int c = 1; c <= 100; c++) {
				if (matrix[r][c] == 0) {
					continue;
				}
				if (matrix[r + 1][c] == 0) {
					result++;
				}
				if (matrix[r][c + 1] == 0) {
					result++;
				}
				if (matrix[r - 1][c] == 0) {
					result++;
				}
				if (matrix[r][c - 1] == 0) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
