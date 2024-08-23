package SWEA_1218;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int test_case = 10;
		for (int t = 1; t <= test_case; t++) {

			int n = sc.nextInt();

			Stack<Character> stack = new Stack<Character>();

			char[] arr = sc.next().toCharArray();

//			System.out.println(Arrays.toString(arr));

			boolean isValid = true;

			for (int i = 0; i < n; i++) {

				if (arr[i] == '(' || arr[i] == '{' || arr[i] == '<' || arr[i] == '[') {
					stack.push(arr[i]);
				} else {
					if (stack.isEmpty()) {
						isValid = false;
						break;
					}
					char popItem = stack.pop();
					if (arr[i] == ')' && popItem != '(') {
						isValid = false;
						break;
					}
					if (arr[i] == '}' && popItem != '{') {
						isValid = false;
						break;
					}
					if (arr[i] == ']' && popItem != '[') {
						isValid = false;
						break;
					}
					if (arr[i] == '>' && popItem != '<') {
						isValid = false;
						break;
					}
				}
			}

			if (!stack.isEmpty()) {
				isValid = false;
			}
			String result = "0";
			if (isValid == true) {
				result = "1";
				System.out.println("#" + t + " " + result);
			} else {
				System.out.println("#" + t + " " + result);
			}

		}
	}
}