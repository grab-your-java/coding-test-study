package swea;

import java.util.Scanner;

public class SWEA7236 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			char[][] water = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					water[i][j] = sc.next().charAt(0);
				}
			}
			
			int[] deltaX = {-1, 0, 1};
			int[] deltaY = {-1, 0, 1};
			
			int max = 0;
			
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (water[i][j] == 'W') {
						int cnt = 0;
						
						for (int p = 0; p < deltaX.length; p++) {
							for (int q = 0; q < deltaY.length; q++) {
								if (water[i + deltaX[p]][j + deltaY[q]] == 'W' && (p != 1 || q != 1)) {
									cnt++;
								}
							}
						}
						
						if (cnt == 0) {
							cnt = 1;
						}
						
						if (cnt > max) {
							max = cnt;
						}
					}
				}
			} 
			
			System.out.println("#" + tc + " " + max);
		}
	}
}
