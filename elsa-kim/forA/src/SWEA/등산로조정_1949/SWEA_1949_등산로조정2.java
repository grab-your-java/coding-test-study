package SWEA.등산로조정_1949;

import java.util.Scanner;

public class SWEA_1949_등산로조정2 {
	static int size, K, maxLeng;
	static boolean[][] check;
	static int[] nr = { -1, 1, 0, 0 };
	static int[] nc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			size = sc.nextInt();
			K = sc.nextInt();
			int[][] ori = new int[size][size];
			check = new boolean[size][size];
			int max = 1;
			maxLeng = 1;

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					ori[i][j] = sc.nextInt();
					if (ori[i][j] > max) {
						max = ori[i][j];
					}
				}
			}
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (ori[i][j] == max) {
						check[i][j] = true;
						getWay(i, j, 1, false, ori);
						check[i][j] = false;
					}
				}
			}

			System.out.println("#" + tc + " " + maxLeng);
		}
	}

	private static void getWay(int i, int j, int leng, boolean useK, int[][] arr) {
		if (leng > maxLeng) {
			maxLeng = leng;
		}

		for (int a = 0; a < 4; a++) {
			int r = i + nr[a];
			int c = j + nc[a];
			if (r < 0 || c < 0 || r >= size || c >= size || check[r][c])
				continue;
			if (!useK) {
				int[][] newArr = new int[size][size];
				for (int l = 0; l < size; l++) {
					newArr[l] = arr[l].clone();
				}
				int k = 1;
				if (arr[r][c] >= arr[i][j]) {
					while (k <= K) {
						if (arr[r][c] - k < arr[i][j]) {
							newArr[r][c] -= k;
							check[r][c] = true;
							getWay(r, c, leng + 1, !useK, newArr);
							check[r][c] = false;
							newArr[r][c] += k;
							break;
						} else {
							k++;
						}
					}
				}
			}

			if (arr[r][c] < arr[i][j]) {
				check[r][c] = true;
				getWay(r, c, leng + 1, useK, arr);
				check[r][c] = false;
			}

		}

	}

}
