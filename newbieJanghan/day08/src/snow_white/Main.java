package snow_white;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] heights = new int[9];
		int sum = 0;
		// mapping
		for (int i = 0; i < 9; i++) {
			int number = sc.nextInt();
			heights[i] = number;
			sum += number;
		}

		// find spare matcher
		boolean found = false;
		for (int i = 0; i < 8; i++) {
			if (found) {
				break;
			}

			for (int j = i + 1; j < 9; j++) {
				if (heights[i] + heights[j] == sum - 100) {
					heights[i] = 0;
					heights[j] = 0;
					found = true;
					break;
				}
			}
		}

		// sort asc
		Arrays.sort(heights);
		for (int height : heights) {
			if (height == 0) {
				continue;
			}
			System.out.println(height);
		}

	}
}
