import java.util.Arrays;
import java.util.Scanner;

public class BOJ_17471 {
	static int[][] floyd;
	static int[] population;
	static int N;
	static int R;
	static int[] team1;
	static int[] team2;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = N / 2; // nCr 중에서 가장 큰 nCr // 6C3, 10C5
		// nC1 ~ nCR 까지 구해야함.

		visited = new boolean[N + 1];
		team1 = new int[R]; // 선거구 1
		team2 = new int[R]; // 선거구 2

		population = new int[N + 1];
		for (int i = 1; i < population.length; i++) {
			population[i] = sc.nextInt();
		}
		floyd = new int[N + 1][N + 1];
		for (int i = 1; i <= R; i++) {
			combination(0, 1, i);
			System.out.println("______________________________");
		}
		

		for (int i = 1; i < floyd.length; i++) {
			int neighborCnt = sc.nextInt();
			for (int j = 0; j < neighborCnt; j++) {
				int neighborArea = sc.nextInt();
				floyd[i][neighborArea] = 1;
			}
		}

		for (int i = 1; i < floyd.length; i++) {
			for (int j = 1; j < floyd.length; j++) {
				System.out.print(floyd[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void combination(int depth, int start, int limit) {
		if (depth == limit) {
			int idx = 0;
			for (int i = 1; i < visited.length; i++) {
				if (!visited[i])
					team2[idx++] = i;
			}
			System.out.println("team1 : " + Arrays.toString(team1));
			System.out.println("team2 : " + Arrays.toString(team2));
			System.out.println(Arrays.toString(visited));
			return;
		}
		for (int i = start; i <= N; i++) {
			if (!visited[i]) {
				team1[depth] = i;
				visited[i] = true;
			}
			combination(depth + 1, i + 1, limit);
			visited[i] = false;
		}

	}
}
