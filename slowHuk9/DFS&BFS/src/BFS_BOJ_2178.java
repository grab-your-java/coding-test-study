import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BFS_BOJ_2178 {
	static int n;
	static int m;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int[][] maze;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		maze = new int[n][m];
		visited = new boolean[n][m];

		for (int x = 0; x < maze.length; x++) {
			String s = sc.next();
			for (int y = 0; y < maze[x].length; y++) {
				maze[x][y] = s.charAt(y) - '0';
			}
		}

//		for (int x = 0; x < maze.length; x++) {
//			for (int y = 0; y < maze[x].length; y++) {
//				System.out.print(maze[x][y] + " ");
//			}
//			System.out.println();
//		}

		int result = bfs(0, 0);
		System.out.println(result);

	}

	static int bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		int[] firstXY = {x,y};
		queue.add(firstXY);
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currX = current[0];
			int currY = current[1];

			if (currX == n - 1 && currY == m - 1) {
				return maze[currX][currY];
			}

			for (int i = 0; i < 4; i++) {
				int nextX = currX + dx[i];
				int nextY = currY + dy[i];

				if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && visited[nextX][nextY] == false
						&& maze[nextX][nextY] == 1) {
					queue.add(new int[] { nextX, nextY });
					visited[nextX][nextY] = true;
					maze[nextX][nextY] = maze[currX][currY] + 1;
				}
			}

		}
		return -1;

	}
}
