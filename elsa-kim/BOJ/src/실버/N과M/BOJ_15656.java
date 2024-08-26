package 실버.N과M;

import java.util.Arrays;
import java.util.Scanner;

// N과 M (7)
public class BOJ_15656 {
	static int n;
	static int m;
	static int[] origin;
	static int[] arr;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		origin = new int[n];
		arr = new int[m];
		for (int i = 0; i < n; i++) {
			origin[i] = sc.nextInt();
		}
		Arrays.sort(origin);
		per(0);
		System.out.println(sb);
	}

	private static void per(int cnt) {
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
		for (int i = 0; i < n; i++) {
			arr[cnt] = origin[i];
			per(cnt + 1);
		}
	}
}
