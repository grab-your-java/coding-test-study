package mid_average;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int max = 0;
			int min = 10000;
			int sum = 0;
			int count = 10;
			int averagable_count = 8;

			while (count > 0) {
				int number = sc.nextInt();
				max = Math.max(max, number);
				min = Math.min(min, number);
				sum += number;

				count--;
			}
			
			int result = Math.round((float) (sum - max - min) / averagable_count);
			System.out.println("#" + t + " " + result);
		}

	}
}
