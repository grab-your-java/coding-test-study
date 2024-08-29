package BOJ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ_2583_영역구하기 {
	static int H, W, cnt, ansCnt;
	static boolean[][] check;
	static List<Integer> ans;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		cnt = sc.nextInt();
		check = new boolean[H][W];
		ans = new ArrayList<>();
		ansCnt = 0;

		for (int i = 0; i < cnt; i++) {
			int b = sc.nextInt();
			int a = sc.nextInt();
			int y = sc.nextInt();
			int x = sc.nextInt();
			for (int n = a; n < x; n++) {
				for (int m = b; m < y; m++) {
					check[n][m] = true;
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (check[i][j])
					continue;
				sum = 1;
				getSize(i, j);
				ans.add(sum);
				ansCnt++;

			}

		}
		System.out.println(ansCnt);
		ans.sort(Comparator.naturalOrder());
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

	private static void getSize(int i, int j) {
		check[i][j] = true;
		int k = 1;
		while (j + k < W && !check[i][j + k]) {
			check[i][j + k] = true;
			sum++;
			getSize(i, j + k);
			k++;
		}
		k = 1;
		while (i + k < H && !check[i + k][j]) {
			check[i + k][j] = true;
			sum++;
			getSize(i + k, j);
			k++;
		}
		k = 1;
		while (j - k >= 0 && !check[i][j - k]) {
			check[i][j - k] = true;
			sum++;
			getSize(i, j - k);
			k++;
		}
		k = 1;
		while (i - k >= 0 && !check[i - k][j]) {
			check[i - k][j] = true;
			sum++;
			getSize(i - k, j);
			k++;
		}

	}
}
