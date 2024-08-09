package mode_value;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int t = sc.nextInt();

			int[] scoreCounts = new int[101];
			int studentCount = 1000;
			while (studentCount-- > 0) {
				int score = sc.nextInt();
				scoreCounts[score]++;
			}

			int modeCount = 0;
			int mode = 100;
			for (int score = 0; score<=100; score++) {
				if (modeCount <= scoreCounts[score]) {
					modeCount = scoreCounts[score];
					mode = score;
				}
			}

			System.out.println("#" + t + " " + mode);
		}

	}

}