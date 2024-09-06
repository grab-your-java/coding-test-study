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
		if (d == D) {
			if(check()) {
				minCnt = Math.min(minCnt, cnt);
			}
			return;
		}

		// 1. inject nothing
		inject(d + 1, cnt);

		// prepare copy
		boolean[] temp = films[d].clone();

		// 2. inject A
		Arrays.fill(films[d], false); 
		inject(d + 1, cnt + 1);

		// 3. inject B
		Arrays.fill(films[d], true);
		inject(d + 1, cnt + 1);

		// restore copied
		films[d] = temp;
	}

	static boolean check() {
		for (int w =0; w<W; w++) {
			boolean flag = false;
			
			boolean prev = films[0][w];
			int count = 1;
			for (int d = 1; d < D; d++) {
				if (prev == films[d][w]) {
					count++;
				} else {
					prev = films[d][w];
					count = 1;
				}

				if (count >= K) {
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				return false;
			}
		}
		
		return true;
	};
}
