import java.util.Arrays;
import java.util.Scanner;

public class BOJ_17144 {
	static int R, C, T;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int[][] afterSpread;
	static int cleanerTop;
	static int cleanerBottom;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();

		map = new int[R][C];
		afterSpread = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int dust = sc.nextInt();
				map[i][j] = dust;
				if (dust == -1) {
					afterSpread[i][j] = dust;
					if (cleanerTop == 0) {
						cleanerTop = i;
					}
					if (cleanerTop != 0) {
						cleanerBottom = i;
					}
				}

			}
		}
		int time = 0;
		while (time != T) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) {
						spread(i, j);
					}
				}
			}
			update();// 모든 확산 후 afterSpread의 값을 map으로 업데이트
			print2();
			System.out.println();
			reset();// 임시 배열 초기화.
			cleaner();// 청정기 작동
			time++;
			print();
			System.out.println();
		}
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == -1) continue;
				result += map[i][j];
			}
		}
		System.out.println(result);
	}

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void print2() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(afterSpread[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void spread(int r, int c) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) { // 확산될 칸이 범위 안, 그리고 공기청정기가 아님.
				int spreadDust = map[r][c] / 5;
				cnt++;
				afterSpread[nr][nc] += spreadDust;
			}
		}
		int remainDust = map[r][c] - ((map[r][c] / 5) * cnt);
		afterSpread[r][c] += remainDust;
	}

	static void update() {
		// 모든 확산 후 afterSpread의 값을 map으로 업데이트
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = afterSpread[i][j];
			}
		}
	}

	static void reset() {
		for (int[] row : afterSpread) {
			Arrays.fill(row, 0);
		}
	}

	static void cleaner() {
		// 상단 공기청정기
		for (int i = cleanerTop - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		for (int i = 0; i < cleanerTop; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {
			map[cleanerTop][i] = map[cleanerTop][i - 1];
		}

		map[cleanerTop][0] = 0;
		map[cleanerTop][1] = 0;

		// 하단 공기청정기
		for (int i = cleanerBottom + 1; i < R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}
		for (int i = R - 1; i > cleanerBottom; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {
			map[cleanerBottom][i] = map[cleanerBottom][i - 1];
		}
		map[cleanerBottom][0] = 0;
		map[cleanerBottom][1] = 0;

	}
}
