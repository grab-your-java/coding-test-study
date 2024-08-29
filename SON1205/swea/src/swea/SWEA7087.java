package swea;

import java.util.Scanner;

public class SWEA7087 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			char[] alphabet = new char[26];
			
			for (int i = 0; i < N; i++) {
				alphabet[sc.next().charAt(0) - 'A']++;
			}
			
			int result = 0;
			
			for (int i = 0; i < alphabet.length; i++) {
				if (alphabet[i] <= 0) {
					break;
				}
				
				result = i + 1;
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
