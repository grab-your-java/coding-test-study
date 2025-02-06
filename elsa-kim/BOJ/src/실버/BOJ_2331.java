package 실버;

import java.util.Scanner;

public class BOJ_2331 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		boolean[] check = new boolean[300000];
		int newN = 0;
		int ans = 0;
		while (!check[n]) {
			ans++;
			check[n] = true;
			while (n > 0) {
				newN += Math.pow(n % 10, p);
				n /= 10;
			}
			n = newN;
			newN = 0;

		}
		while (check[n]) {
			ans--;
			check[n] = false;
			while (n > 0) {
				newN += Math.pow(n % 10, p);
				n /= 10;
			}
			n = newN;
			newN = 0;
		}
		System.out.println(ans);
	}

}
