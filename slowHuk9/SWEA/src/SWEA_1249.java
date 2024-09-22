import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1249 {
	static int N;
	static int[][] map;
	static boolean[][] remained;
	static int[][] dijkstra;

	static int[] dx = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new int[N][N];
			remained = new boolean[N][N];
			dijkstra = new int[N][N];

			for (int i = 0; i < map.length; i++) {
				String s = sc.next();
				for (int j = 0; j < map.length; j++) {
					map[i][j] = s.charAt(j) - '0';
					dijkstra[i][j] = 90000;
				}
			}
			int result = bfs();
			System.out.println("#" + test_case + " " +result);
		}
	}

	static int bfs() {
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> map[b[0]][b[1]] - map[a[0]][a[1]]);
		int x = 0;
		int y = 0;
		queue.add(new int[] { x, y });
		remained[x][y] = true;
		dijkstra[0][0] = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			
			int currX = current[0];
			int currY = current[1];
			int currPrice = dijkstra[currX][currY];
			remained[currX][currY] = false;
			
//			System.out.println("currX : " + currX);
//			System.out.println("currY : " + currY);
//			System.out.println("currPrice : " + currPrice);
			
			for (int i = 0; i < 4; i++) {
				int nx = currX + dx[i];
				int ny = currY + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
//					System.out.println("nx , ny "+ nx + " " + ny +"|||||| map[nx][ny] : " + map[nx][ny]);
					int newPrice = currPrice + map[nx][ny];
					if (newPrice < dijkstra[nx][ny]) {
						dijkstra[nx][ny] = newPrice;
						queue.add(new int[] { nx, ny });
						remained[nx][ny] = true;
					}
				}
			}

		}

		return dijkstra[N - 1][N - 1];

	}

}


/*
 * 1. 큐를 생성하고
 * 2. 처음 시작할 요소들을 담은 배열 queue에 추가하고
 * 3. 해당 큐에서 꺼내서 해당 좌표를 갔을 때, 처리해야할 로직을 실행하고
 * 4. 로직 실행 후 , 다음 좌표도 범위 안에 있다면 (처리해야할 범위 ,map의 범위 안에 있다면)
 * 5. 그 다음 좌표를 가진 배열을 2번 처럼 추가 하고 2~5까지 반복한다.
 * 6. queue가 비었을 때  // 결국 더 탐색할 게 없다. .--> 탐색 끝 
 * 7. 최소치를 갱신했으니까 탐색이 끝난 좌표의 값에는 최소치가 있다.*/
