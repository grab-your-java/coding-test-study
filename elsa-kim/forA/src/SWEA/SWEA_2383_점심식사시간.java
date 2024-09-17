package SWEA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SWEA_2383_점심식사시간 {
	static int Pcnt, size, min;
	static int[][] stair, ori;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			size = sc.nextInt();
			ori = new int[size][size];
			Pcnt = 0;
			stair = new int[2][3];
			for (int i = 0, idx = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					ori[i][j] = sc.nextInt();
					if (ori[i][j] == 1)
						Pcnt++;
					if (ori[i][j] != 0 && ori[i][j] != 1) {
						stair[idx][2] = ori[i][j];
						stair[idx][0] = i;
						stair[idx++][1] = j;
					}
				}

			}
			min = 10000;
			check = new boolean[Pcnt];
			per(0);
			System.out.println("#" + tc + " " + min);
		}
	}

	private static void per(int cnt) {
		if (cnt == Pcnt) {
			List<Integer> arr1 = new ArrayList<>();
			List<Integer> arr2 = new ArrayList<>();
			for (int i = 0, idx = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (ori[i][j] == 1) {
						if (check[idx]) {
							arr1.add(Math.abs(i - stair[0][0]) + Math.abs(j - stair[0][1]));
						} else {
							arr2.add(Math.abs(i - stair[1][0]) + Math.abs(j - stair[1][1]));

						}
						idx++;
					}
				}

			}
			arr1.sort(Comparator.naturalOrder());
			arr2.sort(Comparator.naturalOrder());
			int[] arr1List = new int[arr1.size()];
			int[] arr2List = new int[arr2.size()];
			for (int i = 0; i < arr1.size(); i++) {
				if (i < 3) {
					arr1List[i] = arr1.get(i) + stair[0][2];
				} else {
					if (arr1List[i - 3] < arr1.get(i)) {
						arr1List[i] = arr1.get(i) + stair[0][2];
					} else {
						arr1List[i] = stair[0][2] + arr1List[i - 3];
					}
				}
			}
			for (int i = 0; i < arr2.size(); i++) {
				if (i < 3) {
					arr2List[i] = arr2.get(i) + stair[1][2];
				} else {
					if (arr2List[i - 3] < arr2.get(i)) {
						arr2List[i] = arr2.get(i) + stair[1][2];
					} else {
						arr2List[i] = stair[1][2] + arr2List[i - 3];
					}
				}
			}
			int ans = 0;
			if (arr1List.length == 0) {
				ans = arr2List[arr2List.length - 1] + 1;
			} else if (arr2List.length == 0) {
				ans = arr1List[arr1List.length - 1] + 1;
			} else {
				ans = Math.max(arr1List[arr1List.length - 1], arr2List[arr2List.length - 1]) + 1;
			}
			if (ans < min)
				min = ans;

			return;
		}
		check[cnt] = true;
		per(cnt + 1);
		check[cnt] = false;
		per(cnt + 1);

	}

}
