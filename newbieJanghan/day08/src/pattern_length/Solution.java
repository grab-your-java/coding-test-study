package pattern_length;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int result = 0;
			String string = sc.next();
			while (++result <= 10) {
				String a = string.substring(0, result);
				String b = string.substring(result, 2 * result);

				if (a.equals(b))
					break;
			}

			System.out.println("#" + t + " " + result);
		}
	}
}
