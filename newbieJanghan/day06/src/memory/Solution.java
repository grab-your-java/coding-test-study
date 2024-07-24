package memory;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			int result = 0;
			
			char[] origin = sc.next().toCharArray();
			char flag = '0';
			for (char c: origin) {
				if (flag != c) result++;
				flag = c;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
