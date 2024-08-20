package SWEA_7964;

import java.util.Scanner;

public class Solution {
	static int T;
	static int N;
	static int distance;
	static int[] city;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			distance = sc.nextInt();
			city = new int[N + 2];
			city[0] = 1;
			city[N + 1] = 1;
			int cnt = 0;
			int start = 0;
			int gate = 0; // 게이트 수
			int idx = 1;
			for (int i = 1; i <= N; i++) {
				city[i] = sc.nextInt();
			}

			for (int i = 1; i < N+1; i++) {
				if (city[i] == 0) {
					cnt++;
					if (cnt == distance) {
						city[i] = 1;
						gate++;
						cnt = 0;
					}
				}
				if (city[i] == 1) {
					cnt = 0;
				}
			}
			System.out.println("#"+test_case + " " + gate);

		}
	}
}
