package iron_stick;

import java.util.Scanner;

public class Solution {
	public static class Stack {
		private int[] stack;
		private int top = -1;
		public Stack(int N) {
			stack = new int[N];
		}

		boolean isEmpty() {
			return top == -1;
		}

		int pop() {
			int value = stack[top];
			stack[top--] = 0;
			return value;
		}

		void add(int n) {
			stack[++top] = n;
		}

		void addTop(int n) {
			stack[top] += n;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int result = 0;

			char[] cArr = sc.next().toCharArray();
			Stack stack = new Stack(cArr.length);
			for (int i = 0; i < cArr.length; i++) {
				char c = cArr[i];
				if (c == '(') {
					stack.add(1);
				} else {
					int top = stack.pop();
					if (top == 1) {
						if (!stack.isEmpty()) {
							stack.addTop(1);
						}

					} else {
						result += top;
						if (!stack.isEmpty()) {
							stack.addTop(top - 1);
						}
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

}