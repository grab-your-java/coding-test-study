package mellon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		int height = 0;
		int width = 0;
		int spareHeight = 0;
		int spareWidth = 0;

		int[] distances = new int[4];
		boolean alreadyDouble = false;
		int iter = 6;
		while (iter-- > 0) {
			int dir = sc.nextInt();
			int distance = sc.nextInt();

			if (distances[dir - 1] == 0) {
				// Set height, width
				if (dir == 3 || dir == 4) {
					height = Math.max(height, distance);
				} else {
					width = Math.max(width, distance);
				}

				distances[dir - 1] = distance;
				continue;
			}

			// Check Shape
			if (!alreadyDouble) {
				// when first double direction
				if (dir == 3 || dir == 4) {
					spareHeight = distance;
				} else {
					spareWidth = distance;
				}

				alreadyDouble = true;
			} else {
				// when first double direction
				if (dir == 3 || dir == 4) {
					spareHeight = distances[dir - 1];
				} else {
					spareWidth = distances[dir - 1];
				}
			}
		}
		
		long area = height * width - (spareHeight * spareWidth);
		System.out.println(P * area);
	}
}
