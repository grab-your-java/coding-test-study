import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS_BOJ_11403 {

	static int[][] map;
	static int n;
	static boolean[][] visited; // false 
	static int[][] resultmap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		map = new int[n][n];
		visited = new boolean[n][n];
		
		resultmap = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < map.length; i++) {
			dfs(i);
		}

		for (int i = 0; i < resultmap.length; i++) {
			for (int j = 0; j < resultmap.length; j++) {
				System.out.print(resultmap[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void dfs(int i, boolean[][] visited) {
		List<Integer> list = new ArrayList<>();

		if (visited[i][j]) {
			return;
		}

		for (int j = 0; j < n; j++) {
			if (map[i][j] == 1) {
				visited[i][j] = true;
				list.add(j);
				resultmap[i][j] = 1;
			}
		}

		for (int j = 0; j < list.size(); j++) {
			dfs(list.get(j), visited);
		}

	}

}
