package NandM;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] num = new int[N + 1];
		int[] output = new int[M];

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < num.length; i++) {
			num[i] = sc.nextInt();
		}

		Arrays.sort(num);
		permutation(0, M, output, num, sb);
		System.out.println(sb.toString());

	}

	static void permutation(int depth, int M, int[] output, int[] num, StringBuilder sb) {
		if (depth == M) {
			for (int i : output) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i < num.length; i++) {
			output[depth] = num[i];
			permutation(depth + 1, M, output, num, sb);
		}
	}

}
