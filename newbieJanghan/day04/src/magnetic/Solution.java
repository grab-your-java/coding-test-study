package magnetic;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			int result = 0;
			int N = sc.nextInt();
			
			// Mapping
			int[][] grid = new int[N][N];
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					grid[r][c] = sc.nextInt();
				}
			}
			
			// 각 컬럼마다 로우를 순회하면서 
			// N극을 만나면 기억한 후, S극을 만나면 충돌 카운트 올리고 기억 초기화.
			for (int c=0; c<N; c++) {
				boolean stacked = false;
				for (int r=0; r<N; r++) {
					// N극
					if (grid[r][c] == 1 && !stacked) {
						stacked = true;
					} 
					// S극
					else if (grid[r][c] == 2 && stacked) {
						result++;
						stacked = false;
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
