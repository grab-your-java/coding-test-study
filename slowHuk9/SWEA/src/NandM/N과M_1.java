package NandM;

import java.util.Scanner;

public class N과M_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] output = new int[M];

		boolean[] visited = new boolean[N + 1];
		int[] num = new int[N + 1];
		for (int i = 1; i < num.length; i++) {
			num[i] = i;
		}
		permutation(0, M, visited, output, num, 0);

	}

	static void permutation(int depth, int M, boolean[] visited, int[] output, int[] num, int start) {
		
		if (depth == M) {
			for (int i = 0; i < output.length; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i < visited.length; i++) {
			if (!visited[i]) {
				output[depth] = num[i];
				visited[i] =true;
				permutation(depth+1, M, visited, output, num, i+1);
				visited[i] = false;
			}
		}
	}

}
