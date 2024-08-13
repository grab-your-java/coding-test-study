import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BFS_BOJ_2178_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		int[][] maze = new int[n][m];
		boolean[][] visited = new boolean[n][m]; // 초기값 false

		for (int x = 0; x < maze.length; x++) {
			String s = sc.next();
			for (int y = 0; y < maze[x].length; y++) {
				maze[x][y] = s.charAt(y) - '0';
			}
		}

		Queue<int[]> queue = new ArrayDeque<>();
		
		int[] firstXY = { 0, 0 };

		queue.add(firstXY);
		visited[0][0] = true;

		while (!queue.isEmpty()) {

			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];

			if (currentX == n - 1 && currentY == m - 1) {
				System.out.println(maze[currentX][currentY]);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];

				if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && visited[nextX][nextY] == false
						&& maze[nextX][nextY] == 1) {
					queue.add(new int[] { nextX, nextY });
					visited[nextX][nextY] = true;
					maze[nextX][nextY] = maze[currentX][currentY] + 1;
				}

			}

		}
		System.out.println(-1);
	}
}