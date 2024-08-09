package harvest;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int result = 0;
			int N = sc.nextInt();
			
			for (int r = 0; r < N; r++) {
				char[] list = sc.next().toCharArray();
				for (int c = 0; c < N; c++) {
					int middle = N / 2;
					int distance = r <= middle ? r : 2 * middle - r;
					if (middle - distance <= c && c <= middle + distance) {
						int number = Character.getNumericValue(list[c]);
						result += number;
					}
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}
}
