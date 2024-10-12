import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1953_2 {

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
			visited = new boolean[N][M];

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

			for (boolean[] row: visited) {
				System.out.println(Arrays.toString(row));
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

	static void bfs(int startR, int startC, List<Integer>[] pipe) {
		int r = startR;
		int c = startC;
		Queue<Integer> queue = new LinkedList<>();
		visited[r][c] = true;
		for (int i = 0; i < pipe[map[r][c]].size(); i++) {
			queue.add(pipe[map[r][c]].get(i));
		}
		int time = 1;
		int tmp = 0;
		while (!queue.isEmpty()) {
			System.out.println("!"+ queue);
			if (time == L)
				break;
			int currDir = queue.poll();
			int nr = r + dr[currDir];
			int nc = c + dc[currDir];
			tmp ++;
			if(tmp == pipe[map[r][c]].size()) {
				time ++;
				tmp = 0;
			}

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0) {
				if (currDir == 1 && pipe[map[nr][nc]].contains(2) || (currDir == 2 && pipe[map[nr][nc]].contains(1))
						|| (currDir == 3 && pipe[map[nr][nc]].contains(4))
						|| (currDir == 4 && pipe[map[nr][nc]].contains(3))) {
					visited[nr][nc] = true;
					for (int i = 0; i < pipe[map[nr][nc]].size(); i++) {
						queue.add(pipe[map[nr][nc]].get(i));
					}
				}
			}
		}
	}

}
