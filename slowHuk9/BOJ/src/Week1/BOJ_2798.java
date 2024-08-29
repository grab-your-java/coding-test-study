package Week1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int m = sc.nextInt();

		int[] card = new int[n];

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			card[i] = sc.nextInt();
		}

		for (int i = 0; i < card.length; i++) {
			for (int j = i + 1; j < card.length; j++) {
				for (int k = j + 1; k < card.length; k++) {
					int sum = card[i] + card[j] + card[k];
					if (sum <= m) {
						cnt++;
					}
				}
			}
		}
		int[] result = new int[cnt];
		int index = 0;
		for (int i = 0; i < card.length; i++) {
			for (int j = i + 1; j < card.length; j++) {
				for (int k = j + 1; k < card.length; k++) {
					int sum = card[i] + card[j] + card[k];
					if (sum <= m) {
						result[index++] = sum;
					}
				}
			}
		}
		Arrays.sort(result);
		System.out.println(result[result.length - 1]);

	}

}