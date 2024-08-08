package 브론즈;

import java.util.Scanner;

public class BOJ_10163 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[][] arr = new int[cnt][4];
		int[][] big = new int[1001][1001];
		for(int i=0; i<cnt; i++) {
			for(int j=0; j<4; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<cnt; i++) {
			for(int a=arr[i][0]; a<arr[i][0]+arr[i][2]; a++) {
				for(int b=arr[i][1]; b<arr[i][1]+arr[i][3]; b++) {
					big[a][b] = i+1;
				}
			}
		}
		for(int k=0; k<cnt; k++) {
			int sum = 0;
			for(int i=0; i<big.length; i++) {
				for(int j=0; j<big.length; j++) {
					if(big[i][j]==k+1) sum++;
				}
				
			}
			System.out.println(sum);
		}
	}
}
