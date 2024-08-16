package SWEA;

import java.util.Scanner;

public class SWEA_2817_부분수열의합 {
	static int N;
	static int K;
	static int[] origin;
	static int[] arr;
	static boolean[] check;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			origin = new int[N];
			for (int i = 0; i < N; i++) {
				origin[i] = sc.nextInt();
			}
			count = 0;
			check = new boolean[N];
			for (int i = 1; i <= N; i++) {
				arr = new int[i];
				com(0, 0);
			}
			System.out.println("#" + tc + " " + count);
		}
	}

	private static void com(int cnt, int start) {
		if (cnt == arr.length) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += origin[arr[i]];
			}
			if (sum == K)
				count++;
			return;
		}
		for (int i = start; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[cnt] = i;
				com(cnt + 1, i + 1);
				check[i] = false;
			}
		}
	}
}
