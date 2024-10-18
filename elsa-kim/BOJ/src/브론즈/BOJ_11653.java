package 브론즈;

import java.util.Scanner;

public class BOJ_11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 2;
		while (n != 1) {
			if (n % ans == 0) {
				System.out.println(ans);
				n /= ans;
			} else {
				ans++;
			}
		}
	}

}
