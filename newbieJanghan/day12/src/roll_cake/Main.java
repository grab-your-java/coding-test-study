package roll_cake;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int[] cakes = new int[L + 1];
		int eValue = 0;
		int eIdx = 0;
		int aValue = 0;
		int aIdx = 0;

		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			int P = sc.nextInt();
			int K = sc.nextInt();

			// Calculate estimate cake portion
			int length = K - P + 1;
			if (eValue < length) {
				eValue = length;
				eIdx = i;
			}

			// Calculate actual cake portion
			for (int j = P; j <= K; j++) {
				if (cakes[j]++ > 0) {
					length--;
				}
			}
			if (aValue < length) {
				aValue = length;
				aIdx = i;
			}

		}
		System.out.println(eIdx);
		System.out.println(aIdx);
	}
}