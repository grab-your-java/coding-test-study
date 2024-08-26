package gate;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			int result = 0;
			int temp = 0;
			for (int i = 0; i < N; i++) {
				int gate = sc.nextInt();
				if (gate != 1) {
					temp++;
					if (temp == D) {
						temp = 0;
						result++;
					}
				} else {
					temp = 0;
				}
			}

			System.out.println("#" + t + " " + result);

		}
	}

}
