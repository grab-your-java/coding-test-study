package BOJ_11403_경로찾기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodeCount = sc.nextInt();

		int[][] graph = new int[nodeCount][nodeCount];
		for (int i = 0; i < nodeCount; i++) {
			for (int j = 0; j < nodeCount; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < nodeCount; i++) {

			NextPath: for (int j = 0; j < nodeCount; j++) {
				Queue<Integer> q = new LinkedList<>();
				boolean[] visited = new boolean[nodeCount];
				q.add(i);

				while (!q.isEmpty()) {
					Integer node = q.poll();
					visited[node] = true;
					for (int next = 0; next < nodeCount; next++) {
						if (graph[node][next] == 0) {
							continue;
						}

						if (next == j) {
							System.out.print("1 ");
							continue NextPath;
						} else if (!visited[next]) {
							q.add(next);
						}
					}
				}

				System.out.print("0 ");
			}
			System.out.println();
		}

	}
}
