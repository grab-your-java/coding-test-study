import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1953_3 {

	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };
	static int[][] map;
	static int N, M, L;
	static int cnt;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 맵 세로
			M = sc.nextInt(); // 맵 가로
			int R = sc.nextInt(); // 맨홀 r좌표
			int C = sc.nextInt(); // 맨홀 c 좌표
			L = sc.nextInt(); // 시간

			map = new int[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			List<Integer>[] pipe = new ArrayList[8];
			for (int i = 0; i < pipe.length; i++) {
				pipe[i] = new ArrayList<>();
			}
			pipe[1].add(1);
			pipe[1].add(2);
			pipe[1].add(3);
			pipe[1].add(4);

			pipe[2].add(1);
			pipe[2].add(2);

			pipe[3].add(3);
			pipe[3].add(4);

			pipe[4].add(1);
			pipe[4].add(4);

			pipe[5].add(2);
			pipe[5].add(4);

			pipe[6].add(2);
			pipe[6].add(3);

			pipe[7].add(1);
			pipe[7].add(3);

			bfs(R, C, pipe);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j])
						cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);

		}
	}

	static void bfs(int startR, int startC, List<Integer>[] pipe) {
		int r = startR;
		int c = startC;
		int time = 1;
		cnt = 0;
		visited = new boolean[N][M];

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c, time });
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currR = curr[0];
			int currC = curr[1];
			int round = curr[2];
			if (round == L) {
				break;
			}
			int nr = 0;
			int nc = 0;
			for (int i = 0; i < pipe[map[currR][currC]].size(); i++) {
				nr = currR + dr[pipe[map[currR][currC]].get(i)];
				nc = currC + dc[pipe[map[currR][currC]].get(i)];
//				System.out.println("i" + i + " " + currR + "," + currC + " round:" + round);

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0) {
					if (!visited[nr][nc] && pipe[map[currR][currC]].get(i) == 1 && pipe[map[nr][nc]].contains(2)
							|| (pipe[map[currR][currC]].get(i) == 2 && pipe[map[nr][nc]].contains(1))
							|| (pipe[map[currR][currC]].get(i) == 3 && pipe[map[nr][nc]].contains(4))
							|| (pipe[map[currR][currC]].get(i) == 4 && pipe[map[nr][nc]].contains(3))
							) {
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc, round + 1 });
					}
				}
			}
		}

	}
}
