package swea.D2;

import java.util.Scanner;

public class SWEA_1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int size = sc.nextInt();
			int[][] arr = new int[size][size];
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					arr[i][j] = sc.nextInt();
				}
				
			}
			System.out.println("#"+tc);
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					System.out.print(arr[size-j-1][i]);
				}
				System.out.print(" ");
				for(int j=0; j<size; j++) {
					System.out.print(arr[size-i-1][size-j-1]);
				}
				System.out.print(" ");
				for(int j=0; j<size; j++) {
					System.out.print(arr[j][size-i-1]);
				}
				System.out.println();
				
			}
		}
	}
}
