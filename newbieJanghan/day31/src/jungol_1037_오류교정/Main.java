package jungol_1037_오류교정;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] rowSum = new int[N + 1], colSum = new int[N + 1];

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (sc.nextInt() == 1) {
					rowSum[r]++;
					colSum[c]++;	
				}
			}
		}

		String result = "OK";
        boolean bitChanged = false;
		Search: for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (rowSum[r] % 2 == 1 || colSum[c] % 2 == 1) {
					result = "Corrupt";
				}

				if (rowSum[r] % 2 == 1 && colSum[c] % 2 == 1) {
					if (!bitChanged) {
						result = "Change bit (" + r + "," + c + ")";
						rowSum[r]--;
						colSum[c]--;
						bitChanged = true;
					} else {
						result = "Corrupt";
						break Search;
					}
				}
			}
		}

		System.out.println(result);

	}
}
