package BOJ_10451;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(sc.nextLine());
		while (tc-- > 0) {
			int N = Integer.parseInt(sc.nextLine());
			int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			boolean[][] adjArr = new boolean[N + 1][N + 1];
			for (int i = 0; i < arr.length; i++) {
				adjArr[i + 1][arr[i]] = adjArr[arr[i]][i + 1] = true;
			}

			int cnt = 0;
			Queue<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[N + 1];

			for (int n = 1; n <= N; n++) {
				if (visited[n]) {
					continue;
				}

				cnt++;
				q.add(n);
				visited[n] = true;

				while (!q.isEmpty()) {
					int from = q.poll();
					for (int to = 1; to <= N; to++) {
						if (!visited[to] && adjArr[from][to]) {
							visited[to] = true;
							q.add(to);
						}
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}
