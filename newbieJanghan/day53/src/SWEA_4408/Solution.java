package SWEA_4408;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			int N = sc.nextInt();
			int[] cnt = new int[20];

			int answer = 0;
			while (N-- > 0) {
				int a = sc.nextInt(), b = sc.nextInt();

				if (a % 2 == 0) {
					a = a / 2 - 1;
				} else {
					a = a / 2;
				}

				if (b % 2 == 0) {
					b = b / 2 - 1;
				} else {
					b = b / 2;
				}

				int start = a < b ? a : b, end = start == a ? b : a;

				for (int i = start; i <= end; i++) {
					cnt[i]++;
					answer = Math.max(answer, cnt[i]);
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
