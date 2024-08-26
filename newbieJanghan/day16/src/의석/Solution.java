package 의석;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int len = 0;;
			
			String[] arr = new String[5];
			for (int i = 0; i < 5; i++) {
				arr[i] = sc.next();
				len = Math.max(len, arr[i].length());
			}
			
			String result = "";
			for (int i=0; i< len; i++) {
				for (String string: arr) {
					if (i > string.length()-1) {
						continue;
					}
					result += string.charAt(i);
				}
			}
			

			System.out.println("#" + t + " " + result);
		}
	}
}
