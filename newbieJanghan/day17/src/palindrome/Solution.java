package palindrome;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			// input
			int N = sc.nextInt();
			char[][] grid = new char[8][8];
			for (int r = 0; r < 8; r++) {
				grid[r] = sc.next().toCharArray();
			}
			
			int result = 0;
			// check horizontal
			for (int r = 0; r < 8; r++) {
				Case: for (int c = 0; c <= 8 - N; c++) {
					int fi = c;
					int bi = c + N - 1;
					while (fi < bi) {
						if (grid[r][fi] != grid[r][bi]) {
							continue Case;
						}
						fi++;
						bi--;
					}
					result++;
				}
			}

			// check vertical
			for (int c = 0; c < 8; c++) {
				Case: for (int r = 0; r <= 8 - N; r++) {
					int fi = r;
					int bi = r + N - 1;
					while (fi < bi) {
						if (grid[fi][c] != grid[bi][c]) {
							continue Case;
						}
						fi++;
						bi--;
					}
					result++;
				}
			}

			System.out.println("#" + t + " " + result);
		}

	}
 }