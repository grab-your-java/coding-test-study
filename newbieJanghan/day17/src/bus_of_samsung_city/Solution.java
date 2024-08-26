package bus_of_samsung_city;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			;
			int[] busCountByStop = new int[5001];
			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				for (int j = start; j <= end; j++) {
					busCountByStop[j]++;
				}
			}

			String print = "#" + t + " ";
			int P = sc.nextInt();
			while (P-- > 0) {
				int stop = sc.nextInt();
				print += busCountByStop[stop]+ " ";
			}

			System.out.println(print);
		}
	}
}
