package problem_naming;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] alphabetCount = new int[26]; // A - Z
			while (N-- > 0) {
				int code = sc.next().charAt(0);
				alphabetCount[code - 65] = 1; // A = 65, Z = 90
			}
			int result = 0;
			for (int count : alphabetCount) {
				if (count == 0) {
					break;
				}
				result += count;
			}

			System.out.println("#" + t + " " + result);

		}
	}

}
