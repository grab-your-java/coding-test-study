package 브론즈;

import java.util.Scanner;

public class BOJ_2999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String email = sc.next();
		int R=1;
		int C = 1;
		out:for (int c=email.length(); c>=1; c--) {
			for (int r=c; r>=1; r--) {
				if(r*c==email.length()) {
					R=r;
					C = c;
				}
			}
		}
		String[][] arr = new String[R][C];
		for(int i=0, idx=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				arr[j][i] = email.substring(idx, idx+1);
				idx++;
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(arr[i][j]);
				
			}
		}
	}
}
