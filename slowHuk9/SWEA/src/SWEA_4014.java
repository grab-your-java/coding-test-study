/*
 * 순회하면서 
 * for i = 0  i < N i ++
 * int cnt = 1;
 * for j= 0  j<N-1	 j++
 * IF map[i][j] == map[i][j+1] cnt ++; continue;
 * IF map[i][j] - map[i][j+1] == -1
 * 		if cnt>= X  ,    boolean isValid = true;
 * 		else boolean isValid = false;
 * 			
 * 
 * 2 2 2 2 3 3 3 3 3 2 2 2 2 2 1 1 1 1 1
 * 1 1 1 1 1 3 3 3
 *  * */

import java.util.Scanner;

public class SWEA_4014 {
	static int N;
	static int X;
	static int[][] map;
	static boolean[] isValid;
	static int idx;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 0; test_case <= T; test_case++) {
			N = sc.nextInt();
			X = sc.nextInt();
			idx = 0;
			map = new int[N][N];
			isValid = new boolean[N * 3];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			checkRow();
			checkCol();
			int result = 0;
			for (int i = 0; i < isValid.length; i++) {
				if (isValid[i])
					result++;
			}
			System.out.println(result);

		}
	}

	static void checkRow() {
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N - 1; j++) {

				System.out.println(
						"==============i: " + i + " " + " j : " + j + " cnt : " + cnt + "====================");
				if (map[i][j] == map[i][j + 1]) { // 평지 카운트 + 1
					cnt++;
					continue;
				}
				if (map[i][j] - map[i][j + 1] == -1) {// 오르막
					System.out.println("오르막");
					if (cnt < X) {
						System.out.println("cnt :" + cnt + " X 값  : " + X);
						System.out.println("경사로 건설 불가");

						isValid[idx++] = false;
						System.out.println("idx row cnt < x " + idx);

						break;
					} else {
						System.out.println("cnt :" + cnt + " X 값  : " + X);
						System.out.println("경사로 건설 가능");
						isValid[idx++] = true;
						System.out.println("idx row cnt >= x " + idx);

						cnt = 0;
					}
				} else if (map[i][j] - map[i][j + 1] == 1) { // 내리막
					System.out.println("내리막");
					cnt = 1;
					int k = 1;
					while ((j + 1 + k) < N && map[i][j + 1] == map[i][j + 1 + k]) {
						System.out.println("++++" + (j + k + 1));
						cnt++;
						k++;
					}
					System.out.println("cnt :" + cnt);
					System.out.println("(N - j - k - 2) :" + (N - j - k - 2));
					if ((cnt >= X && (N - j - k - 2) >= X) || (cnt >= X && (N - j - k - 2) == 0)) {
						System.out.println("cnt :" + cnt + " X 값  : " + X);
						System.out.println("경사로 건설 가능");
						isValid[idx++] = true;
						System.out.println("idx row cnt >= x " + idx);

						cnt = 0;
					} else if (cnt < X) {
						System.out.println("cnt :" + cnt + " X 값  : " + X);
						System.out.println("경사로 건설 불가");

						isValid[idx++] = false;
						System.out.println("idx row cnt < x " + idx);

						break;
					}
				} else if (Math.abs(map[i][j] - map[i][j + 1]) >= 2) {
					cnt = 0;
					continue;
				}
				// 2 2 1 1 2 1 1 1 2 2 2 3 3 3 1 1 1 2 2 2 3 3 2 2 2 2 3 3 2 2 2 1 1 2 2 3 3 2 2
				// 2 1
			}
		}
	}

	static void checkCol() {
		for (int j = 0; j < N; j++) {
			int cnt = 1;
			for (int i = 0; i < N - 1; i++) {

				System.out.println(
						"==============i: " + i + " " + " j : " + j + " cnt : " + cnt + "====================");
				if (map[i][j] == map[i + 1][j]) { // 평지 카운트 + 1
					cnt++;
					continue;
				}
				if (map[i][j] - map[i + 1][j] == -1) {// 오르막
					System.out.println("오르막");
					if (cnt < X) {
						System.out.println("cnt :" + cnt + " X 값  : " + X);
						System.out.println("경사로 건설 불가");

						isValid[idx++] = false;
						System.out.println("idx row cnt < x " + idx);

						break;
					} else {
						System.out.println("cnt :" + cnt + " X 값  : " + X);
						System.out.println("경사로 건설 가능");
						isValid[idx++] = true;
						System.out.println("idx row cnt >= x " + idx);

						cnt = 0;
					}
				} else if (map[i][j] - map[i + 1][j] == 1) { // 내리막
					System.out.println("내리막");
					cnt = 1;
					int k = 1;
					while ((i + 1 + k) < N && map[i + 1][j] == map[i + 1 + k][j]) {
						cnt++;
						k++;
					}
					if ((cnt >= X && (N - i - k - 2) >= X) || (cnt >= X && (N - i - k - 2) == 0)) {
						System.out.println("cnt :" + cnt + " X 값  : " + X);
						System.out.println("경사로 건설 가능");
						isValid[idx++] = true;
						System.out.println("idx row cnt >= x " + idx);

						cnt = 0;
					} else
						System.out.println("cnt :" + cnt + " X 값  : " + X);
					System.out.println("경사로 건설 불가");

					isValid[idx++] = false;
					System.out.println("idx row cnt < x " + idx);

					break;

				} else if (Math.abs(map[i][j] - map[i + 1][j]) >= 2) {
					cnt = 0;
					continue;
				}
				// 2 2 1 1 2 1 1 1 2 2 2 3 3 3 1 1 1 2 2 2 3 3 2 2 2 2 3 3 2 2 2 1 1 2 2 3 3 2 2
				// 2 1
			}
		}
	}
}
