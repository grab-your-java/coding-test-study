package 실버;

import java.util.Scanner;

public class BOJ_1780 {
	static int ans1, ans2, ans3;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		ans1 = 0;
		ans2 = 0;
		ans3 = 0;
		checkNum(0, 0, n);
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
	}

	private static void checkNum(int i, int j, int size) {
		for (int k = i; k < i + size; k++) {
			for (int l = j; l < j + size; l++) {
				if (arr[i][j] != arr[k][l]) {
					checkNum(i, j, size / 3);
					checkNum(i + size / 3, j, size / 3);
					checkNum(i + 2 * size / 3, j, size / 3);
					checkNum(i, j + size / 3, size / 3);
					checkNum(i + size / 3, j + size / 3, size / 3);
					checkNum(i + 2 * size / 3, j + size / 3, size / 3);
					checkNum(i, j + 2 * size / 3, size / 3);
					checkNum(i + size / 3, j + 2 * size / 3, size / 3);
					checkNum(i + 2 * size / 3, j + 2 * size / 3, size / 3);
					return;
				}
			}
		}
		switch (arr[i][j]) {
		case -1:
			ans1++;
			break;
		case 0:
			ans2++;
			break;
		case 1:
			ans3++;
			break;
		}

	}

}
