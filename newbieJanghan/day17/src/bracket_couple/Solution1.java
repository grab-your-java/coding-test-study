package bracket_couple;

import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			boolean result = true;
			int N = sc.nextInt();
			char[] cArr = sc.next().toCharArray();
			int top = -1;

			for (int i = 0; i < N; i++) {
				char c = cArr[i];
				if (c == '(' || c == '{' || c == '<' || c == '[') {
					cArr[++top] = c;
					continue;
				}

				if (top < 0) {
					result = false;
					break;
				}

				if ((c == ')' && cArr[top] != '(') || (c == '}' && cArr[top] != '{') || (c == ']' && cArr[top] != '[')
						|| (c == '>' && cArr[top] != '<')) {
					result = false;
					break;
				} else {
					top--;
				}

			}

			System.out.println("#" + t + " " + (result ? 1 : 0));
		}
	}

}