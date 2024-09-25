package BOJ_1208;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, S;
	static int[] nums;
	static int nTotal = 0, pTotal = 0;
	static int boundary, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num < 0) {
				nTotal += num;
			} else {
				pTotal += num;
			}
			nums[i] = num;
		}

		Arrays.sort(nums);

		for (int i = 0; i < N; i++) {
			if (nums[i] > 0) {
				boundary = i;
				break;
			}
		}

		collect(0, 0);
		collect(0, nums[0]);
		
		if (answer > 0) {
			answer--; // 공집합
		}
		
		System.out.println(answer);
	}

	static void collect(int idx, int sum) {
		if (idx == N || sum > S) {
			return;
		}

		if (sum == S) {
			answer++;
			return;
		}

		if (sum + pTotal < S) {
			collect(boundary, 0);
			collect(boundary, nums[boundary]);
		}

		else {
			collect(idx + 1, sum);
			collect(idx + 1, sum + nums[idx]);
		}
	}
}
