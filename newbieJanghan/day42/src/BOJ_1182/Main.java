package BOJ_1182;

import java.util.Scanner;

public class Main {
	static int N, S, cnt;
	static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();

		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		dfs(0, 0, 0);
		dfs(0, nums[0], 1);

		System.out.println(cnt);
	}

	static void dfs(int index, int sum, int count) {
		if (index == N) {
			if (count > 0 && sum == S) {
				cnt++;
			}
			return;
		}

		dfs(index + 1, sum, count);
		if (index + 1 < N) {
			dfs(index + 1, sum + nums[index + 1], count + 1);
		}

	}
}
