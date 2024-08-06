package swea;

import java.util.Scanner;

public class SWEA3499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			
			String[] inputs = new String[N];
			
			for (int j = 0; j < N; j++) {
				inputs[j] = sc.next();
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int p = 0; p < (N + 1) / 2; p++) {
				if (N % 2 == 1 && p == (N + 1) / 2 - 1) {
					sb.append(inputs[p]);
					break;
				}
				
				sb.append(inputs[p]);
				sb.append(" ");
				sb.append(inputs[p + (N + 1) / 2]);
				sb.append(" ");
			}
			
			System.out.println("#" + i + " " + sb.toString());
		}
	}
}
