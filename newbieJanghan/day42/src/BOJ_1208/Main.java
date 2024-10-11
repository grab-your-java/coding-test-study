package BOJ_1208;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, S, cnt, pSum;
	static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();

		nums = new int[N];
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			nums[i] = num;
			if (num > 0) {
				pSum += num;
			}
		}

		Arrays.sort(nums);

		dfs(0, 0, 0);
		dfs(0, nums[0], 1);

		System.out.println(cnt);
	}

	static void dfs(int index, int sum, int count) {
		if (sum + pSum < S) {
			return;
		}
		
		if (sum > S) {
			return;
		}

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
