package BOJ_15655_N_and_M_6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] numbers;
	static int size;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		numbers = new int[sc.nextInt()];
		size = sc.nextInt();
		sc.nextLine();

		String[] inputs = sc.nextLine().split(" ");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(inputs[i]);
		}

		Arrays.sort(numbers);

		int[] output = new int[size];
		combination(output, 0, 0);

		System.out.println(sb);
	}

	static void combination(int[] output, int depth, int start) {
		if (depth == size) {
			for (int num : output) {
				sb.append(num + " ");
			}
			sb.append("\n");
			
			return;
		}

		for (int i = start; i < numbers.length; i++) {
			output[depth] = numbers[i];
			combination(output, depth + 1, i + 1);
		}
	}
}
