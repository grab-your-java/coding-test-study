package ox_quiz;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int succession = 0;
			int score = 0;

			char[] cArr = sc.next().toCharArray();
			for (char c : cArr) {
				if (c == 'O') {
					succession++;
					score += succession;
				} else {
					succession = 0;
				}
			}

			System.out.println(score);
		}

	}
}