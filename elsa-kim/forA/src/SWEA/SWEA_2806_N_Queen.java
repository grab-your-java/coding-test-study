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

			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void per(int cnt) {
		if (cnt == N) {
			ans++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i] && checkPosition(cnt, i)) {

				check[i] = true;
				arr[cnt] = i;
				per(cnt + 1);
				check[i] = false;

			}
		}

	}

	private static boolean checkPosition(int a, int b) {
		for (int i = 0; i < a; i++) {
			if (Math.abs(i - a) == Math.abs(arr[i] - b))
				return false;
		}
		return true;
	}

}
