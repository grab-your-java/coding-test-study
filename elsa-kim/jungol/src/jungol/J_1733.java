package jungol;

import java.util.Scanner;

// 오목
public class J_1733 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][][] check = new boolean[19][19][4];

		int[][] arr = new int[19][19];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0)
					continue;
				if (arr[i][j] == 1) {
					int k = 1;
					if (!check[i][j][0]) {
						while (i + k < 19 && arr[i + k][j] == 1) {
							check[i + k][j][0] = true;
							k++;
						}
						if (k == 5) {
							System.out.println(1);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					if (!check[i][j][1]) {
						k = 1;
						while (j + k < 19 && arr[i][j + k] == 1) {
							check[i][j + k][1] = true;
							k++;
						}
						if (k == 5) {
							System.out.println(1);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}

					}
					if (!check[i][j][3]) {
						k = 1;
						while (i + k < 19 && j + k < 19 && arr[i + k][j + k] == 1) {
							check[i + k][j + k][3] = true;
							k++;
						}
						if (k == 5) {
							System.out.println(1);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}

					}
					if (!check[i][j][2]) {
						k = 1;
						while (i + k < 19 && j - k >= 0 && arr[i + k][j - k] == 1) {
							check[i + k][j - k][2] = true;
							k++;
						}
						if (k == 5) {
							System.out.println(1);
							System.out.println((i + k) + " " + (j - k + 2));
							return;
						}

					}
				} else if (arr[i][j] == 2) {
					int k = 1;
					if (!check[i][j][0]) {
						while (i + k < 19 && arr[i + k][j] == 2) {
							check[i + k][j][0] = true;
							k++;
						}
						if (k == 5) {
							System.out.println(2);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					if (!check[i][j][1]) {
						k = 1;
						while (j + k < 19 && arr[i][j + k] == 2) {
							check[i][j + k][1] = true;
							k++;
						}
						if (k == 5) {
							System.out.println(2);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					if (!check[i][j][3]) {
						k = 1;
						while (i + k < 19 && j + k < 19 && arr[i + k][j + k] == 2) {
							check[i + k][j + k][3] = true;
							k++;
						}
						if (k == 5) {
							System.out.println(2);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					if (!check[i][j][2]) {
						k = 1;
						while (i + k < 19 && j - k >= 0 && arr[i + k][j - k] == 2) {
							check[i + k][j - k][2] = true;
							k++;
						}
						if (k == 5) {
							System.out.println(2);
							System.out.println((i + k) + " " + (j - k + 2));
							return;
						}

					}
				}
			}
		}
		System.out.println(0);
	}

}
