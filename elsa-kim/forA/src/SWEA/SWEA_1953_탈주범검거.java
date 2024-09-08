package SWEA;

import java.util.Scanner;

public class SWEA_1953_탈주범검거 {
	static int H, W, mH, mW, time;
	static int[][] ori, check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			mH = sc.nextInt();
			mW = sc.nextInt();
			time = sc.nextInt();
			ori = new int[H][W];
			check = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					ori[i][j] = sc.nextInt();
				}
			}
			check[mH][mW] = 1;
			checkWay(mH, mW, 1);
			int ans = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (check[i][j] > 0)
						ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void checkWay(int nowH, int nowW, int nowT) {
		if (nowT == time)
			return;
		if (ori[nowH][nowW] == 1 || ori[nowH][nowW] == 2 || ori[nowH][nowW] == 5 || ori[nowH][nowW] == 6) {
			if (nowH + 1 < H && (ori[nowH + 1][nowW] == 1 || ori[nowH + 1][nowW] == 2 || ori[nowH + 1][nowW] == 4
					|| ori[nowH + 1][nowW] == 7) && (check[nowH + 1][nowW]==0||check[nowH + 1][nowW] > nowT + 1)) {
				check[nowH + 1][nowW] = nowT + 1;
				checkWay(nowH + 1, nowW, nowT + 1);
			}
		}
		if (ori[nowH][nowW] == 1 || ori[nowH][nowW] == 3 || ori[nowH][nowW] == 4 || ori[nowH][nowW] == 5) {
			if (nowW + 1 < W && (ori[nowH][nowW + 1] == 1 || ori[nowH][nowW + 1] == 3 || ori[nowH][nowW + 1] == 6
					|| ori[nowH][nowW + 1] == 7) &&  (check[nowH][nowW+1]==0||check[nowH][nowW+1] > nowT + 1)) {
				check[nowH][nowW + 1] = nowT + 1;
				checkWay(nowH, nowW + 1, nowT + 1);
			}
		}
		if (ori[nowH][nowW] == 1 || ori[nowH][nowW] == 3 || ori[nowH][nowW] == 6 || ori[nowH][nowW] == 7) {
			if (nowW - 1 >= 0 && (ori[nowH][nowW - 1] == 1 || ori[nowH][nowW - 1] == 3 || ori[nowH][nowW - 1] == 4
					|| ori[nowH][nowW - 1] == 5) && (check[nowH][nowW-1]==0||check[nowH][nowW-1] > nowT + 1)) {
				check[nowH][nowW - 1] = nowT + 1;
				checkWay(nowH, nowW - 1, nowT + 1);
			}
		}
		if (ori[nowH][nowW] == 1 || ori[nowH][nowW] == 2 || ori[nowH][nowW] == 4 || ori[nowH][nowW] == 7) {
			if (nowH - 1 >= 0 && (ori[nowH - 1][nowW] == 1 || ori[nowH - 1][nowW] == 2 || ori[nowH - 1][nowW] == 5
					|| ori[nowH - 1][nowW] == 6) && (check[nowH - 1][nowW]==0||check[nowH - 1][nowW] > nowT + 1)) {
				check[nowH - 1][nowW] = nowT + 1;
				checkWay(nowH - 1, nowW, nowT + 1);
			}
		}

	}

}
