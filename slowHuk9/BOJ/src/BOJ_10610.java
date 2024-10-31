import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10610 {
	static long max = -2;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int number = Integer.parseInt(N);
		int length = N.length();
		int[] num = new int[length];
		for (int i = length - 1; i >= 0; i--) {
			num[i] = (int) (number / Math.pow(10, i));
			number %= Math.pow(10, i);
		} // 자릿수 분리 완료

		Arrays.sort(num);
		boolean[] visited = new boolean[length];
		int[] output = new int[length];

		perm(num, output, 0, length, visited);
		System.out.println(max);
	}

	static void perm(int[] num, int[] output, int depth, int length, boolean[] visited) {
		if (depth == length) {
			long result = solve(output);
			max = Math.max(max, result);
			return;
		}

		for (int i = output.length - 1; i >= 0; i--) {
			if (!visited[i]) {
				output[depth] = num[i];
				visited[i] = true;
				perm(num, output, depth + 1, length, visited);
				visited[i] = false;
			}
		}
	}

	static long solve(int[] output) {
		long tmp = 0;
		for (int i = 0; i < output.length; i++) {
			tmp += output[i] * Math.pow(10, output.length - 1 - i);
		}
		if (tmp % 30 == 0) {
			return tmp;
		}
		return -1;
	}
}
