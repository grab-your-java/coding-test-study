package BOJ_1654;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int K, N;
	static int[] lines;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();

		lines = new int[K];

		// set left, right splitter for binary search
		int left = Integer.MAX_VALUE, right = 0, answer = 0;
		for (int i = 0; i < K; i++) {
			int line = sc.nextInt();
			lines[i] = line;

			left = Math.min(left, line);
			right = Math.max(right, line);
		}

		while (true) {
			
			int minCnt = split(right), maxCnt = split(left);
			System.out.println("left: " + left + " maxCnt: " + maxCnt);
			System.out.println("right: " + right + " minCnt: " + minCnt);
			// break point
			if (minCnt == N) {
				while (minCnt == N) {
					minCnt = split(++right);
				}
				
				answer = right - 1;
				break;
			}

			if (maxCnt == N) {
				while (maxCnt == N) {
					maxCnt = split(++left);
				}
				
				answer = left - 1;
				break;
			}

			// fix invalid left or right
			// fix left first. because it's validity is independent.
			if (maxCnt < N) {
				left /= 2;
			}

			else if (minCnt < K) {
				right = (right + left) / 2;
			}

			// minCnt < N < maxCNt
			else {
				if (maxCnt - N > N - minCnt) {
					left = (left + right) / 2;
				} else {
					right = (left + right) / 2;
				}
			}
		}

		System.out.println(answer);
	}

	static int split(int len) {
		int cnt = 0;
		for (int i = K - 1; i >= 0; i--) {
			if (lines[i] == 0) {
				break;
			}
			cnt += lines[i] / len;
		}

		return cnt;
	}
}
