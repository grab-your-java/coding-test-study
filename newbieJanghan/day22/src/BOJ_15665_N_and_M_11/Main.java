package BOJ_15665_N_and_M_11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static String[] numbers;
	static int size;
	static Map<String, Boolean> sequenceMap = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size = Integer.parseInt(sc.nextLine().split(" ")[1]);
		numbers = sc.nextLine().split(" ");

		Arrays.sort(numbers, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));

		permutation(new String[size], 0);
		System.out.println(sb);
	}

	static void permutation(String[] sequence, int depth) {
		if (depth == size) {
			if (unique(sequence)) {
				for (String num : sequence) {
					sb.append(num + " ");
				}
				sb.append("\n");
			}

			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			sequence[depth] = numbers[i];
			permutation(sequence, depth + 1);
		}
	}

	static boolean unique(String[] sequence) {
		String key = "";
		for (String string : sequence) {
			key += string + "-";
		}

		boolean exist = sequenceMap.computeIfAbsent(key, (k) -> false);
		if (!exist) {
			sequenceMap.put(key, true);
		}

		return !exist;
	}
}
