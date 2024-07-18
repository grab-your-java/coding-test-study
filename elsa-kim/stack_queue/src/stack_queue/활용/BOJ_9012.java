package stack_queue.활용;

import java.util.Scanner;
import java.util.Stack;

// 스택 활용해서 문제 해결
public class BOJ_9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			boolean VPS = true;
			String test = sc.next();
			char[] charArray = test.toCharArray();
			Stack<Integer> stack = new Stack<>();
			for (int i=0; i<test.length(); i++) {
				if (charArray[i]=='(') {
					stack.push(1);
				}else {
					if(stack.size()>0) {
						stack.pop();
					}else {
						VPS = false;
					}
				}
			}
			if(stack.size()>0) VPS=false;
			System.out.println(VPS?"YES":"NO");
		}
	}
}
