package SWEA.등산로조정_1949;

import java.util.Scanner;

public class SWEA_1949_등산로조정 {
	static int size, K, maxLeng;
	static boolean[][] check;

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
		if (!useK) {
			int k = 1;
			int[][] newArr = new int[size][size];
			for (int l = 0; l < size; l++) {
				newArr[l] = arr[l].clone();
			}
			while (k <= K) {
				if (i + 1 < size && !check[i + 1][j] && arr[i + 1][j] - k < arr[i][j]) {
					newArr[i + 1][j] -= k;
					check[i + 1][j] = true;
					getWay(i + 1, j, leng + 1, !useK, newArr);
					check[i + 1][j] = false;
					newArr[i + 1][j] += k;
				}
				if (j + 1 < size && !check[i][j + 1] && arr[i][j + 1] - k < arr[i][j]) {
					newArr[i][j + 1] -= k;
					check[i][j + 1] = true;
					getWay(i, j + 1, leng + 1, !useK, newArr);
					check[i][j + 1] = false;
					newArr[i][j + 1] += k;
				}
				if (i - 1 >= 0 && !check[i - 1][j] && arr[i - 1][j] - k < arr[i][j]) {
					newArr[i - 1][j] -= k;
					check[i - 1][j] = true;
					getWay(i - 1, j, leng + 1, !useK, newArr);
					check[i - 1][j] = false;
					newArr[i - 1][j] += k;
				}
				if (j - 1 >= 0 && !check[i][j - 1] && arr[i][j - 1] - k < arr[i][j]) {
					newArr[i][j - 1] -= k;
					check[i][j - 1] = true;
					getWay(i, j - 1, leng + 1, !useK, newArr);
					check[i][j - 1] = false;
					newArr[i][j - 1] += k;
				}
				k++;
			}

		}

		if (i + 1 < size && !check[i + 1][j] && arr[i + 1][j] < arr[i][j]) {
			check[i + 1][j] = true;
			getWay(i + 1, j, leng + 1, useK, arr);
			check[i + 1][j] = false;
		}
		if (j + 1 < size && !check[i][j + 1] && arr[i][j + 1] < arr[i][j]) {
			check[i][j + 1] = true;
			getWay(i, j + 1, leng + 1, useK, arr);
			check[i][j + 1] = false;
		}
		if (i - 1 >= 0 && !check[i - 1][j] && arr[i - 1][j] < arr[i][j]) {
			check[i - 1][j] = true;
			getWay(i - 1, j, leng + 1, useK, arr);
			check[i - 1][j] = false;
		}
		if (j - 1 >= 0 && !check[i][j - 1] && arr[i][j - 1] < arr[i][j]) {
			check[i][j - 1] = true;
			getWay(i, j - 1, leng + 1, useK, arr);
			check[i][j - 1] = false;
		}

	}

}
