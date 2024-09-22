import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11724 {
	static int N, M;
	static int[][] adj;
	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 수
		M = sc.nextInt(); // 간선의 수
		visited = new boolean[N + 1];
		adj = new int[N + 1][N + 1];
		int from, to;
		for (int i = 0; i < M; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			adj[from][to] = adj[to][from] = 1;
		}
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}

	static void dfs(int from) {
		if (visited[from]) {
			return;
		}
		visited[from] = true;
		for (int to = 1; to <= N; to++) {
			if (adj[from][to] == 1) {
				dfs(to);
			}
		}
	}

}
