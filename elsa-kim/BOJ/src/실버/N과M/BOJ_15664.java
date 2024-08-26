package 실버.N과M;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// N과 M (10)
public class BOJ_15664 {
	static int n;
	static int m;
	static int[] origin;
	static int[] arr;
	static boolean[] check;
	static List<String> output = new ArrayList<>();
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		origin = new int[n];
		arr = new int[m];
		check = new boolean[n];

		for (int i = 0; i < n; i++) {
			origin[i] = sc.nextInt();
		}

		Arrays.sort(origin);

		com(0, 0);

		for (int i = 0; i < output.size(); i++) {
			sb.append(output.get(i) + "\n");
		}
		System.out.println(sb);
	}

	private static void com(int cnt, int start) {
		if (cnt == m) {
			String str = "";
			for (int i = 0; i < m; i++) {
				str += arr[i] + " ";
			}
			if (!output.contains(str)) {
				output.add(str);
			}
			return;
		}
		for (int i = start; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[cnt] = origin[i];
				com(cnt + 1, i);
				check[i] = false;
			}
		}

	}
}
