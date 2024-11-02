package NandM;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int[] num = new int[N + 1];
		int[] output = new int[M];

		for (int i = 1; i < num.length; i++) {
			num[i] = sc.nextInt();
		}

		Arrays.sort(num);
		permutation(0, M, num, output, 1, sb);
		System.out.println(sb.toString());
	}

	static void permutation(int depth, int M, int[] num, int[] output, int start, StringBuilder sb) {
		if (depth == M) {
			for (int i : output) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < num.length; i++) {
			output[depth] = num[i];
			permutation(depth + 1, M, num, output, i, sb);
		}
	}

}
