package baekjoon;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10828 {
	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		while (cnt > 0) {
			String method = sc.next();
			switch (method) {
			case "push" : 
				stack.push(sc.nextInt());
				break;
				
			case "top" :
				if (stack.isEmpty()) {
					System.out.println(-1);
					break;
				}
				
				System.out.println(stack.peek());
				break;
			case "size" :
				System.out.println(stack.size());
				break;
				
			case "empty" :
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
				
			default :
				if (stack.isEmpty()) {
					System.out.println(-1);
					break;
				}
				
				System.out.println(stack.pop());
			}
			
			cnt--;
		}
	}
}
