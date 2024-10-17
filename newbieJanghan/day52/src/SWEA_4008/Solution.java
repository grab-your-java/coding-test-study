package SWEA_4008;

import java.util.Scanner;

public class Solution {
	static char[] operators = { '+', '-', '*', '/' };
	static int[] operatorsCnt, numArr;
	static int N, min, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			N = sc.nextInt();

			operatorsCnt = new int[4];
			for (int i = 0; i < 4; i++) {
				operatorsCnt[i] = sc.nextInt();
			}

			numArr = new int[N];
			for (int i = 0; i < N; i++) {
				numArr[i] = sc.nextInt();
			}

			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			dfs(0, numArr[0]);

			sb.append((max - min)).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int idx, int acc) {
		if (idx == N - 1) {
			max = Math.max(max, acc);
			min = Math.min(min, acc);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operatorsCnt[i] > 0) {
				if (i == 3 && numArr[idx + 1] == 0) {
					continue;
				}
				operatorsCnt[i]--;
				dfs(idx + 1, operate(acc, numArr[idx + 1], operators[i]));
				operatorsCnt[i]++;
			}
		}
	}

	static int operate(int a, int b, char op) {
		int result = a;

		switch (op) {
		case '+':
			result += b;
			break;
		case '-':
			result -= b;
			break;
		case '*':
			result *= b;
			break;
		default:
			result /= b;
			break;
		}

		return result;
	}
}
