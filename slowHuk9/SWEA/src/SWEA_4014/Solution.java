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
// 디버깅 checkrow 
package SWEA_4014;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int X;
	static int[][] map;
	static boolean[] rowValid;
	static boolean[] colValid;
	static boolean[][] rowVisited;
	static boolean[][] colVisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			X = sc.nextInt();
			map = new int[N][N];
			rowValid = new boolean[N];
			colValid = new boolean[N];
			rowVisited = new boolean[N][N];
			colVisited = new boolean[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			checkRow();
			checkCol();
			int result = 0;

			for (int i = 0; i < N; i++) {
				if (rowValid[i])
					result++;
			}
			for (int i = 0; i < N; i++) {
				if (colValid[i])
					result++;
			}
//			System.out.println(Arrays.toString(rowValid));
//			System.out.println(Arrays.toString(colValid));
			System.out.println("#" + test_case + " " + result);

		}
	}

	static void checkRow() {
		for (int i = 0; i < N; i++) {
			int cnt = 1;
//			System.out.println("_____________________i : " + i + " ______________________");
			for (int j = 0; j < N - 1; j++) {
				if (Math.abs(map[i][j] - map[i][j + 1]) >= 2) {
					rowValid[i] = false;
//					System.out.println("차이 2칸이므로 다음행으로");
					break; // 2칸 이상 차이나면 다음 행으로
				}
				if (map[i][j] == map[i][j + 1]) {
					cnt++;
					if (cnt == N) {
						rowValid[i] = true;
					}
//					System.out.println("평지 cnt ++   " + cnt);
					continue;
				}
				if (map[i][j] - map[i][j + 1] == -1) { // 오르막
					if (cnt < X) {
//						System.out.println("오르막, 충분한 공간이 없으므로 false");
						rowValid[i] = false;
						break;
					} else if (cnt >= X) {
//						System.out.println("오르막, 일단 건설은 가능 true");
						if (!(rowVisited[i][j - X + 1]) && !(rowVisited[i][j])) { // 중복제거
							rowValid[i] = true;
//							System.out.println("오르막, 건설 가능 중복 없음 true");
						} else {
							rowValid[i] = false;
							break;
						}
						for (int k = 0; k < X; k++) {
							rowVisited[i][j - k] = true;
						}
						cnt = 1;
						continue;
					}
				}
				if (map[i][j] - map[i][j + 1] == 1) { // 내리막

//					System.out.println("__________________내리막쓰_______________");
					cnt = 0;
					int k = 1;
//					System.out.println("j의 값 : " + j);
//					System.out.println("N-j-1 의 값 " + (N - j - 1));
					if (N - j - 1 < X) { // 내리막을 건설할 만큼의 남은 칸이 없다면
//						System.out.println("j의 값 : " + j);
//						System.out.println("N-j-1 의 값 " + (N - j - 1));
//						System.out.println("내리막, 충분한 공간이 없으므로 false");
						rowValid[i] = false;
						break;
					}
//					System.out.println("while 전 cnt  " + cnt);
//					System.out.println("while 전 k  " + k);
					while (k <= X) {
						if (map[i][j + k] == map[i][j] - 1) {
							cnt++;
//							System.out.println("cnt++ 이후 값   " + cnt);
						}
						k++;
//						System.out.println("k값  " + k);
					}
//					System.out.println("While문 이후 cnt " + cnt);
					if (cnt < X) {
						rowValid[i] = false;
						break;
					} else if (cnt >= X) {
						if (!(rowVisited[i][j + 1]) && !(rowVisited[i][j + X])) {
							rowValid[i] = true;
						} else {
							rowValid[i] = false;
							break;
						}
						for (int l = 0; l < X; l++) {
							rowVisited[i][j + 1 + l] = true;
						}
						cnt = 1;
						continue;
					}
				}

			}
//			System.out.println("row " + i + "행 : " + rowValid[i]);
		}
	}

	static void checkCol() {

		for (int j = 0; j < N; j++) {
			int cnt = 1;
//			System.out.println("_____________________j : " + j + " ______________________");
			for (int i = 0; i < N - 1; i++) {
				if (Math.abs(map[i][j] - map[i + 1][j]) >= 2) {
					colValid[j] = false;
//					System.out.println("차이 2칸이므로 다음행으로");
					break; // 2칸 이상 차이나면 다음 행으로
				}
				if (map[i][j] == map[i + 1][j]) {
					cnt++;
					if (cnt == N) {
						colValid[j] = true;
					}
//					System.out.println("평지 cnt ++   " + cnt);
					continue;
				}
				if (map[i][j] - map[i + 1][j] == -1) { // 오르막
					if (cnt < X) {
//						System.out.println("오르막, 충분한 공간이 없으므로 false");
						colValid[j] = false;
						break;
					} else if (cnt >= X) {
						if (!(colVisited[i - X + 1][j]) && !(colVisited[i][j])) { // 중복제거
							colValid[j] = true;
//							System.out.println("오르막, 건설 가능 중복 없음 true");
						} else {
							colValid[j] = false;
							break;
						}
						for (int k = 0; k < X; k++) {
							colVisited[i - k][j] = true;
						}
						cnt = 1;
						continue;
					}
				}
				if (map[i][j] - map[i + 1][j] == 1) { // 내리막

//					System.out.println("__________________내리막쓰_______________");
					cnt = 0;
					int k = 1;
//					System.out.println("i의 값 : " + i);
//					System.out.println("N-i-1 의 값 " + (N - i - 1));
					if (N - i - 1 < X) { // 내리막을 건설할 만큼의 남은 칸이 없다면
//						System.out.println("i의 값 : " + i);
//						System.out.println("N-i-1 의 값 " + (N - i - 1));
//						System.out.println("내리막, 충분한 공간이 없으므로 false");
						colValid[j] = false;
						break;
					}
//					System.out.println("while 전 cnt  " + cnt);
//					System.out.println("while 전 k  " + k);
					while (k <= X) {
						if (map[i + k][j] == map[i][j] - 1) {
							cnt++;
//							System.out.println("cnt++ 이후 값   " + cnt);
						}
						k++;
//						System.out.println("k값  " + k);
					}
//					System.out.println("While문 이후 cnt " + cnt);
					if (cnt < X) {
						colValid[j] = false;
						break;
					} else if (cnt >= X) {
						if (!(colVisited[i + 1][j]) && !(colVisited[i + X][j])) {
							colValid[j] = true;
						} else {
							colValid[j] = false;
							break;
						}
						for (int l = 0; l < X; l++) {
							colVisited[i + 1 + l][j] = true;
						}
						cnt = 1;
						continue;
					}
				}

			}
//			System.out.println("col " + j + "행 : " + colValid[j]);
		}
	}
	// 2 2 1 1 2 1 1 1 2 2 2 3 3 3 1 1 1 2 2 2 3 3 2 2 2 2 3 3 2 2 2 1 1 2 2 3 3 2 2
	// 2 1
}
