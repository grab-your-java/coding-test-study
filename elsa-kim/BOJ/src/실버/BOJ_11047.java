package 실버;

import java.util.Scanner;

public class BOJ_11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int want = sc.nextInt();
		int[] list = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			list[i] = sc.nextInt();
		}
		int ans = 0;
		for (int i = cnt - 1; i >= 0; i--) {
			if (want < list[i])
				continue;
			ans += want / list[i];
			want %= list[i];
		}
		System.out.println(ans);
	}
}
