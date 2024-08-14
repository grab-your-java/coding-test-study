package 실버.N과M;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15655 {
	static int n;
	static int m;
	static int[] origin;
	static int[] arr;
	static boolean[] check;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		origin = new int[n];
		for (int i = 0; i < n; i++) {
			origin[i] = sc.nextInt();
		}
		Arrays.sort(origin);
		check = new boolean[n];
		arr = new int[m];
		com(0, 0);
		System.out.println(sb);
	}

	private static void com(int cnt, int startIdx) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]);
				if (i != m - 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		for (int i = startIdx; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[cnt] = origin[i];
				com(cnt + 1, i + 1);
				check[i] = false;
			}
		}
	}

}
