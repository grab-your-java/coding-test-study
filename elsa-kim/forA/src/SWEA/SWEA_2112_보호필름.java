package SWEA;

import java.util.Scanner;

public class SWEA_2112_보호필름 {
	static int H, W, K, cnt;
	static int[][] ori;
	static int[] test;
	static boolean canPass;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			ori = new int[H][W];
			test = new int[H];
			cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					ori[i][j] = sc.nextInt();
				}
			}
			if (!check(ori)) {
				cnt = H;
				change(0, ori, 0);
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

	private static void change(int i, int[][] arr, int changeCnt) {
		if (changeCnt >= cnt || i == H)
			return;

		int[][] newArr = new int[H][W];
		for (int m = 0; m < H; m++) {
			newArr[m] = arr[m].clone();
		}
		for (int n = 0; n < W; n++) {
			newArr[i][n] = 0;
		}
		if (check(newArr)) {
			if (changeCnt + 1 < cnt)
				cnt = changeCnt + 1;
			return;
		} else {
			change(i + 1, newArr, changeCnt + 1);
		}

		for (int n = 0; n < W; n++) {
			newArr[i][n] = 1;
		}
		if (check(newArr)) {
			if (changeCnt + 1 < cnt)
				cnt = changeCnt + 1;
			return;
		} else {
			change(i + 1, newArr, changeCnt + 1);
		}
		change(i + 1, arr, changeCnt);

	}

	private static boolean check(int[][] arr) {
		next: for (int j = 0; j < W; j++) {
			int now = arr[0][j];
			int cnt = 1;
			for (int i = 1; i <= H; i++) {
				if (cnt >= K) {
					continue next;
				}
				if (i < H) {
					if (arr[i][j] == now) {
						cnt++;
					} else {
						now = arr[i][j];
						cnt = 1;
					}

				}
			}
			return false;
		}
		return true;

	}

}
