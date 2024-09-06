import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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
		population = new int[7];
		cityNum = new int[7];
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
		System.out.println(min);

		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void subset(int depth, int start, int size) {
		if (depth == size) {
			team2.clear();
			for (int i = 1; i < N + 1; i++) {
				if (!visited[i])
					team2.add(i);
			}
			System.out.println("team1 = " + team1 + " team2 = " + team2);
			team1Valid();
			team2Valid();
			if (connected1 && connected2) {
				System.out.println("!!!!!!!!!!!!!!!!allTrue!!!!!!!!!!!!!!");
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
		connected1 = true;

		System.out.println("팀1 사이즈 = " + team1.size());
		int cnt = 0;
		for (int i = 0; i < team1.size() - 1; i++) {
			if (adj[team1.get(i)][team1.get(i + 1)] == 0) {
				connected1 = false;
				break;
			} else {
				cnt++;
				if (cnt == team1.size()) {
					connected1 = true;
				}
			}
		}
		System.out.println("팀 1은 이어져 있는가 => " + connected1);
	}

	static void team2Valid() {
		connected2 = true;
		System.out.println("팀2 사이즈 = " + team2.size());
		int cnt = 0;
		for (int i = 0; i < team2.size() - 1; i++) {
			if (adj[team2.get(i)][team2.get(i + 1)] == 0) {
				connected2 = false;
				break;
			} else {
				cnt++;
				if (cnt == team1.size()) {
					connected2 = true;
				}
			}
		}
		System.out.println("팀 2은 이어져 있는가 => " + connected2);
		System.out.println("_____________________________________");
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
