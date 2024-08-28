package SWEA_1974;

import java.util.Scanner;

public class Solution {
	static int[][] map;
	static int T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			map = new int[9][9];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			if(rowCheck() && colCheck() && squareCheck()) {
				System.out.println("#"+ test_case + " 1");
			}else {
				System.out.println("#"+ test_case + " 0");
			}
		}
	}

	static boolean checkSdokuValid(int sum, int multiple) {
		return sum == 45 && multiple == 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;

	}

	static boolean rowCheck() {
		for (int i = 0; i < map.length; i++) {
			int sum = 0;
			int multiple = 1;
			for (int j = 0; j < map.length; j++) {
				sum += map[i][j];
				multiple *= map[i][j];
			}
			if (!checkSdokuValid(sum, multiple))
				return false;
		}
		return true;
	}

	static boolean colCheck() {
		for (int j = 0; j < map.length; j++) {
			int sum = 0;
			int multiple = 1;
			for (int i = 0; i < map.length; i++) {
				sum += map[i][j];
				multiple *= map[i][j];
			}
			if (!checkSdokuValid(sum, multiple))
				return false;
		}
		return true;
	}

	static boolean squareCheck() {
		for (int i = 0; i < map.length; i+=3) {
			for (int j = 0; j < map.length; j += 3) {
				int sum = 0;
				int multiple = 1;
				for (int k = 0; k < 3; k++) {
					for (int r = 0; r < 3; r++) {
						sum += map[i + k][j + r];
						multiple *= map[i + k][j + r];
					}
				}
				if (!checkSdokuValid(sum, multiple)) {
					return false;
				}
			}
		}
		return true;
	}
}
