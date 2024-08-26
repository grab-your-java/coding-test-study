package swea.D3;

import java.util.Scanner;

public class SWEA_1215 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T;
			T = sc.nextInt();
			String inputText = "";
			int cnt = 0;
			char[][] charArray = new char[8][8];
			for (int i = 0; i < 8; i++) {
				inputText = sc.next();
				for (int j = 0; j < 8; j++) {
					charArray[i][j] = inputText.charAt(j);
				}
			}
			String ori = "";
			String inv = "";
			for (int j = 0; j < 8; j++) {
				for (int i = 0; i < 8 - T + 1; i++) {
					for (int k = 0; k < T; k++) {
						ori += charArray[j][i + k];
						inv = charArray[j][i + k] + inv;
					}
					if (ori.equals(inv)) {
						cnt++;
					}
					ori = "";
					inv = "";
				}
			}
			for (int j = 0; j < 8; j++) {
				for (int i = 0; i < 8 - T + 1; i++) {
					for (int k = 0; k < T; k++) {
						ori += charArray[i + k][j];
						inv = charArray[i + k][j] + inv;
					}
					if (ori.equals(inv)) {
						cnt++;
					}
					ori = "";
					inv = "";
				}
			}
			System.out.println("#" + test_case + " " + cnt);
			cnt = 0;
		}
	}
}
