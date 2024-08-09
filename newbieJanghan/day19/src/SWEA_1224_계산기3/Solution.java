package SWEA_1224_계산기3;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			String infix = sc.next();
			System.out.println("#" + t + " " + calPostfix(infixToPostfix(infix)));
		}
	}

	static int valOf(char c) {
		return c == '+' ? 1 : 2;
	}

	static String infixToPostfix(String infix) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);

			if ('0' <= c && c <= '9') {
				postfix += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			} else {
				if (!stack.empty() && stack.peek() != '(' && valOf(stack.peek()) >= valOf(c)) {
					postfix += stack.pop();
				}
				stack.push(c);
			}
		}

		return postfix;
	}

	static int calPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);

			if ('0' <= c && c <= '9') {
				stack.push(c - '0');
			} else if (!stack.empty()) {
				int b = stack.pop();
				int a = stack.pop();
				int result = 0;
				if (c == '+') {
					result = b + a;
				} else {
					result = b * a;
				}
				stack.push(result);
			}
		}

		return stack.pop();
	}

	static class Stack<T> {
		private ArrayList<T> list = new ArrayList<>();
		private int top = -1;

		public void push(T obj) {
			list.add(obj);
			top++;
		}

		public T pop() {
			return list.remove(top--);
		}

		public T peek() {
			return list.get(top);
		}

		public boolean empty() {
			return top == -1;
		}
	}
}
