package swea.D3;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_7272 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		next: for (int tc = 1; tc <= T; tc++) {
			String str1 = sc.next();
			String str2 = sc.next();
			String[] one = { "A", "D", "O", "P", "Q", "R" };
			if (str1.length() != str2.length()) {
				System.out.println("#" + tc + " DIFF");
				continue next;
			}
			for (int i = 0; i < str1.length(); i++) {
				if (str1.substring(i, i + 1).equals("B")) {
					if (!str2.substring(i, i + 1).equals("B")) {
						System.out.println("#" + tc + " DIFF");
						continue next;
					}
				} else if (Arrays.asList(one).contains(str1.substring(i, i + 1))) {
					if (!Arrays.asList(one).contains(str2.substring(i, i + 1))) {
						System.out.println("#" + tc + " DIFF");
						continue next;
					}
				} else if (str2.substring(i, i + 1).equals("B")) {
					if (!str1.substring(i, i + 1).equals("B")) {
						System.out.println("#" + tc + " DIFF");
						continue next;
					}
				} else if (Arrays.asList(one).contains(str2.substring(i, i + 1))) {
					if (!Arrays.asList(one).contains(str1.substring(i, i + 1))) {
						System.out.println("#" + tc + " DIFF");
						continue next;
					}
				}
			}
			System.out.println("#" + tc + " SAME");
		}
	}

}
