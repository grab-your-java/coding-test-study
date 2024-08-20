package SWEA_7236;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int T;
	static int N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new int[N + 2][N + 2];
			int[] arr = new int[N * N];

			for (int i = 0; i < N + 2; i++) {
				map[0][i] = 0;
				map[N + 1][i] = 0;
				map[i][0] = 0;
				map[N + 1][0] = 0;
			}

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (sc.next().equals("G")) {
						map[i][j] = 0;
					} else {
						map[i][j] = 1;
					}
				}
			}
			int index = 0;
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					int sum = 0;
					if (map[i][j] == 1) {
						int depth = map[i][j + 1] + map[i][j - 1] + map[i + 1][j] + map[i - 1][j] + map[i - 1][j - 1]
								+ map[i + 1][j + 1] + map[i + 1][j - 1] + map[i - 1][j + 1];
						if (depth == 0) {
							depth = 1;
						}
						sum += depth;
						arr[index++] = sum;
					}
				}
			}
			Arrays.sort(arr);

			System.out.println("#" + test_case + " " + arr[arr.length - 1]);

		}

	}
}
