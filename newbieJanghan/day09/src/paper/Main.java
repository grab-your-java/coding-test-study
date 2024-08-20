package paper;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int papers = sc.nextInt();
		int result = 0;
		int[][] grid = new int[101][101];
		while (papers-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int r = y; r < y + 10; r++) {
				for (int c = x; c < x + 10; c++) {
					if (grid[r][c] == 0) {
						result++;
					}
					grid[r][c]++;
				}
			}
		}
		System.out.println(result);
	}
}
