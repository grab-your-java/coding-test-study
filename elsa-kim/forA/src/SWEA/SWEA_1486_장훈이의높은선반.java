package SWEA;

import java.util.Scanner;

public class SWEA_1486_장훈이의높은선반 {
	static int cnt;
	static int top;
	static int[] origin;
	static int min;
	static int[] res;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			cnt = sc.nextInt();
			top = sc.nextInt();
			origin = new int[cnt];
			check = new boolean[cnt];
			min = 10000 * cnt;
			for (int i = 0; i < cnt; i++) {
				origin[i] = sc.nextInt();
			}
			for (int i = 1; i <= cnt; i++) {
				res = new int[i];
				com(0, 0);
			}
			System.out.println("#" + tc + " " + min);
		}
	}

	private static void com(int dep, int start) {
		if (dep == res.length) {
			int sum = 0;
			for (int i = 0; i < res.length; i++) {
				sum += origin[res[i]];
			}
			if (sum >= top && sum - top < min)
				min = sum - top;
			return;
		}
		for (int i = start; i < cnt; i++) {
			if (!check[i]) {
				check[i] = true;
				res[dep] = i;
				com(dep + 1, i + 1);
				check[i] = false;
			}
		}

	}

}
