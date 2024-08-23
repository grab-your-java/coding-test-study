package swea.D4;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_5432 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			String str = sc.next();
			str = str.replace("()", "."); 
			int cnt=0;
			Stack<String> stack = new Stack<>();
			for(int i=0; i<str.length(); i++) {
				if(str.substring(i, i+1).equals("(")) stack.push("(");
				else if(str.substring(i, i+1).equals(")")) {
					stack.pop();
					cnt++;
				}else {
					cnt+=stack.size();
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}

}
