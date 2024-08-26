package BOJ_2178_미로탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// up down left right
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] graph = new int[N][M];
		int[][] distances = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] chars = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				// graph 에 이동 여부 저장. 이동할 때마다 길이 추가되어야 하므로 숫자 1로 저장.
				graph[i][j] = Character.getNumericValue(chars[j]);
				// 탐색 중인 최소 칸수를 저장해야하기 때문에 모든 칸을 최대 값으로 초기화
				distances[i][j] = Integer.MAX_VALUE;
			}
		}

		boolean[][] visited = new boolean[N][M];
		
		Queue<Integer[]> q = new LinkedList<>();
		// 탐색 초기값 설정
		q.add(new Integer[] { 0, 0 });
		distances[0][0] = graph[0][0];

		while (!q.isEmpty()) {
			Integer[] coordinate = q.poll();
			int y = coordinate[0];
			int x = coordinate[1];
			int curDist = distances[y][x];

			// 네 방향을 탐색하면서 
			// 1. 누적된 길이가 최소 값인 경우 갱신
			// 2. 방문 처리
			// 3. 다음 경로 탐색을 위한 queueing!
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || graph[ny][nx] == 0) {
					continue;
				}

				int newDistance = curDist + graph[ny][nx];
				if (!visited[ny][nx] && distances[ny][nx] > newDistance) {
					q.add(new Integer[] { ny, nx });
					distances[ny][nx] = newDistance;
					visited[ny][nx] = true;
				}
			}
		}

		System.out.println(distances[N - 1][M - 1]);
	}
}
