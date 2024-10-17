package SWEA_4008;

import java.util.Scanner;

// 시간 초과
public class Fail {
	static char[] operators = { '+', '-', '*', '/' };
	static char[] opArr;
	static int[] numArr;
	static boolean[] visited;
	static int min, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = sc.nextInt();
			opArr = new char[N - 1];

			int idx = 0;
			for (char operator : operators) {
				int cnt = sc.nextInt();
				while (cnt-- > 0) {
					opArr[idx++] = operator;
				}
			}

			numArr = new int[N];
			for (int i = 0; i < N; i++) {
				numArr[i] = sc.nextInt();
			}

			visited = new boolean[opArr.length];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			dfs(0, numArr[0]);

			sb.append((max - min)).append("\n");
		}
		
		System.out.println(sb);
	}

	static void dfs(int idx, int acc) {
		if (idx == opArr.length) {
			max = Math.max(max, acc);
			min = Math.min(min, acc);
			return;
		}
//		System.out.println("\n accumulated " + acc + " operation target number " + numArr[idx + 1]);

		for (int i = 0; i < opArr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(idx + 1, operate(acc, numArr[idx + 1], opArr[i]));
				visited[i] = false;
			}
		}
	}

	static int operate(int a, int b, char op) {
//		System.out.print(a + " " + op + " " + b + " = ");
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
//		System.out.println(result);
		return result;
	}

}
