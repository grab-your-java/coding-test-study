package where_is_my_glasses;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Case: for (int t = 1; t <= T; t++) {
			char[] A = sc.next().toCharArray();
			char[] B = sc.next().toCharArray();
			
			if (A.length != B.length) {
				System.out.println("#" + t + " DIFF");
				continue Case;
			}

			for (int i = 0; i < A.length; i++) {
				if (getValue(A[i]) != getValue(B[i])) {
					System.out.println("#" + t + " DIFF");
					continue Case;
				}
			}

			System.out.println("#" + t + " SAME");
		}

	}

	static int getValue(char c) {
		if (c == 'B') {
			return 0;
		} else if (c == 'A' || c == 'D' || c == 'O' || c == 'P' || c == 'Q' || c == 'R') {
			return 1;
		} else {
			return 2;
		}
	}

}
