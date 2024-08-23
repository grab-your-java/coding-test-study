package swea;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SWEA1224 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			int N = sc.nextInt();
			
			String input = sc.next();
			
			String postfixInput = toPrefix(input);
			
			System.out.println("#" + i + " " + evalPostfix(postfixInput));
		}
	}
	
	static int evalPostfix(String str) {
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if ('0' <= c && c <= '9') {
				stack.push(c - '0');
			} else {
				int result = 0;
				
				if (c == '+') {;
					result += stack.pop() + stack.pop();
				} else {
					result += stack.pop() * stack.pop();
				}
				
				stack.push(result);
			}
		}
		
		return stack.pop();
	}
		
	static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('+', 1);
		map.put('*', 2);
	}
	
	static String toPrefix(String str) {
		StringBuilder postfix = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if ('0' <= c && c <= '9') {
				postfix.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix.append(popItem);
					popItem = stack.pop();
				}
			} else {
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
					postfix.append(stack.pop());
				}
				
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()) {
			postfix.append(stack.pop());
		}
		
		return postfix.toString();
	}
}