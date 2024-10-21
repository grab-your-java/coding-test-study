package BOJ_11653;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] valid = new boolean[N + 1];
		Arrays.fill(valid, true);
		valid[1] = false;

		for (int i = 2; i <= N; i++) {
			if (valid[i]) {
				for (int j = 2; j <= N / i; j++) {
					valid[i * j] = false;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int quotient = 2;
		while (N > 1) {
			if (valid[quotient] && N % quotient == 0) {
				sb.append(quotient).append("\n");
				N /= quotient;
			} else {
				quotient++;
			}
		}
		
		System.out.println(sb);
	}
}
