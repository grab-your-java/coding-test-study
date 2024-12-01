import java.util.Arrays;
import java.util.Scanner;

// 설계
// 각 점원들의 키의 부분 집합을 구한다.
// 부분 집합의 합이 목표 targetH 보다 커야한다.
// 큰 애들 중 가장 작은 합을 구한다.
public class SWEA_1486 {
	static int[] heights;
	static boolean[] visited;
	static int[] output;
	static int N;
	static int targetH;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 사람의 수
			targetH = sc.nextInt(); // 가장 높은 선반 높이
			output = new int[N];
			heights = new int[N + 1];
			min = Integer.MAX_VALUE;
			for (int i = 1; i < N + 1; i++) {
				heights[i] = sc.nextInt(); // 직원들의 키
			}
			visited = new boolean[N + 1]; // 중복 췍 배열
			buildUp(0, 1, 0);
			System.out.println("#" + tc + " " + (min - targetH));
		}
	}

	static void buildUp(int depth, int start, int sum) {
		// 기저조건
		if (sum >= targetH) {
			min = Math.min(min, sum);
			return;
		}

		if (depth == N) {
			return;
		}
		// 재귀
		for (int i = start; i < N + 1; i++) {
			if (!visited[i]) {
				output[depth] = heights[i];
				visited[i] = true;
				buildUp(depth + 1, i + 1, sum + heights[i]);
				visited[i] = false;
			}
		}
	}

}