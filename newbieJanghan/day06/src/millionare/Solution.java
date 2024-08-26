package millionare;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			long result = 0;
			int N = sc.nextInt();
			int[] list = new int[N];
			for (int i = 0; i<N; i++) {
				list[i] = sc.nextInt();
			}
			
			int max = 0;
			for (int i=N-1; i>=0; i--) {
				int cur = list[i];
				if (max > cur) {
					result += max-cur;
				} else {
					max = cur;
				}
			}
			
			
			System.out.println("#" + t + " " + result);
		}
	}
}
