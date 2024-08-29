
import java.util.Scanner;

public class SWEA_4014 {
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
			System.out.println("#" + test_case + " " + result);

		}
	}

	static void checkRow() {
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (Math.abs(map[i][j] - map[i][j + 1]) >= 2) {
					rowValid[i] = false;
					break; // 2칸 이상 차이나면 다음 행으로
				}
				if (map[i][j] == map[i][j + 1]) {
					cnt++;
					if (cnt == N) {
						rowValid[i] = true;
					}
					continue;
				}
				if (map[i][j] - map[i][j + 1] == -1) { // 오르막
					if (cnt < X) {
						rowValid[i] = false;
						break;
					} else if (cnt >= X) {
						if (!(rowVisited[i][j - X + 1]) && !(rowVisited[i][j])) { // 중복제거
							rowValid[i] = true;
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

					cnt = 0;
					int k = 1;
					if (N - j - 1 < X) { // 내리막을 건설할 만큼의 남은 칸이 없다면
						rowValid[i] = false;
						break;
					}
					while (k <= X) {
						if (map[i][j + k] == map[i][j] - 1) {
							cnt++;
						}
						k++;
					}
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
		}
	}

	static void checkCol() {

		for (int j = 0; j < N; j++) {
			int cnt = 1;
			for (int i = 0; i < N - 1; i++) {
				if (Math.abs(map[i][j] - map[i + 1][j]) >= 2) {
					colValid[j] = false;
					break; // 2칸 이상 차이나면 다음 행으로
				}
				if (map[i][j] == map[i + 1][j]) {
					cnt++;
					if (cnt == N) {
						colValid[j] = true;
					}
					continue;
				}
				if (map[i][j] - map[i + 1][j] == -1) { // 오르막
					if (cnt < X) {
						colValid[j] = false;
						break;
					} else if (cnt >= X) {
						if (!(colVisited[i - X + 1][j]) && !(colVisited[i][j])) { // 중복제거
							colValid[j] = true;
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

					cnt = 0;
					int k = 1;
					if (N - i - 1 < X) { // 내리막을 건설할 만큼의 남은 칸이 없다면
						colValid[j] = false;
						break;
					}
					while (k <= X) {
						if (map[i + k][j] == map[i][j] - 1) {
							cnt++;
						}
						k++;
					}
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
		}
	}
}
