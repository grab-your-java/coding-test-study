package swea_2112;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int D, W, K;
	static boolean[][] films;
	static int minCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();

			films = new boolean[D][W];
			for (int d = 0; d < D; d++) {
				for (int w = 0; w < W; w++) {
					films[d][w] = sc.nextInt() == 1;
				}
			}

			minCnt = D;
			inject(0, 0);

			sb.append(minCnt).append("\n");
		}

		System.out.println(sb);
	}

	static void inject(int d, int cnt) {
		// 0. backtracking
		if (cnt > minCnt) {
			return;
		}

		// 0. check.
		boolean required = false;
		for (int w = 0; w < W; w++) {
			if (!checkStraight(w)) {
				required = true;
				break;
			}
		}
		if (!required) {
			minCnt = Math.min(minCnt, cnt);
			return;
		}

		if (d == D) {
			return;
		}

		// 1. inject nothing
		inject(d + 1, cnt);

		// prepare copy
		boolean[] temp = Arrays.copyOf(films[d], W);

		// 2. inject A
		boolean[] A = new boolean[W];
		films[d] = A;
		inject(d + 1, cnt + 1);

		// 3. inject B
		boolean[] B = new boolean[W];
		Arrays.fill(B, true);
		films[d] = B;
		inject(d + 1, cnt + 1);

		// restore copied
		films[d] = temp;
	}

	static boolean checkStraight(int w) {
		boolean flag = films[0][w];
		int count = 1;
		for (int d = 1; d < D; d++) {
			if (flag == films[d][w]) {
				count++;
			} else {
				flag = films[d][w];
				count = 1;
			}

			if (count >= K) {
				return true;
			}
		}

		return false;
	};
}
