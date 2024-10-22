package BOJ_10819;

import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int N, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		visited = new boolean[N];
		for (int i=0; i<N; i++) {
			visited[i] = true;
			dfs(1, 0, i);
			visited[i] = false;
		}

		System.out.println(answer);
	}

	static void dfs(int round, int sum, int beforeIdx) {
		if (round == N) {
			answer = Math.max(answer, sum);
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(round + 1, sum + Math.abs(arr[beforeIdx] - arr[i]), i);
				visited[i] = false;
			}
		}
	}
}
