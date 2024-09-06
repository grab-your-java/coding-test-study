import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17471_5 {
	static int[][] adj;
	static boolean[] visited;
	static int N;
	static int[] population;
	static int[] cityNum;
	static List<Integer> team1 = new ArrayList<>();
	static List<Integer> team2 = new ArrayList<>();
	static int min;
	static boolean connected1, connected2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		population = new int[N + 1];
		cityNum = new int[N + 1];
		for (int i = 1; i < cityNum.length; i++) {
			cityNum[i] = i;
		}
		min = Integer.MAX_VALUE;
		adj = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i < population.length; i++) {
			population[i] = sc.nextInt();
		} // 인구 수 입력 끝

		for (int i = 1; i < N + 1; i++) {
			int E = sc.nextInt();
			for (int j = 0; j < E; j++) {
				int from = i;
				int to = sc.nextInt();
				adj[from][to] = adj[to][from] = 1;
			}
		}
		for (int i = 1; i <= N / 2; i++) {

			subset(0, 1, i);
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static void subset(int depth, int start, int size) {
		if (depth == size) {
			team2.clear();
			for (int i = 1; i < N + 1; i++) {
				if (!visited[i])
					team2.add(i);
			}
			team1Valid();
			team2Valid();
			if (connected1 && connected2) {
				// 인구수 계산하기
				min = Math.min(calculation(), min);
			}
			return;
		}
		for (int i = start; i < N + 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				team1.add(i);
				subset(depth + 1, i + 1, size);
				visited[i] = false;
				team1.remove(team1.size() - 1);
			}

		}

	}

	static void team1Valid() {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(team1.get(0));
		visited[team1.get(0)] = true;
		int count = 1;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (adj[current][i] == 1 && !visited[i] && team1.contains(i)) {
					queue.add(i);
					visited[i] = true;
					count++;
				}
			}
		}
		if (count == team1.size()) {
			connected1 = true;
		} else {
			connected1 = false;
		}
	}

	static void team2Valid() {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(team2.get(0));
		visited[team2.get(0)] = true;
		int count = 1;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (adj[current][i] == 1 && !visited[i] && team2.contains(i)) {
					queue.add(i);
					visited[i] = true;
					count++;
				}
			}
		}
		if (count == team2.size()) {
			connected2 = true;
		} else {
			connected2 = false;
		}
	}

	static int calculation() {
		int population1 = 0;
		int population2 = 0;

		for (int i = 0; i < team1.size(); i++) {
			population1 += population[team1.get(i)];
		}
		for (int i = 0; i < team2.size(); i++) {
			population2 += population[team2.get(i)];
		}
		int diff = Math.abs(population1 - population2);
		return diff;

	}

}
