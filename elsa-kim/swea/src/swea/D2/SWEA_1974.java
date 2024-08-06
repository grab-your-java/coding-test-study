package swea.D2;

import java.util.Scanner;

public class SWEA_1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		test:for(int tc = 1; tc<=T; tc++) {
			int[][] arr = new int[9][9];
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int[][][] cnt = new int[9][9][2];
			// [각줄][1~9 여부 확인][0:가로. 1:세로]
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					cnt[i][arr[i][j]-1][0]++;
					cnt[i][arr[j][i]-1][1]++;
				}
			}
			int[][][] cnt2 = new int[3][3][9];
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					for(int k=0; k<3; k++) {
						for(int m=0; m<3; m++) {
							cnt2[i][j][arr[3*i+k][3*j+m]-1]++;
						}
					}
				}
				
			}
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					if(cnt[i][j][0]!=1||cnt[i][j][1]!=1) {
						System.out.println("#"+tc+" "+0);
						continue test;
					}
				}
			}
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					for(int k=0; k<9; k++) {
						if(cnt2[i][j][k]!=1) {
							System.out.println("#"+tc+" "+0);
							continue test;
						}
						
					}
				}
				
			}
			System.out.println("#"+tc+" "+1);
		}
	}

}
