package 실버;

import java.util.Scanner;

public class BOJ_2567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[][] color = new int[cnt][2];
		
		for(int i=0; i<cnt; i++) {
			color[i][0] = sc.nextInt();
			color[i][1] = sc.nextInt();
		}
		int[][][] getArr = new int[101][101][2];

		for(int i=0; i<cnt; i++) {
			for(int n=0; n<10; n++){
				for(int m=1; m<10; m++) {
					getArr[color[i][0]+m][color[i][1]+n][1] = -1;		
					getArr[color[i][0]+n][color[i][1]+m][0] = -1;			
				}
				
				if(getArr[color[i][0]][color[i][1]+n][1]!=-1) {
					getArr[color[i][0]][color[i][1]+n][1] = 1;					
				}
				if(getArr[color[i][0]+n][color[i][1]][0]!=-1) {
					getArr[color[i][0]+n][color[i][1]][0] = 1;					
				}
				if(getArr[color[i][0]+10][color[i][1]+n][1]!=-1) {
					getArr[color[i][0]+10][color[i][1]+n][1] = 1;					
				}
				if(getArr[color[i][0]+n][color[i][1]+10][0]!=-1) {
					getArr[color[i][0]+n][color[i][1]+10][0] = 1;					
				}
			}
		}
		for(int i=0; i<cnt; i++) {
			for(int j=0; j<cnt; j++) {
				if(i==j) continue;
				if(color[i][0]+10==color[j][0]) {
					if(color[i][1]>color[j][1]&& color[i][1]<color[j][1]+10) {
						for(int k=color[i][1]; k<color[j][1]+10; k++) {
							getArr[color[j][0]][k][1]=-1;
						}
					}else if(color[i][1]<=color[j][1]&& color[j][1]<color[i][1]+10) {
						for(int k=color[j][1]; k<color[i][1]+10; k++) {
							getArr[color[j][0]][k][1]=-1;
						}
					}
				}else if(color[i][1]+10==color[j][1]) {
					if(color[i][0]>color[j][0]&& color[i][0]<color[j][0]+10) {
						for(int k=color[i][0]; k<color[j][0]+10; k++) {
							getArr[k][color[j][1]][0]=-1;
						}
					}else if(color[i][0]<=color[j][0]&& color[j][0]<color[i][0]+10) {
						for(int k=color[j][0]; k<color[i][0]+10; k++) {
							getArr[k][color[j][1]][0]=-1;
						}
					}
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(getArr[i][j][0]==1) sum++;
				if(getArr[i][j][1]==1) sum++;
			}
		}
		System.out.println(sum);
	}
}
