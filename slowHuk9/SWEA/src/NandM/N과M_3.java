package NandM;

import java.util.Scanner;

public class N과M_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] num = new int[N + 1];
		int[] output = new int[M];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < num.length; i++) {
			num[i] = i;
		}
		permutation(0, output, num, M, sb);
		System.out.println(sb.toString());
	}

	static void permutation(int depth, int[] output, int[] num, int M, StringBuilder sb) {
		if (depth == M) {
			for (int i : output) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i < num.length; i++) {
			output[depth] = num[i];
			permutation(depth + 1, output, num, M, sb);
		}
	}

}
