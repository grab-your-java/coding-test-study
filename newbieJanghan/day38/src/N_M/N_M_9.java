package N_M;

import java.util.Scanner;

public class N_M_9 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		do {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
		} while (nextPerm());
	}

	public static boolean nextPerm() {
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}

		if (i == 0) {
			return false;
		}

		int j = N - 1;
		while (arr[i - 1] >= arr[j]) {
			j--;
		}

		swap(i - 1, j);
		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}

		return true;

	}

	private static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
