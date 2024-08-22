package BOJ_15651_N_and_M_3;

import java.util.Scanner;

public class Main {
	static int[] numbers;
	static boolean[] visited;
	static int size;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		numbers = new int[sc.nextInt()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}

		size = sc.nextInt();
		int[] output = new int[size];
		permutation(output, 0);

		System.out.println(sb);
	}

	public static void permutation(int[] output, int depth) {
		if (depth == size) {
			for (int num : output) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			output[depth] = numbers[i];
			permutation(output, depth + 1);
		}

	}
}
