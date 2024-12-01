import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10819 {
	static int max = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] num = new int[N];

		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}

		int[] output = new int[N];
		boolean[] visited = new boolean[N];
		solve(num, output, 0, visited);
		System.out.println(max);

	}

	static void solve(int[] num, int[] output, int depth, boolean[] visited) {
		if (depth == num.length) {
			max = Math.max(max, calculation(output));
		}
		for (int i = 0; i < output.length; i++) {
			if (!visited[i]) {
				output[depth] = num[i];
				visited[i] = true;
				solve(num, output, depth + 1, visited);
				visited[i] = false;
			}
		}
	}

	static int calculation(int[] output) {
		int sum = 0;
		for (int i = 0; i < output.length - 1; i++) {
			int result = Math.abs(output[i] - output[i + 1]);
			sum += result;
		}
		return sum;
	}

}
