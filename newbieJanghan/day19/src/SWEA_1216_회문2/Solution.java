package SWEA_1216_회문2;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		while (tc++ < 10) {
			int t = sc.nextInt();
			char[][] words = new char[100][100];
			int result = 0;

			for (int r = 0; r < 100; r++) {
				words[r] = sc.next().toCharArray();
			}

			// row by row
			for (int r = 0; r < 100; r++) {
				char[] word = words[r];
				A: for (int c = 0; c < 100; c++) {
					B: for (int length = 100 - c; length >= 1; length--) {
						int fi = c;
						int bi = c + length - 1;
						while (fi < bi) {
							if (word[fi] != word[bi]) {
								continue B;
							} else {
								fi++;
								bi--;
							}
						}

						if (result < length) {
							result = length;
							continue A;
						}
					}

				}
			}

			// column by column
			for (int c = 0; c < 100; c++) {
				A: for (int r = 0; r < 100; r++) {
					B: for (int length = 100 - r; length >= 1; length--) {
						int fi = r;
						int bi = r + length - 1;
						while (fi < bi) {
							if (words[fi][c] != words[bi][c]) {
								continue B;
							} else {
								fi++;
								bi--;
							}
						}

						if (result < length) {
							result = length;
							continue A;
						}
					}

				}
			}

			System.out.println("#" + t + " " + result);
		}

	}
}
