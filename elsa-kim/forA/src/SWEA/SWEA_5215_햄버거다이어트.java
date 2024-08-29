package SWEA;

import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {
	static int[][] origin;
	static int[] res;
	static int N;
	static int C;
	static boolean[] check;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			C = sc.nextInt();
			origin = new int[N][2];
			max = 0;
			check = new boolean[N];
			for (int i = 0; i < N; i++) {
				origin[i][0] = sc.nextInt();
				origin[i][1] = sc.nextInt();
			}
			for (int i = 1; i <= N; i++) {
				res = new int[i];
				com(0, 0);
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	private static void com(int cnt, int start) {
		if (cnt == res.length) {
			int cSum = 0;
			int tSum = 0;
			for (int i = 0; i < res.length; i++) {
				cSum += origin[res[i]][1];
				tSum += origin[res[i]][0];
			}
			if (cSum <= C && tSum > max)
				max = tSum;
			return;
		}
		for (int i = start; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				res[cnt] = i;
				com(cnt + 1, i + 1);
				check[i] = false;
			}
		}

	}
}
