package SWEA;

import java.util.Scanner;

public class SWEA_4615_재미있는오셀로게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int size = sc.nextInt();
			int turnCnt = sc.nextInt();
			int[][] arr = new int[size][size];
			arr[size / 2][size / 2] = 2;
			arr[size / 2 - 1][size / 2 - 1] = 2;
			arr[size / 2 - 1][size / 2] = 1;
			arr[size / 2][size / 2 - 1] = 1;
			for (int i = 0; i < turnCnt; i++) {

				int a = sc.nextInt();
				a--;
				int b = sc.nextInt();
				b--;
				int target = sc.nextInt();
				arr[a][b] = target;
				int other = target == 1 ? 2 : 1;
				if (a - 2 >= 0 && arr[a - 1][b] == other) {
					int k = 2;
					while (a - k >= 0 && arr[a - k][b] == other) {
						k++;
					}
					if (a - k >= 0 && arr[a - k][b] == target) {
						for (int j = 1; j < k; j++) {
							arr[a - j][b] = target;
						}
					}
				}
				if (a + 2 < size && arr[a + 1][b] == other) {
					int k = 2;
					while (a + k < size && arr[a + k][b] == other) {
						k++;
					}
					if (a + k < size && arr[a + k][b] == target) {
						for (int j = 1; j < k; j++) {
							arr[a + j][b] = target;
						}
					}
				}
				if (b + 2 < size && arr[a][b + 1] == other) {
					int k = 2;
					while (b + k < size && arr[a][b + k] == other) {
						k++;
					}
					if (b + k < size && arr[a][b + k] == target) {
						for (int j = 1; j < k; j++) {
							arr[a][b + j] = target;
						}
					}
				}
				if (b - 2 >= 0 && arr[a][b - 1] == other) {
					int k = 2;
					while (b - k >= 0 && arr[a][b - k] == other) {
						k++;
					}
					if (b - k >= 0 && arr[a][b - k] == target) {
						for (int j = 1; j < k; j++) {
							arr[a][b - j] = target;
						}
					}
				}
				if (a - 2 >= 0 && b - 2 >= 0 && arr[a - 1][b - 1] == other) {
					int k = 2;
					while (a - k >= 0 && b - k >= 0 && arr[a - k][b - k] == other) {
						k++;
					}
					if (a - k >= 0 && b - k >= 0 && arr[a - k][b - k] == target) {
						for (int j = 1; j < k; j++) {
							arr[a - j][b - j] = target;
						}
					}
				}
				if (a - 2 >= 0 && b + 2 < size && arr[a - 1][b + 1] == other) {
					int k = 2;
					while (a - k >= 0 && b + k < size && arr[a - k][b + k] == other) {
						k++;
					}
					if (a - k >= 0 && b + k < size && arr[a - k][b + k] == target) {
						for (int j = 1; j < k; j++) {
							arr[a - j][b + j] = target;
						}
					}
				}
				if (a + 2 < size && b + 2 < size && arr[a + 1][b + 1] == other) {
					int k = 2;
					while (a + k < size && b + k < size && arr[a + k][b + k] == other) {
						k++;
					}
					if (a + k < size && b + k < size && arr[a + k][b + k] == target) {
						for (int j = 1; j < k; j++) {
							arr[a + j][b + j] = target;
						}
					}
				}
				if (a + 2 < size && b - 2 >= 0 && arr[a + 1][b - 1] == other) {
					int k = 2;
					while (a + k < size && b - k >= 0 && arr[a + k][b - k] == other) {
						k++;
					}
					if (a + k < size && b - k >= 0 && arr[a + k][b - k] == target) {
						for (int j = 1; j < k; j++) {
							arr[a + j][b - j] = target;
						}
					}
				}
			}
			int aCnt = 0;
			int bCnt = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (arr[i][j] == 1)
						aCnt++;
					if (arr[i][j] == 2)
						bCnt++;
				}

			}
			System.out.println("#" + tc + " " + aCnt + " " + bCnt);
		}
	}

}
