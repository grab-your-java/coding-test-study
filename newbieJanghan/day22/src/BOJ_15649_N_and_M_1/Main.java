package BOJ_15649_N_and_M_1;

import java.util.Scanner;

public class Main {
	static int[] numbers;
	static boolean[] visited;
	static int size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 숫자들 초기화
		numbers = new int[sc.nextInt()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}

		// 수열 크기 초기화
		size = sc.nextInt();

		// 중복을 막기 위한 방문 여부
		visited = new boolean[numbers.length];
		int[] output = new int[size];
		permutation(output, 0);

	}

	public static void permutation(int[] out, int depth) {
		if (depth == size) {
			for (int num : out) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!visited[i]) {
				// 방문 처리를 해야 다음 함수 스택에서 고려되지 않음.
				visited[i] = true;
				
				// 순열의 순번에 맞게 배열에 추가
				out[depth] = numbers[i];
				// 순열의 다음 순번에 대한 숫자 선발을 위해 depth 증가
				permutation(out, depth + 1);
				
				// 다른 숫자에서 시작하는 순열에 포함되기 위해 방문 처리 초기화.
				visited[i] = false;
			}
		}

	}
}
