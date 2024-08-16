package SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_2806_N_Queen {
	static int N;
	static int[] arr;
	static boolean[] check;
	static List<int[]> list;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			check = new boolean[N];
			list = new ArrayList<>();
			ans = 0;
			per(0);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					checkList(list.get(i), list.get(j));
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void per(int cnt) {
		if (cnt == N) {
			list.add(arr);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[cnt] = i;
				per(cnt + 1);
				check[i] = false;
			}
		}

	}

	private static void checkList(int[] a, int[] b) {
		boolean[] checkSum = new boolean[2 * N - 1];
		boolean[] checkDif = new boolean[2 * N + 1];
		for (int i = 0; i < list.size(); i++) {
			if (checkSum[a[i] + b[i]]) {
				return;
			}
			if (checkDif[b[i] - a[i] + N - 1]) {
				return;
			}
			checkDif[b[i] - a[i] + N - 1] = true;
			checkSum[a[i] + b[i]] = true;
		}

		ans++;
	}

}
