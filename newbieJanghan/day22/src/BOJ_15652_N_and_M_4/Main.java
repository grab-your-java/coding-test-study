package BOJ_15652_N_and_M_4;

import java.util.Scanner;

public class Main {
	static int[] numbers;
	static boolean[] visited;
	static int size;
	static StringBuilder sb = new StringBuilder();

	/**
	 * Constraint 1: 중복이 가능하다. Constraint 2: 수열은 비내림차순이어야 한다. => 중복조합
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/**
		 * Key 2: 순회 대상 배열을 오름차순으로 초기화
		 */
		numbers = new int[sc.nextInt()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}

		size = sc.nextInt();
		int[] output = new int[size];

		combination(output, 0, 0);
		System.out.println(sb);
	}

	public static void combination(int[] output, int depth, int start) {
		if (depth == size) {
			for (int num : output) {
				sb.append(num + " ");
			}
			sb.append("\n");

			return;
		}

		/**
		 * Key 2: 이미 오름차순으로 정렬된 배열을 순회하고, 증가된 depth 에 따라 순열을 채움으로써 오름차순 적용.
		 */
		for (int i = start; i < numbers.length; i++) {
			output[depth] = numbers[i];
			/**
			 * Key 1: 중복된 수도 조회할 수 있도록 i 값을 그대로 콜스택에 추가 비내림차순 적용.
			 */
			combination(output, depth + 1, i);
		}

	}
}
