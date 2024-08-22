package BOJ_15663_N_and_M_9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static String[] numbers;
	static int size;
	static boolean[] visited;
	static Map<String, Boolean> sequenceMap = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		numbers = new String[sc.nextInt()];
		size = sc.nextInt();
		visited = new boolean[numbers.length];
		sc.nextLine();

		String[] numInputs = sc.nextLine().split(" ");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = numInputs[i];
		}

		Arrays.sort(numbers, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));
		permutation(new String[size], 0);

		System.out.println(sb);
	}

	static void permutation(String[] output, int depth) {
		if (depth == size) {
			if (unique(output)) {
				for (String num : output) {
					sb.append(num + " ");
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = numbers[i];
				permutation(output, depth + 1);
				visited[i] = false;
			}
		}
	}

	static boolean unique(String[] sequence) {
		String key = "";
		for (String num : sequence) {
			key += num + "-";
		}

		Boolean exist = sequenceMap.get(key);
		if (exist == null) {
			sequenceMap.put(key, true);
			return true;
		} else {
			return !exist;
		}
	}
}
