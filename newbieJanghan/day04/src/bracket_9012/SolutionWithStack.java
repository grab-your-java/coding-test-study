package bracket_9012;

import java.util.Scanner;
import java.util.Stack;

public class SolutionWithStack {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for (int i=0; i<N; i++) {
            Stack<String> stack = new Stack<String>();
        	String str = sc.next();
        	
            for (int j=0; j<str.length(); j++) {
            	String cur = String.valueOf(str.charAt(j));
            	if (stack.isEmpty()) {
            		stack.push(cur);
            		continue;
            	}
            	
            	String peek = stack.peek();
            	
            	if (peek.equals("(") && cur.equals(")")) {
            		stack.pop();
            		continue;
            	}
            	
            	stack.push(cur);
            }
            
            System.out.println(stack.isEmpty() ? "YES" : "NO");
        }
	}
}
