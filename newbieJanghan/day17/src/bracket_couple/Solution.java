package bracket_couple;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NextTestCase: for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			
			CharStack stack = new CharStack(N);
			for (char c: sc.next().toCharArray()) {
				stack.push(c);
			}

			CharStack stack2 = new CharStack(N);

			while (!stack.isEmpty()) {
				char popItem = stack.pop();
				if (popItem == '(' || popItem == '[' || popItem == '{' || popItem == '<') {
					if (!stack2.isEmpty()) {
						String pair = popItem + "" + stack2.pop();
						if (pair.equals("()") || pair.equals("[]") || pair.equals("{}") || pair.equals("<>")) {
							continue;
						}
					} 
					System.out.println("#" + t + " 0");
					continue NextTestCase;
				} else {
					stack2.push(popItem);
				}
			}
			System.out.println("#" + t + " 1");
		}
	}

	static class CharStack {
		private char[] list;
		private int top = -1;

		public CharStack(int size) {
			list = new char[size];
		}

		public void push(char c) {
			list[++top] = c;
		}

		public char pop() {
			return list[top--];
		}

		public char peek() {
			return list[top];
		}

		public boolean isEmpty() {
			return top == -1;
		}

	}

}