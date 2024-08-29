package swea;

import java.util.Scanner;

public class SWEA11315 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int TC = 1; TC <= T; TC++) {
			int N = sc.nextInt();
			
			String[] square = new String[N];
			
			for (int i = 0; i < N; i++) {
				square[i] = sc.next();
			}
			
			boolean isValid = false;
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - 5; j++) {
					//가로
					for (int p = 0; p < 5; p++) {
						if (square[i].charAt(j + p) == '.') {
							cnt = 0;
							break;
						}
						
						cnt++;
						if(cnt == 5) {
							isValid = true;
						}
					}
					
					if (isValid) {
						break;
					}
					
					for (int p = 0; p < 5; p++) {
						if (square[j + p].charAt(i) == '.') {
							cnt = 0;
							break;
						}
						
						cnt++;
						if(cnt == 5) {
							isValid = true;
						}
					}
				}
			}
			
			if (!isValid) {
				for (int i = 0; i <= N - 5; i++) {
					for (int j = 0; j <= N - 5; j++) {
						
						for (int p = 0; p < 5; p++) {
							if (square[i + p].charAt(j + p) == '.') {
								cnt = 0;
								break;
							}
							
							cnt++;
							if(cnt == 5) {
								isValid = true;
							}
						}
						
						for (int p = 0; p < 5; p++) {
							if (square[i + p].charAt(N - 1 - (j + p)) == '.') {
								cnt = 0;
								break;
							}
							
							cnt++;
							if(cnt == 5) {
								isValid = true;
							}
						}
					}
				}
			}
			
			if (isValid) {
				System.out.println("#" + TC + " YES");
			} else {
				System.out.println("#" + TC + " NO");
			}
		}
	}
}
