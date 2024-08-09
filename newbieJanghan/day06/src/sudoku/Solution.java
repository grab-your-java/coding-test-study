package sudoku;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			int result = 1;
			
			int[][] map = new int[9][9];
			int[][] rowMap = new int[9][10];
			
			// Mapping & validate by row, column
			for (int r=0; r<9; r++) {
				int[] colMap = new int[10];
				for (int c=0; c<9; c++) {
					int num = sc.nextInt();
					if (rowMap[c][num]++ > 0) {
						result = 0;
					}
					
					if (colMap[num]++ > 0) {
						result = 0;
					}

					map[r][c] = num;
				}
			}
			
			if (result != 0) {
				// Validate Square;
				for (int lr=0; lr<3; lr++) {
					for (int lc=0; lc<3; lc++) {
						int[] squareMap = new int[10];
						for (int r=lr*3; r<(lr+1)*3; r++) {
							if (result == 0) {
								break;
							}
							for (int c=lc*3; c<(lc+1)*3; c++) {
								int num = map[r][c];
								if (result == 0) {
									break;
								}
								
								if (squareMap[map[r][c]]++ > 0) {
									result = 0;
								}
							}
						}
					}
				}	
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
