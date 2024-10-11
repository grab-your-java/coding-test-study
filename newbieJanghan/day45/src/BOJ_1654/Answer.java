package BOJ_1654;

import java.util.Scanner;

public class Answer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt(), N = sc.nextInt();
		int[] lines = new int[K];
		long l = 0, r = 0;
		for (int i = 0; i < K; i++) {
			lines[i] = sc.nextInt();
			r = Math.max(r, lines[i]);
		}

		// case for { 1, 1 }
		r++; 
		
		// binary search
		while (l < r) {
			long m = (l + r) / 2;
			long cnt = 0;
			for (int i = 0; i < K; i++) {
				cnt += (lines[i] / m);
			}

			/*
			 * UPPER BOUND
			 * 
			 * even if cnt is equal to N, continue binary search, so that calculate max
			 * answer in available scope
			 */
			if (cnt < N) {
				r = m;
			}

			else {
				l = m + 1;
			}
		}

		System.out.println(l - 1);
	}
}

