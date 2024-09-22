import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_17471_2 {
	static class Edge {
		int A, B, W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] population = new int[7];

		for (int i = 1; i < population.length; i++) {
			population[i] = sc.nextInt();
		} // 인구 수 입력 끝
		List<Edge>[] edges = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 1; i < N + 1; i++) {
			int E = sc.nextInt();
			for (int j = 0; j < E; j++) {
				int from = i;
				int to = sc.nextInt();
				int w = 1;
				edges[i].add(new Edge(from, to, w));
			}
		}

	}
}
