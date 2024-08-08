package swea;

import java.util.Scanner;

public class SWEA1860 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] coming = new int[11112];
			
			for (int i = 0; i < N; i++) {
				coming[sc.nextInt()]++;
			}
			
			boolean possible = true;
			int total = 0;
			
			for (int i = 0; i < 11112; i++) {
				if (coming[i] == 0) {
					continue;
				}
				
				total += coming[i];
				
				if (i / M * K < total) {
					possible = false;
					break;
				}
			}
			
			if (possible) {
				System.out.println("#" + tc + " Possible");
			} else {
				System.out.println("#" + tc + " Impossible");
			}
		}
	}
}
