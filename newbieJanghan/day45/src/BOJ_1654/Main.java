package BOJ_1654;

import java.util.Scanner;

public class Main {
	static int K, N;
	static int[] lines;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();
		N = sc.nextInt();
		lines = new int[K];
		long l = 1, r = 0;
		for (int i = 0; i < K; i++) {
			lines[i] = sc.nextInt();
			r = Math.max(r, lines[i]);
		}
		
		// binary search
		while (l < r) {
			long m = (l + r) / 2;
			long cnt = split(m);

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

		if (split(l) < N) {
			l--;
		}

		// find max value within the scope
		while (split(l + 1) == N) {
			l++;
		}

		System.out.println(l);

	}

	static long split(long len) {
		long cnt = 0;
		for (int i = 0; i < K; i++) {
			cnt += (lines[i] / len);
		}

		return cnt;
	}
}

