package 실버;

import java.util.Scanner;

public class BOJ_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[][] arr = new int[cnt][2];
		for(int i=0; i<cnt; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int sum = 0;
		int[][] have = new int[100][100];
		for(int i=0; i<cnt; i++) {
			for(int n=0; n<10; n++) {
				for(int m=0; m<10; m++) {
					have[arr[i][0]+n][arr[i][1]+m]=1;
				}
			}		
		}
		for (int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(have[i][j]==1) sum++;
			}
		}
		System.out.println(sum);
	}
}
