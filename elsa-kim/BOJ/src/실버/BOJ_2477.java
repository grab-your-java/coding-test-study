package 실버;

import java.util.Scanner;

public class BOJ_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[][] arr = new int[6][2];
		for(int i=0; i<6; i++) {
			for(int j=0; j<2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int S = 0;
		if(arr[0][0]!=arr[2][0]) {
			if(arr[0][1]>arr[2][1]) {
				S=arr[1][1]*arr[2][1] + arr[5][1]*arr[4][1];
			}else {
				S=arr[0][1]*arr[1][1] + arr[3][1]*arr[4][1];
			}
		}else {
			S=arr[2][1]*arr[3][1] + arr[0][1]*arr[5][1];
		}
		System.out.println((long) S*cnt);
	}
}
