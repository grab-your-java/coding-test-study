package 실버;

import java.util.Scanner;

public class BOJ_1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] list = new int[n + 1][2];
		for (int i = 1; i < list.length; i++) {
			list[i] = list[i - 1].clone();
			int k = i;
			int cnt = 0;
			while (k % 2 == 0) {
				cnt++;
				k /= 2;
			}
			list[i][0] += cnt;
			cnt = 0;
			while (k % 5 == 0) {
				cnt++;
				k /= 5;
			}
			list[i][1] += cnt;
		}

		System.out.println(Math.min(list[n][0], list[n][1]));
	}

}
