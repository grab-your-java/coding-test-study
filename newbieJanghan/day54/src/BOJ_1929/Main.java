package BOJ_1929;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();

		boolean[] primes = new boolean[M + 1];
		Arrays.fill(primes, true);

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= M; i++) {
			if (primes[i]) {
				for (int j = 2; j <= M / i; j++) {
					primes[i * j] = false;
				}

				if (i >= N) {
					sb.append(i).append("\n");
				}
			}
		}

		System.out.println(sb);
	}
}
