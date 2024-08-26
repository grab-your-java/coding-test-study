package swea;

import java.util.Scanner;

public class SWEA7272 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			String input1 = sc.next();
			String input2 = sc.next();
			
			boolean isSame = true;
			
			if (input1.length() != input2.length()) {
				isSame = false;
			} else {
				for (int i = 0; i < input1.length(); i++) {
					if (checkingChar(input1.charAt(i)) != checkingChar(input2.charAt(i))) {
						isSame = false;
						break;
					}
				}
			}
			
			if (isSame) {
				System.out.println("#" + tc + " SAME");
			} else {
				System.out.println("#" + tc + " DIFF");
			}
		}	
	}
	
	static int checkingChar(char input) {
		int result = 0;
		
		switch (input) {
		case 'B':
			return result += 2;
		case 'A':
		case 'D':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
			return result += 1;	
		}
		
		return result;
	}
}
