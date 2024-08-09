package prime_number;

import java.util.Scanner;

public class Solution {
	public static int[] primeNumbers = new int[1000001];
	static {
		primeNumbers[0] = 1;
		primeNumbers[1] = 1;
		for (int i = 2; i <= Math.sqrt(1000000); i++) {
			if (primeNumbers[i] == 1) {
				continue;
			}

			int j = 2;
			while (i * j <= 1000000) {
				primeNumbers[i * j] = 1;
				j += 1;
			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int result = 0;

			String specialStr = String.valueOf(D);
			for (int i = A; i <= B; i++) {
				if (primeNumbers[i] == 0 && String.valueOf(i).contains(specialStr)) {
					result++;
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}

}
