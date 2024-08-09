package coordinate;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int result = 0;

			int A = sc.nextInt();
			int B = sc.nextInt();
			int targetY = 0;
			int targetX = 0;

			boolean found = false;
			for (int i = 1; i <= 10000; i++) {
				if (found) {
					break;
				}
				
				for (int x = 1; x <= i; x++) {
					result++;
					
					int y = i + 1 - x;
					if (result == A) {
						targetY += y;
						targetX += x;
					}
					if (result == B) {
						targetY += y;
						targetX += x;
					}
					
					if (result >= Math.max(A, B) && targetY == y && targetX == x) {
						found = true;
						break;
					}

				}
			}

			System.out.println("#" + t + " " + result);
		}
	}

}
