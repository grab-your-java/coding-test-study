package blackjack;

import java.util.Scanner;

public class BitMask {
	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int result = 0;
		for (int i = 0; i < (1 << N); i++) {
			int sum = 0;
			int count = 3; // 부분집합의 크기 조건
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					if (count == 0)
						break;
					else {
						sum += arr[j];
						count--;
					}
				}

			}
			if (count == 0) {
				if (result < sum && sum <= M) {
					result = sum;
				}
			}

		}

		System.out.println(result);

	}
}
