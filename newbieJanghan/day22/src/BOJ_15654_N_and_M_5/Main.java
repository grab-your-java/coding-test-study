package BOJ_15654_N_and_M_5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] numbers;
	static boolean[] visited;
	static int size;
	static StringBuilder sb = new StringBuilder();

	/**
	 * Conditions
	 * 1. distinct
	 * 2. ascending
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// input
		numbers = new int[sc.nextInt()];
		size = sc.nextInt();

		sc.nextLine(); // 개행 입력 스킵
		String[] numInputs = sc.nextLine().split(" ");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(numInputs[i]);
		}
		/**
		 * Key 2. 미리 정렬해두어 오름차순으로 수열이 생성될 수 있다.
		 */
		Arrays.sort(numbers);

		/**
		 * Key 1. 중복을 방지하기 위해 방문 여부 저장
		 */
		visited = new boolean[numbers.length];
		int[] output = new int[size];
		permutation(output, 0);

		System.out.println(sb);

	}

	public static void permutation(int[] out, int depth) {
		if (depth == size) {
			for (int num : out) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;

				out[depth] = numbers[i];
				permutation(out, depth + 1);

				visited[i] = false;
			}
		}

	}
}
