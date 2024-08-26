package BOJ_15650_N_and_M_2;

import java.util.Scanner;

public class Main {
	static int[] numbers;
	static boolean[] visited;
	static int size;

	/**
	 * Constraint 1: 수열은 오름차순이어야 한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/**
		 * Key 1: 순회 대상 배열을 오름차순으로 초기화
		 */
		numbers = new int[sc.nextInt()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}

		size = sc.nextInt();
		visited = new boolean[numbers.length];

		combination(0, 0);

	}

	public static void combination(int depth, int start) {
		if (depth == size) {
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					System.out.print(numbers[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		/**
		 * Key 1: 조합. 콜 스택 상에서 순회 시작 인덱스가 1씩 증가하여 수열 안의 숫자가 자동으로 순회 대상의 정렬을 유지하게 됨.
		 */
		for (int i = start; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;

				combination(depth + 1, i + 1);

				visited[i] = false;
			}
		}

	}
}
