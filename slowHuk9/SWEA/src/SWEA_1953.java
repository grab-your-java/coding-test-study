import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1953 {

	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };
	static int[][] map;
	static int N, M, L;

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

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
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
		}
	}

	static void bfs(int startR, int startC, List<Integer>[] pipe) {
		int r = startR;
		int c = startC;
		Queue<Integer> queue = new LinkedList<>();
		switch (map[r][c]) {
		case 1:
			for (int i = 0; i < pipe[map[r][c]].size(); i++) {
				queue.add(pipe[map[r][c]].get(i));
			}
			break;
		case 2:
			queue.add(1);
			queue.add(2);
			break;
		case 3:
			queue.add(3);
			queue.add(4);
			break;
		case 4:
			queue.add(1);
			queue.add(4);
			break;
		case 5:
			queue.add(2);
			queue.add(4);
			break;
		case 6:
			queue.add(2);
			queue.add(3);
			break;

		default:
			queue.add(1);
			queue.add(3);
			break;
		}
		int time = 1;
		int cnt = 1;
		while (!queue.isEmpty()) {
			if (time == L)
				break;
			int currDir = queue.poll();
			int nr = r + dr[currDir];
			int nc = c + dc[currDir];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0) {
				cnt++;
				switch (map[nr][nc]) {
				case 1:
					queue.add(1);
					queue.add(2);
					queue.add(3);
					queue.add(4);
					break;
				case 2:
					queue.add(1);
					queue.add(2);
					break;
				case 3:
					queue.add(3);
					queue.add(4);
					break;
				case 4:
					queue.add(1);
					queue.add(4);
					break;
				case 5:
					queue.add(2);
					queue.add(4);
					break;
				case 6:
					queue.add(2);
					queue.add(3);
					break;

				default:
					queue.add(1);
					queue.add(3);
					break;
				}

			}
		}
	}

}
