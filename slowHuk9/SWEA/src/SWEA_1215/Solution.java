package SWEA_1215;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {

			int n = sc.nextInt();

			int result = 0;

			char[][] map = new char[8][8];
			for (int j = 0; j < map.length; j++) {
				String s = sc.next();
				for (int k = 0; k < map.length; k++) {
					map[j][k] = s.charAt(k);
				}
			}

			// 가로 방향 회문 검사
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c <= map.length - n; c++) {
					char[] word = new char[n];
					for (int t = 0; t < n; t++) {
						word[t] = map[r][c + t];
					}

					int cnt = 0;
					for (int j = 0; j <= n / 2 - 1; j++) {
						if (word[j] == word[n - 1 - j]) {
							cnt++;
							if (cnt == n / 2) {
								result++;
							}
						}

					}
				}
			}

			// 세로 방향 회문 검사
			for (int c = 0; c < map.length; c++) {
				for (int r = 0; r <= map.length - n; r++) {
					char[] word = new char[n];
					for (int t = 0; t < n; t++) {
						word[t] = map[r + t][c];
					}

					int cnt = 0;
					for (int j = 0; j <= n / 2 - 1; j++) {
						if (word[j] == word[n - 1 - j]) {
							cnt++;
							if (cnt == n / 2) {
								result++;
							}
						}

					}
				}
			}
			System.out.println("#" + i + " " + result);

		}
	}
}