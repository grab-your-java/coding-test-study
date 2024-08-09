package concert;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			char[] charArr = sc.next().toCharArray();

			int result = 0;
			int currentClap = 0;
			for (int i = 0; i < charArr.length; i++) {
				int people = Character.getNumericValue(charArr[i]);
				if (people == 0) {
					continue;
				}

				// insufficient people for clap
				if (currentClap < i) {
					int employee = i - currentClap;
					result += employee;
					currentClap += employee;
				}
				currentClap += people;
				
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
