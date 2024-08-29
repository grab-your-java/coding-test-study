package BOJ;

import java.util.Scanner;

public class BOJ_1012_유기농배추 {
	static int W, H, cnt, ans;
	static int[][] arr;
	static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			W = sc.nextInt();
			H = sc.nextInt();
			cnt = sc.nextInt();
			arr = new int[H][W];
			check = new boolean[H][W];
			ans = 0;
			for (int i = 0; i < cnt; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[b][a] = 1;
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (arr[i][j] == 0 || check[i][j])
						continue;
					find(i, j);
					ans++;
				}

			}
			System.out.println(ans);
		}

	}

	private static void find(int i, int j) {
		if (arr[i][j] == 0)
			return;

		int k = 1;
		while (j + k < W && arr[i][j + k] == 1) {
			if (!check[i][j + k]) {
				check[i][j + k] = true;
				find(i, j + k);
			}
			k++;
		}
		k = 1;
		while (i + k < H && arr[i + k][j] == 1) {
			if (!check[i + k][j]) {
				check[i + k][j] = true;
				find(i + k, j);
			}
			k++;
		}
		k = 1;
		while (i - k >= 0 && arr[i - k][j] == 1) {
			if (!check[i - k][j]) {
				check[i - k][j] = true;
				find(i - k, j);
			}
			k++;
		}
		k = 1;
		while (j - k >= 0 && arr[i][j - k] == 1) {
			if (!check[i][j - k]) {
				check[i][j - k] = true;
				find(i, j - k);
			}
			k++;
		}

	}

}
