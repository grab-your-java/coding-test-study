import java.util.Scanner;

public class BOJ_1012 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dc = { 0, 0, -1, 1 };
	static int result;
	static int width, height;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			 width = sc.nextInt();
			 height = sc.nextInt();
			int baechu = sc.nextInt();
			result = 0;

			map = new int[height][width];
			visited = new boolean[height][width];
			for (int i = 0; i < baechu; i++) {
				int x = sc.nextInt(); // 좌표평면의 x
				int y = sc.nextInt(); // 좌표평면의 y
				map[y][x] = 1;
			}
			warm();
			System.out.println(result);

		}
	}
	static void warm() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					dfs(i, j);
					result++;
				}
			}
		}
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int i = 0; i < dc.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < height && nc >= 0 && nc < width && map[nr][nc] == 1 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}

	}

}
