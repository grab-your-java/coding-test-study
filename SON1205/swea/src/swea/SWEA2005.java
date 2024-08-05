package swea;

import java.util.Scanner;

public class SWEA2005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			
			int[][] arr = new int[N][];
			
			for (int j = 0; j < N; j++) {
				arr[j] = new int[j + 1];
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < j + 1; k++) {
					if (k == 0 || k == j) {
						arr[j][k] = 1;
						continue;
					}
					
					if (j == 0) {
						arr[j][k] = 1;
					}
					
					arr[j][k] = arr[j - 1][k - 1] + arr[j - 1][k];
				}
			}
			
			System.out.println("#" + i);
			for (int[] ar : arr) {
				for (int a : ar) {
					System.out.print(a + " ");
				}
				System.out.println();
			}
		}
	}
}
