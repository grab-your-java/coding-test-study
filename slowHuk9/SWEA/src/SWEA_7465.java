import java.util.Scanner;

public class SWEA_7465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt(); // 정점의 개수
			int E = sc.nextInt(); // 간선의 개수

			int[][] adj = new int[V + 1][V + 1];
			boolean[] visited = new boolean[V + 1];

			int from, to;
			for (int i = 0; i < E; i++) {
				from = sc.nextInt();
				to = sc.nextInt();
				adj[from][to] = adj[to][from] = 1;
			} // 간선 입력 끝

			int result = 0;
			for (int i = 1; i <= V; i++) {
				if (!visited[i]) {
					dfs(i, V, E, visited, adj);
					result++;
				}
			}
			System.out.println("#" + tc+ " " + result);
		}
	}

	static void dfs(int from, int V, int E, boolean[] visited, int[][] adj) {
		if (visited[from]) {
			return;
		}
		visited[from] = true;
		for (int to = 1; to <= V; to++) {
			if (adj[from][to] == 1) {
				dfs(to, V, E, visited, adj);
			}
		}
	}

}