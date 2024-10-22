package SWEA;

import java.util.Scanner;

public class SWEA_2105_디저트카페 {
	static int max, size;
	static int[][] arr;
	static boolean[] check;
	static int[] nr = { 1, 1, -1, -1 };
	static int[] nc = { -1, 1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			size = sc.nextInt();
			max = 0;
			arr = new int[size][size];
			check = new boolean[101];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < size - 2; i++) {
				for (int j = 1; j < size - 1; j++) {
					check[arr[i + 1][j - 1]] = true;
					choose(i + 1, j - 1, i, j, 1, 0);
					check[arr[i + 1][j - 1]] = false;
				}
			}
			System.out.println("#" + tc + " " + (max == 0 ? -1 : max));
		}
	}

	private static void choose(int i, int j, int startI, int startJ, int cnt, int way) {
		if (i < startI) {
			return;
		}

		if (way == 3 && i == startI && j == startJ) {
			if (cnt > max)
				max = cnt;
			return;
		}

		int r = i + nr[way];
		int c = j + nc[way];
		if (r >= 0 && c >= 0 && r < size && c < size && !check[arr[r][c]]) {
			check[arr[r][c]] = true;
			choose(r, c, startI, startJ, cnt + 1, way);
			check[arr[r][c]] = false;
		}

		if (way < 3) {
			r = i + nr[way + 1];
			c = j + nc[way + 1];
			if (r >= 0 && c >= 0 && r < size && c < size && !check[arr[r][c]]) {
				check[arr[r][c]] = true;
				choose(r, c, startI, startJ, cnt + 1, way + 1);
				check[arr[r][c]] = false;
			}
		}

	}

}
