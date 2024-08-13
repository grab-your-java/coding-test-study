package permutation_combination_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationTest {
	public static void main(String[] args) {
		int[] numbers = { 7, 3, 2, 4, 1, 5, 6 };

		Combination p = new Combination(numbers);
		List<int[]> distinct = p.distinct(2);
		for (int[] group : distinct) {
			System.out.println(Arrays.toString(group));
		}
		System.out.println("*********************");
		List<int[]> repeatible = p.repeatible(2);
		for (int[] group : repeatible) {
			System.out.println(Arrays.toString(group));
		}

	}

	static class Combination {
		int[] numbers;
		boolean[] visited;
		List<int[]> result;

		Combination(int[] numbers) {
			this.numbers = numbers;
		}

		public List<int[]> distinct(int groupSize) {
			result = new ArrayList<>();
			visited = new boolean[numbers.length];

			int[] group = new int[groupSize];
			distinct(group, 0, 0);

			return result;
		}

		private void distinct(int[] group, int depth, int start) {
			if (depth == group.length) {
				result.add(Arrays.copyOf(group, group.length));
				return;
			}

			for (int i = start; i < numbers.length; i++) {
				int number = numbers[i];
				if (!visited[i]) {
					visited[i] = true;
					group[depth] = number;
					distinct(group, depth + 1, start + 1);
					visited[i] = false;
				}
			}
		}

		public List<int[]> repeatible(int groupSize) {
			result = new ArrayList<>();

			int[] group = new int[groupSize];
			repeatible(group, 0, 0);

			return result;
		}

		private void repeatible(int[] group, int depth, int start) {
			if (depth == group.length) {
				result.add(Arrays.copyOf(group, group.length));
				return;
			}

			for (int i = start; i < numbers.length; i++) {
				int number = numbers[i];
				group[depth] = number;
				repeatible(group, depth + 1, start);
			}
		}
	}
}
