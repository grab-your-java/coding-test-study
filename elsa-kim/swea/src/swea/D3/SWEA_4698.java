package swea.D3;

import java.util.Scanner;

public class SWEA_4698 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] list = new int[1000001];
		for (int i = 2; i < list.length; i++) {
			list[i] = i;
		}
		next: for (int i = 2; i < list.length; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (list[j] != 0 && list[i] % list[j] == 0) {
					list[i] = 0;
					continue next;
				}
			}

		}
		for (int tc = 1; tc <= T; tc++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int cnt = 0;
			boolean can;
			for (int i = A; i <= B; i++) {
				if (list[i] == 0)
					continue;
				int n = i;
				can = false;
				while (n != 0) {
					if (n % 10 == D) {
						can = true;
						break;
					}
					n /= 10;
				}
				if (can)
					cnt++;

			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
