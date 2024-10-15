package 실버;

import java.util.Scanner;

public class BOJ_1476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		E--;
		S--;
		M--;
		int ans = 0;
		while (ans % 15 != E || ans % 19 != M || ans % 28 != S) {
			ans++;
		}
		ans++;
		System.out.println(ans);
	}
}
