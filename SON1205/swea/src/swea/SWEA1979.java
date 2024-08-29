package swea;

import java.util.Scanner;

public class SWEA1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			for (int p = 0; p < N; p++) {
				for (int q = 0; q < N; q++) {
					arr[p][q] = sc.nextInt();
				}
			}
			
			int result = 0;
			
			for (int p = 0; p < N; p++) {
				int q = 0;
				int cnt = 0;
				
				while (q < N) {
					if (arr[p][q] == 1) {
						cnt++;
					}
					if (arr[p][q] == 0 || q == N - 1) {
						if (cnt == K) {
							result++;
						}
						cnt = 0;
					}
					q++;
				}
				
				q = 0;
				while (q < N) {
					if (arr[q][p] == 1) {
						cnt++;
					}
					
					if (arr[q][p] == 0 || q == N - 1) {
						if (cnt == K) {
							result++;
						}
						cnt = 0;
					}
					q++;
				}
			}
			
			System.out.println("#" + i + " " + result);
		}
	}
}
