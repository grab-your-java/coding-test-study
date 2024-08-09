import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1224 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {

			int trash = sc.nextInt();
			String expression = sc.next();
			String postFix = infixToPostfix(expression);
			int result = evalPostfix(postFix);
			System.out.println("#"+ i + " " + result);
		}

	}

	static Map<Character, Integer> map = new HashMap<>();

	static {
		map.put('(', 0);
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
	}

	static String infixToPostfix(String infix) {

		String postfix = "";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (c >= '0' && c <= '9') {
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
				// 토큰 연산자의 우선순위가 top 연산자의 우선순위보다
				// 높을때까지
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(c) <= map.get(stack.peek())) {
					char popItem = stack.pop();
					postfix += popItem;
				}
				stack.push(c);
			}
		}

		return postfix;
	}

	static int evalPostfix(String postfix) {

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < postfix.length(); i++) {

			char c = postfix.charAt(i);

			if (c >= '0' && c <= '9') {
				stack.push(c - '0');
			} else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				int result = 0;
				if (c == '+') {
					result = num2 + num1;
				} else if (c == '-') {
					result = num2 - num1;
				} else if (c == '*') {
					result = num2 * num1;
				} else {
					result = num2 / num1;
				}
				stack.push(result);
			}
		}
		return stack.pop();
	}
}