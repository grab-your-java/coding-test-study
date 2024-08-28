package FixingError;

import java.util.Scanner;

public class Main {
	static int[][] map;
	static int n;
	static boolean[] rowSum;
	static boolean[] colSum;
	static int falseCnt;
	static int targetRow = -1;
	static int targetCol = -1;
	static boolean rowParity;
	static boolean colParity;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];
		rowSum = new boolean[n];
		colSum = new boolean[n];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		calRowSum();
		calColSum();
		countRowFalse();
		countColFalse();

		if (rowParity && colParity) {
			System.out.println("OK");
		} else if (targetRow != -1 && targetCol != -1) {
			System.out.println("Change bit (" + (targetRow + 1) + "," + (targetCol + 1) + ")");
		} else {
			System.out.println("Corrupt");
		}

	}

	static void calRowSum() {
		for (int i = 0; i < map.length; i++) {
			int sum = 0;
			for (int j = 0; j < map.length; j++) {
				sum += map[i][j];
			}
			if (sum % 2 == 0)
				rowSum[i] = true;
		}
	}

	static void calColSum() {
		for (int j = 0; j < map.length; j++) {
			int sum = 0;
			for (int i = 0; i < map.length; i++) {
				sum += map[i][j];
			}
			if (sum % 2 == 0)

				colSum[j] = true;


		}
	}

	static void countRowFalse() {
		int a = 0;
		for (int i = 0; i < rowSum.length; i++) {
			if (rowSum[i] == false) {
				falseCnt++;
				a = i;
			}
		}
		if (falseCnt == 1) {
			targetRow = a;
		} else if (falseCnt > 1) {
			rowParity = false;
		} else
			rowParity = true;
	}

	static void countColFalse() {
		falseCnt = 0;
		int a = 0;
		for (int i = 0; i < colSum.length; i++) {
			if (colSum[i] == false) {
				falseCnt++;
				a = i;
			}
		}
		if (falseCnt == 1) {
			targetCol = a;
		} else if (falseCnt > 1) {
			colParity = false;
		} else
			colParity = true;
	}
}
