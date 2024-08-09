package triangle_of_pascal;

import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();

			// test case
			sb.append("#" + t + "\n");

			// triangle
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < r + 1; c++) {
					sb.append(getPascalNum(r, c) + " ");
					if (r != N - 1 && c == r) {
						sb.append("\n");
					}
				}
			}

			// print
			System.out.println(sb);
		}

	}

	public static int getPascalNum(int r, int c) {
		if (c == 0 || c == r) {
			return 1;
		}

		return getPascalNum(r - 1, c - 1) + getPascalNum(r - 1, c);
	}

}
