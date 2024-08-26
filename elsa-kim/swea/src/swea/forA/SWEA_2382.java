package swea.forA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 미생물 격리
public class SWEA_2382 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		next: for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 박스크기
			int time = sc.nextInt(); // 시간
			int dif = sc.nextInt(); // 종류
			int sum = 0;
			int[][] arr = new int[dif][4]; // [종류][i, j, cnt, way]

			for (int i = 0; i < dif; i++) {
				for (int j = 0; j < 4; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 이동 후 다시 처음 자리까지 오는 과정
			for (int i = 0; i < 2 * N - 2; i++) {
				time--;
				for (int j = 0; j < dif; j++) {
					if (arr[j][3] == 1) {
						if (arr[j][0] == 0) {
							arr[j][3] = 2;
							arr[j][0]++;
						} else {
							arr[j][0]--;
						}
					} else if (arr[j][3] == 2) {
						if (arr[j][0] == N - 1) {
							arr[j][3] = 1;
							arr[j][0]--;
						} else {
							arr[j][0]++;
						}

					} else if (arr[j][3] == 3) {
						if (arr[j][1] == 0) {
							arr[j][3] = 4;
							arr[j][1]++;
						} else {
							arr[j][1]--;
						}
					} else if (arr[j][3] == 4) {
						if (arr[j][1] == N - 1) {
							arr[j][3] = 3;
							arr[j][1]--;
						} else {
							arr[j][1]++;
						}

					}
					if (arr[j][0] == 0 || arr[j][0] == N - 1 || arr[j][1] == 0 || arr[j][1] == N - 1) {
						arr[j][2] /= 2;
					}
				}

				// 미생물끼리 만나서 합쳐지는 과정
				for (int j = 0; j < dif; j++) {
					if (arr[j][2] == 0)
						continue;
					List<Integer> list = new ArrayList<>();
					int a = arr[j][0];
					int b = arr[j][1];
					list.add(j);
					for (int k = j + 1; k < dif; k++) {
						if (arr[k][2] == 0)
							continue;
						if (arr[k][0] == a && arr[k][1] == b) {
							list.add(k);
						}
					}
					int maxIdx = j;
					for (int k = 0; k < list.size(); k++) {
						if (arr[list.get(k)][2] > arr[maxIdx][2])
							maxIdx = list.get(k);
					}
					for (int k = 0; k < list.size(); k++) {
						if (list.get(k) != maxIdx) {
							arr[maxIdx][2] += arr[list.get(k)][2];
							arr[list.get(k)][2] = 0;
						}
					}

				}
				// 과정 중 time만큼 지난경우 남은 미생물 출력
				if (time == 0) {
					for (int j = 0; j < dif; j++) {
						sum += arr[j][2];
					}
					System.out.println("#" + tc + " " + sum);
					continue next;
				}
			}
			
			int dieCnt = time / (N - 1);
			
			// 시간을 칸 수로 나눠 벽에 약품 만나는 회수만큼 미생물 수 감소
			for (int i = 0; i < dieCnt; i++) {
				for (int j = 0; j < dif; j++) {
					arr[j][2] /= 2;
				}
			}

			// 나머지만큼 이동하며 약품 만나면 미생물 감소
			time = time % (N - 1);
			for (int i = 0; i < time; i++) {
				for (int j = 0; j < dif; j++) {
					if (arr[j][3] == 1) {
						if (arr[j][0] == 0) {
							arr[j][3] = 2;
							arr[j][0]++;
						} else {
							arr[j][0]--;
						}
					} else if (arr[j][3] == 2) {
						if (arr[j][0] == N - 1) {
							arr[j][3] = 1;
							arr[j][0]--;
						} else {
							arr[j][0]++;
						}

					} else if (arr[j][3] == 3) {
						if (arr[j][1] == 0) {
							arr[j][3] = 4;
							arr[j][1]++;
						} else {
							arr[j][1]--;
						}
					} else if (arr[j][3] == 4) {
						if (arr[j][1] == N - 1) {
							arr[j][3] = 3;
							arr[j][1]--;
						} else {
							arr[j][1]++;
						}

					}
					if (arr[j][0] == 0 || arr[j][0] == N - 1 || arr[j][1] == 0 || arr[j][1] == N - 1) {
						arr[j][2] /= 2;
					}
				}

			}

			for (int j = 0; j < dif; j++) {
				sum += arr[j][2];
			}
			System.out.println("#" + tc + " " + sum);

		}
	}}
