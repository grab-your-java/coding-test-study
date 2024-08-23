package perfect_shuffle;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();
			int M = Math.round((float) N / 2);
			int frontIdx = 0;
			int rearIdx = 1;

			String[] result = new String[N];
			for (int i = 0; i < N; i++) {
				if (i < M) {
					result[frontIdx] = sc.next();
					frontIdx += 2;
				} else {
					result[rearIdx] = sc.next();
					rearIdx += 2;
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#" + t);
			for (String string : result) {
				sb.append(" " + string);
			}
			System.out.println(sb);
		}
	}
}