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
		
		dfs(0);
		
		for (int i = 0; i < resultmap.length; i++) {
			for (int j = 0; j < resultmap.length; j++) {
				System.out.print(resultmap[i][j] + " ");
			}System.out.println();
		}

	}

	static void dfs(int i) {
		List<Integer> list = new ArrayList<>();
		for (int j = 0; j < n; j++) {
			if (map[i][j] == 1) {
				list.add(j);
				resultmap[i][j] = 1;
			}
		}

		if (i == n-1) {
			return;
		}

		for (int j = 0; j < list.size(); j++) {
			dfs(list.get(j));
		}

	}

}
