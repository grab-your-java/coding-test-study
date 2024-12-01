import java.util.Scanner;

public class BOJ_1780 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int length = N;
		int[][] map = new int[N][N];
		int[] result = new int[3]; // [0] = -1 // [1] = 0 // [2] = 1
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		verify(map, 0, 0, result, length);

		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
	}

	static boolean isEqual(int[][] map, int startR, int startC, int length) {
		boolean isEqual = true;
		int standard = map[startR][startC];

		for (int i = startR; i < startR + length; i++) {
			for (int j = startC; j < startC + length; j++) {
				if (map[i][j] != standard) {
					isEqual = false;
					return isEqual;
				}
			}
		}
		return isEqual;
	}

	static void verify(int[][] map, int startR, int startC, int[] result, int length) {

		if (length == 1) {
			int num = map[startR][startC];
			if (num == -1) {
				result[0]++;
			} else if (num == 0) {
				result[1]++;
			} else {
				result[2]++;
			}
			return;
		}

		if (!isEqual(map, startR, startC, length)) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					// i, j 0 ,0 startR = 0 startC = 0

					// i j 0 1 startR = 0 startC = 9
					// i j 1 1 startR = 9 startC = 9 // startR(0) + (27/3) * i /

					verify(map, startR + length / 3 * i, startC + length / 3 * j, result, length / 3);
				}
			}
		} else { // 다 같으면
			if (map[startR][startC] == -1) {
				result[0]++;
			} else if (map[startR][startC] == 0) {
				result[1]++;
			} else {
				result[2]++;
			}
			return;
		}

	}

}
