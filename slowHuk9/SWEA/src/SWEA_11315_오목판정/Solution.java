package SWEA_11315_오목판정;

import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	static int T;
	static int N;
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			boolean isValid = false;
			if(rowCheck() || colCheck() || diagonalCheck()) {
				isValid = true;
			}
			
			if(isValid) {
				System.out.println("#" + test_case + " YES");
			}else {
				System.out.println("#" + test_case + " NO");
			}
			
		}

	}

	static boolean rowCheck() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 4; j++) {
				if (map[i][j] == 'o' && map[i][j + 1] == 'o' && map[i][j + 2] == 'o' && map[i][j + 3] == 'o'
						&& map[i][j + 4] == 'o') {
					return true;
				}
			}
		}
		return false;
	}

	static boolean colCheck() {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 4; i++) {
				if (map[i][j] == 'o' && map[i + 1][j] == 'o' && map[i + 2][j] == 'o' && map[i + 3][j] == 'o'
						&& map[i + 4][j] == 'o') {
					return true;
				}
			}
		}
		return false;
	}

	static boolean diagonalCheck() {
		for (int i = 0; i < N - 4; i++) {
			for (int j = 0; j < N - 4; j++) {
				if (map[i][j] == 'o' && map[i + 1][j + 1] == 'o' && map[i + 2][j + 2] == 'o' && map[i + 3][j + 3] == 'o'
						&& map[i + 4][j + 4] == 'o') {
					return true;
				}
			}
		}
		for (int i = 0; i < N - 4; i++) {
			for (int j = 4; j < N; j++) {
				if (map[i][j] == 'o' && map[i + 1][j - 1] == 'o' && map[i + 2][j - 2] == 'o' && map[i + 3][j - 3] == 'o'
						&& map[i + 4][j - 4] == 'o') {
					return true;
				}
			}
		}
		return false;
	}

}
