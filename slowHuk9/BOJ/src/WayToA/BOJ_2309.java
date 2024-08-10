package WayToA;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] height = new int[9];
		int sum = 0;
		for (int i = 0; i < height.length; i++) {
			int n = sc.nextInt();
			if (n > 0 && n < 100) {
				height[i] = n;
			}
			sum += height[i];
		}
		sum = sum - 100; //

		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {

				if (height[i] + height[j] == sum) {
					int[] result = new int[7];

					for (int k = 0, index = 0; k < height.length; k++) {
						if (k != i && k != j) {
							result[index] = height[k];
							index++;
						}
					}
					Arrays.sort(result);

					for (int l = 0; l < result.length; l++) {
						System.out.println(result[l]);
					}
				}
			}

		}
	}
}
