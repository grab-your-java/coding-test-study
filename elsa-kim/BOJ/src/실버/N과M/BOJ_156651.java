package 실버.N과M;

import java.util.Scanner;

//N과 M (3)
public class BOJ_156651 {
	static int n;
	static int m;
	static int[] arr;
	static StringBuffer sb = new StringBuffer();

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
		for (int i = 1; i <= n; i++) {
			arr[cnt] = i;
			per(cnt + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		per(0);
		System.out.println(sb);
	}
}
