import java.util.Scanner;

public class SWEA_4615 {
	static int[][] map;
	static int T;
	static int N;
	static int M;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 북, 북동, 동, 동남, 남 , 남서, 서, 북서,
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			// N이 4일때 1,1 1,2, 2,1, 2,2, 에 배치하고 시작
			// N이 6일때 2,2 2,3, 3,2 3,3 에 배치하고 시작
			// N이 8일때 3,3, 3,4, 4,3, 4,4에 배치
			// N/2 - 1, N/2 - 1 ~ N/2,N/2 까지
			// N/2-1 , N/2-1 괴 N/2, N/2는 백돌 N/2-1, N/2 N/2, N/2-1 은 흑돌
			map[N / 2 - 1][N / 2 - 1] = 2;
			map[N / 2][N / 2] = 2;
			map[N / 2 - 1][N / 2] = 1;
			map[N / 2][N / 2 - 1] = 1;

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				int stoneColor = sc.nextInt();
				dfs(y, x, stoneColor);
			}

			int bCnt = 0;
			int wCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1)
						bCnt++;
					if (map[i][j] == 2)
						wCnt++;
				}
			}

			System.out.println("#" + test_case + " " + bCnt + " " + wCnt);

		}
	} // 1,2 = 2,1 --> 2-1 , 1-0

	static void dfs(int x, int y, int stoneColor) {
		map[x][y] = stoneColor; // 배치하기.

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			boolean canFlip = false;
			int cnt = 0;
			while (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 0) {
				if (map[nx][ny] != stoneColor) {// 다른 색의 돌이 나오면
					nx += dx[i];
				    ny += dy[i];
                    canFlip = true;
					cnt++;
				} else { // 같은 색의 돌이 나올때
					if (canFlip == true) { // 같은색의 돌이 나왔지만 canFlip == true라면 카운트 갯수만큼 뒤집어준다.
						for (int j = 1; j <= cnt; j++) {
							int targetX = x + dx[i] * j;
							int targetY = y + dy[i] * j;
							map[targetX][targetY] = stoneColor;
						}
                        break;
					} else
						break; // 배치한 돌 바로 다음에 같은 색의 돌일때
				}
				

			}
		}

	}
}
