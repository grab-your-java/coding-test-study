package Omok;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int targetRow;
	static int targetCol;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		map = new int[29][29];

		for (int i = 5; i < map.length - 5; i++) {
			for (int j = 5; j < map.length - 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int rowResult = rowCheck();
		int colResult = colCheck();
		int diagnoalResult1 = diagnoal1();
		int diagnoalResult2 = diagnoal2();
		int[] resultList = { rowResult, colResult, diagnoalResult1, diagnoalResult2 };
		Arrays.sort(resultList);
		if (rowResult == 0 && colResult == 0 && diagnoalResult1 == 0 && diagnoalResult2 == 0) {
			System.out.println(0);
		} else {
			System.out.println(resultList[resultList.length - 1]);
			System.out.print((targetRow - 4) + " " + (targetCol - 4));
		}
	}

	static int rowCheck() {
		int result = 0;
		for (int i = 5; i < map.length - 5; i++) {
			for (int j = 5; j < map.length - 5; j++) {
				if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i][j + 2] == 1 && map[i][j + 3] == 1
						&& map[i][j + 4] == 1 && map[i][j + 5] != 1 && map[i][j - 1] != 1) {
					result = 1;
					targetRow = i;
					targetCol = j;
					return result;
				}
				if (map[i][j] == 2 && map[i][j + 1] == 2 && map[i][j + 2] == 2 && map[i][j + 3] == 2
						&& map[i][j + 4] == 2 && map[i][j + 5] != 2 && map[i][j - 1] != 2) {
					result = 2;
					targetRow = i;
					targetCol = j;
					return result;
				}
			}
		}
		return result;
	}

	static int colCheck() {
		int result = 0;
		for (int j = 5; j < map.length - 5; j++) {
			for (int i = 5; i < map.length - 5; i++) {
				if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i + 2][j] == 1 && map[i + 3][j] == 1
						&& map[i + 4][j] == 1 && map[i + 5][j] != 1 && map[i - 1][j] != 1) {
					result = 1;
					targetRow = i;
					targetCol = j;
					return result;
				}
				if (map[i][j] == 2 && map[i + 1][j] == 2 && map[i + 2][j] == 2 && map[i + 3][j] == 2
						&& map[i + 4][j] == 2 && map[i + 5][j] != 2 && map[i - 1][j] != 2) {
					result = 2;
					targetRow = i;
					targetCol = j;
					return result;
				}
			}
		}
		return result;
	}

	static int diagnoal1() {// '\' 오른쪽 아래 대각 체크
		int result = 0;
		for (int j = 5; j < map.length - 5; j++) {
			for (int i = 5; i < map.length - 5; i++) {
				if (map[i][j] == 1 && map[i + 1][j + 1] == 1 && map[i + 2][j + 2] == 1 && map[i + 3][j + 3] == 1
						&& map[i + 4][j + 4] == 1 && map[i + 5][j + 5] != 1 && map[i - 1][j - 1] != 1) {
					result = 1;
					targetRow = i;
					targetCol = j;
					return result;

				}
				if (map[i][j] == 2 && map[i + 1][j + 1] == 2 && map[i + 2][j + 2] == 2 && map[i + 3][j + 3] == 2
						&& map[i + 4][j + 4] == 2 && map[i + 5][j + 5] != 2 && map[i - 1][j - 1] != 2) {
					result = 2;
					targetRow = i;
					targetCol = j;
					return result;
				}
			}
		}
		return result;
	}

	static int diagnoal2() {// '/' 오른쪽 위 상향 대각 체크
		int result = 0;
		for (int j = 5; j < map.length - 5; j++) {
			for (int i = 5; i < map.length - 5; i++) {
				if (map[i][j] == 1 && map[i - 1][j + 1] == 1 && map[i - 2][j + 2] == 1 && map[i - 3][j + 3] == 1
						&& map[i - 4][j + 4] == 1 && map[i - 5][j + 5] != 1 && map[i + 1][j - 1] != 1) {
					result = 1;
					targetRow = i;
					targetCol = j;
					return result;
				}
				if (map[i][j] == 2 && map[i - 1][j + 1] == 2 && map[i - 2][j + 2] == 2 && map[i - 3][j + 3] == 2
						&& map[i - 4][j + 4] == 2 && map[i - 5][j + 5] != 2 && map[i + 1][j - 1] != 2) {
					result = 2;
					targetRow = i;
					targetCol = j;
					return result;
				}
			}
		}
		return result;
	}

}