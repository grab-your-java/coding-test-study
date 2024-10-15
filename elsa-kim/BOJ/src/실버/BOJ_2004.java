package 실버;

import java.util.Scanner;

public class BOJ_2004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] list = new int[n + 1][2];
		int k, cnt = 0;

		for (int i = 1; i < list.length; i++) {
			list[i] = list[i - 1].clone();
			if (i % 2 == 0) {
				k = i;
				while (k % 2 == 0) {
					cnt++;
					k /= 2;
				}
				list[i][0] += cnt;
				cnt = 0;
			}
			if (i % 5 == 0) {
				k = i;
				while (k % 5 == 0) {
					cnt++;
					k /= 5;
				}
				list[i][1] += cnt;
				cnt = 0;
			}

		}

		System.out.println(Math.min(list[n][0] - list[m][0] - list[n - m][0], list[n][1] - list[m][1] - list[n - m][1]));
	}

}
