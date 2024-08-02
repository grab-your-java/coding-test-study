package mellon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		int height = 0;
		int width = 0;
		int smallArea = 0;

		int[] directions = new int[6];
		int[] distances = new int[6];
		for (int i = 0; i < 6; i++) {
			int direction = sc.nextInt();
			directions[i] = direction;

			int distance = sc.nextInt();
			distances[i] = distance;

			if (direction == 3 || direction == 4) {
				height = Math.max(height, distance);
			} else {
				width = Math.max(width, distance);
			}
		}

		// when direction doubled after one line, small area created.
		// but if before and after of current direction is same,
		// it's in small area.
		for (int i = 0; i < 6; i++) {
			if (directions[(i + 5) % 6] == directions[(i + 1) % 6]) {
				continue;
			}
			if (directions[(i + 2) % 6] == directions[i]) {
				smallArea = distances[(i + 1) % 6] * distances[(i + 2) % 6];
				break;
			}
		}

		int area = height * width - smallArea;
		System.out.println(P * area);
	}
}
