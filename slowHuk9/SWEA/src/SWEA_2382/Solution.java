package SWEA_2382;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	static int K;
	static int[] dr = { 0, -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, 0, -1, 1 };
	static int[][] microbe;
	static int[][] map;
	static int[] direction;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 셀의 갯수
			M = sc.nextInt(); // 격리 시간
			K = sc.nextInt(); // 군집 수
			map = new int[N][N];
			direction = new int[K + 1];
			microbe = new int[K + 1][4]; // [K][1] = 미생물 r좌표 / [K][2] = 미생물 c좌표 / [K][3] = 미생물 수 /
			for (int i = 1; i < microbe.length; i++) {
				microbe[i][1] = sc.nextInt();
				microbe[i][2] = sc.nextInt();
				microbe[i][3] = sc.nextInt();
				direction[i] = sc.nextInt(); // 진행방향
				map[microbe[i][1]][microbe[i][2]] = 1;
			}

//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map.length; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			int time = 0;
			int[] prevR = new int[K + 1];
			int[] prevC = new int[K + 1];
			ArrayList<Integer> gatherList = new ArrayList<>();
			while (time < M) {
				for (int i = 1; i < K + 1; i++) {
					int nr = microbe[i][1] + dr[direction[i]];
					int nc = microbe[i][2] + dc[direction[i]];

					if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
						microbe[i][3] /= 2; // 미생물 절반 킬
						if (direction[i] == 1 || direction[i] == 2) {
							direction[i] = 3 - direction[i];
						} else {
							direction[i] = 7 - direction[i];
						} // 진행방향 반대로
					}

					prevR[i] = microbe[i][1];
					prevC[i] = microbe[i][2];
					map[prevR[i]][prevC[i]]--;

					microbe[i][1] = nr; // 좌표 업데이트
					microbe[i][2] = nc;
					map[microbe[i][1]][microbe[i][2]]++;

				}
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map.length; j++) {
						if (map[i][j] >= 2) { // 이동 후 해당 칸에 만난 군집이 2개 이상이라는 것 --> 합병 진행해야함
//							System.out.println("____________________만나는 구간 i : " + i + " j : " + j
//									+ "___________________________");
							gatherList.clear();
							for (int num = 1; num < K + 1; num++) {
								if (microbe[num][1] == i && microbe[num][2] == j) {
									gatherList.add(num);
								}
							}
//							System.out.println("gatherList:" + gatherList);
							int max = microbe[gatherList.get(0)][3];
							int maxMicroNum = gatherList.get(0);
							int sum = microbe[gatherList.get(0)][3];

							for (int k = 1; k < gatherList.size(); k++) {
								if (microbe[gatherList.get(k)][3] > max) {
									max = microbe[gatherList.get(k)][3];
									maxMicroNum = gatherList.get(k);
								}
								sum += microbe[gatherList.get(k)][3];
							}
//							Arrays.sort(arr);
//							System.out.println("가장 큰 군집 번호 " + maxMicroNum + "해당 군집 미생물 수" + max);
//							System.out.println("합병 후 미생물 수" + sum);

							for (int k = 0; k < gatherList.size(); k++) {
								if (gatherList.get(k) != maxMicroNum) {
									microbe[gatherList.get(k)][3] = 0;
								} else {
									microbe[gatherList.get(k)][3] = sum;
								}
							}
							
//							for (int k = 0; k < gatherList.size(); k++) {
//								System.out.println(microbe[gatherList.get(k)][3] + " ");
//							}

//							if (microbe[num][3] > max) {
//								max = microbe[num][3];
//								maxMicroNum = num;
//							}
//							sum += microbe[num][3];
//							System.out.println(sum);
////								System.out.println(gatherList);
//							microbe[maxMicroNum][3] = sum;
//							for (int p = 0; p < gatherList.size(); p++) {
//								if (gatherList.get(p) != maxMicroNum) {
//									microbe[gatherList.get(p)][3] = 0;
//								}
//							}
						}
					}
				}
				time++;
			}
			int result = 0;
			for (int i = 1; i < microbe.length; i++) {
//				System.out.println(microbe[i][3]);
				result += microbe[i][3];
			}
			System.out.println("#" + tc + " " + result);
		}

	}
}
