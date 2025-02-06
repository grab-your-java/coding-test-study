package 브론즈;

import java.util.Scanner;

public class BOJ_1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int ans = 0;
		boolean[] check = new boolean[1001];
		next: for (int i = 2; i < check.length; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (!check[j])
					continue;
				if (i % j == 0)
					continue next;
			}
			check[i] = true;
		}
		for (int i = 0; i < cnt; i++) {
			if (check[sc.nextInt()])
				ans++;
		}
		System.out.println(ans);
	}

}
