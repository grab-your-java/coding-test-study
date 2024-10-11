package BOJ_11047;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		int[] coins = new int[N];
		int maxIdx = N - 1;

		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
			if (maxIdx == N - 1 && coins[i] > K) {
				maxIdx = i - 1;
			}
		}

		int answer = 0;

		for (int i = maxIdx; i >= 0; i--) {
			int cnt = K / coins[i];

			answer += cnt;
			K -= coins[i] * cnt;
		}

		System.out.println(answer);
	}

}
