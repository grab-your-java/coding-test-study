package BOJ;

import java.util.Scanner;

public class BOJ_17144_미세먼지안녕 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int time = sc.nextInt();
		int[][] arr = new int[H][W];
		int posi = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == -1)
					posi = i - 1;
			}
		}
		for (int t = 0; t < time; t++) {
			int[][] newArr = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (arr[i][j] <= 0)
						continue;
					int cnt = 0;
					if (i + 1 < H && arr[i + 1][j] != -1) {
						newArr[i + 1][j] += arr[i][j] / 5;
						cnt++;
					}
					if (j + 1 < W && arr[i][j + 1] != -1) {
						newArr[i][j + 1] += arr[i][j] / 5;
						cnt++;
					}
					if (i - 1 >= 0 && arr[i - 1][j] != -1) {
						newArr[i - 1][j] += arr[i][j] / 5;
						cnt++;
					}
					if (j - 1 >= 0 && arr[i][j - 1] != -1) {
						newArr[i][j - 1] += arr[i][j] / 5;
						cnt++;
					}
					arr[i][j] -= (arr[i][j] / 5) * cnt;
				}

			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					arr[i][j] += newArr[i][j];
				}
			}

			// 위
			for (int i = posi - 1; i > 0; i--) {
				arr[i][0] = arr[i - 1][0];
			}
			for (int i = 0; i < W - 1; i++) {
				arr[0][i] = arr[0][i + 1];
			}
			for (int i = 0; i < posi; i++) {
				arr[i][W - 1] = arr[i + 1][W - 1];
			}
			for (int i = W - 1; i > 1; i--) {
				arr[posi][i] = arr[posi][i - 1];
			}
			arr[posi][1] = 0;

			// 아래
			for (int i = posi + 2; i < H - 1; i++) {
				arr[i][0] = arr[i + 1][0];
			}
			for (int i = 0; i < W - 1; i++) {
				arr[H - 1][i] = arr[H - 1][i + 1];
			}
			for (int i = H - 1; i >= posi + 2; i--) {
				arr[i][W - 1] = arr[i - 1][W - 1];
			}
			for (int i = W - 1; i > 1; i--) {
				arr[posi + 1][i] = arr[posi + 1][i - 1];
			}
			arr[posi + 1][1] = 0;
		}
		int sum = 2;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sum += arr[i][j];
			}

		}
		System.out.println(sum);

	}

}
