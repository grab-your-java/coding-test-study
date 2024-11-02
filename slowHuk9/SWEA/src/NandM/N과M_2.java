package NandM;

import java.util.Scanner;

public class N과M_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		boolean[] visited = new boolean[N + 1];
		int[] output = new int[M];
		int[] num = new int[N + 1];
		for (int i = 1; i < num.length; i++) {
			num[i] = i;
		}
		permutation(0, 1, visited, output, num, M);

	}

	static void permutation(int depth, int start, boolean[] visited, int[] output, int[] num, int M) {
		if (depth == M) {
			for (int i = 0; i < output.length; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < visited.length; i++) {
			if (!visited[i]) {
				output[depth] = num[i];
				visited[i] = true;
				permutation(depth + 1, i + 1, visited, output, num, M);
				visited[i] = false;
			}
		}
	}

}
