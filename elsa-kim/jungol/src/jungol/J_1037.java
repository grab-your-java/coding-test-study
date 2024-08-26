package jungol;

import java.util.Scanner;

public class J_1037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[][] sumArr = new int[n][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sumArr[i][0] += arr[i][j];
				sumArr[i][1] += arr[j][i];
			}
		}
		boolean isOk = true;
		for (int i = 0; i < n; i++) {
			if (sumArr[i][0] % 2 == 1) {
				isOk = false;
			}
			if (sumArr[i][1] % 2 == 1) {
				isOk = false;
			}
		}
		if (isOk) {
			System.out.println("OK");
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					isOk = true;
					sumArr = new int[n][2];
					if (arr[i][j] == 1) {
						arr[i][j] = 0;
					} else {
						arr[i][j] = 1;
					}

					for (int l = 0; l < n; l++) {
						for (int m = 0; m < n; m++) {
							sumArr[l][0] += arr[l][m];
							sumArr[l][1] += arr[m][l];
						}
					}

					for (int l = 0; l < n; l++) {
						if (sumArr[l][0] % 2 == 1) {
							isOk = false;
						}
						if (sumArr[l][1] % 2 == 1) {
							isOk = false;
						}
					}
					if (isOk) {
						System.out.println("Change bit (" + (i + 1) + "," + (j + 1) + ")");
						return;
					}
					if (arr[i][j] == 1) {
						arr[i][j] = 0;
					} else {
						arr[i][j] = 1;
					}

				}
			}
			if (!isOk) {
				System.out.println("Corrupt");
			}
		}
	}
}
