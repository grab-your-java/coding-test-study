import java.util.Scanner;
import java.util.Stack;

public class SWEA_5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int stick = 0;
			int slicedStick = 0;
			Stack<Character> stack = new Stack<>();
			String s = sc.next();

			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
					stack.pop();
					slicedStick += stick;
				}
				if (s.charAt(i) == '(' && s.charAt(i + 1) != ')') {
					stack.push(s.charAt(i));
					stick++;
				}
			}
		}

	}

}
