package SWEA_2805_농작물_수확하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int harvest = 0;

			for (int r = 0; r < N; r++) {
				char[] profits = sc.next().toCharArray();
				int start = Math.abs(N / 2 - r);
				for (int c = start; c < N - start; c++) {
					harvest += Character.getNumericValue(profits[c]);
				}
			}

			System.out.println("#" + t + " " + harvest);
		}
	}
}
