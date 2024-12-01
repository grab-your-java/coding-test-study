import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_10451 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			boolean[] visited = new boolean[N + 1];
			int[][] adj = new int[N + 1][N + 1];

			for (int i = 1; i < adj.length; i++) {
				int from = i;
				int to = sc.nextInt();
				adj[from][to] = 1;
			}
			
//			for (int i = 1; i < adj.length; i++) {
//				for (int j = 1; j < adj.length; j++) {
//					System.out.print(adj[i][j]);
//				}
//				System.out.println();
//			}

			Queue<Integer> queue = new ArrayDeque<Integer>();
			int result = 0;
			for (int i = 1; i < visited.length; i++) {
				if (visited[i]) {
					continue;
				}
				queue.add(i);
				while (!queue.isEmpty()) {
					int curr = queue.poll();
					visited[curr] = true;
					for (int j = 1; j < adj.length; j++) {
						if (!visited[j] && adj[curr][j] == 1) {
							queue.add(j);
						}
					}
				}
				result ++;
			}
			System.out.println(result);

		}
	}

}
