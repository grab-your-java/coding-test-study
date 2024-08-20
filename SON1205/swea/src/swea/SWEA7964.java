package swea;

import java.util.Scanner;

public class SWEA7964 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int TC = 1; TC <= T; TC++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			
			int[] city = new int[N];
			
			for (int i = 0; i < N; i++) {
				city[i] = sc.nextInt();
			}
			
			int result = 0;
			int idx = -1;
			while (idx < N - D) {
				int cnt = 0;
				
				for (int j = 1; j <= D; j++) {
					if (city[idx + j] == 1) {
						idx += j;
						break;
					}
					
					cnt++;
					if (cnt == D) {
						idx += D;
						result++;
					}
				}
			}
			
			System.out.println("#" + TC + " " + result);
		}
	}
}
