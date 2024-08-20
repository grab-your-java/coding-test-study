package 실버;

import java.util.Scanner;

public class BOJ_1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 스위치 수
		int cnt = sc.nextInt();
		int[] arr = new int[cnt];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 학생수
		int sCnt = sc.nextInt();
		
		// [성별, 스티커]
		int[][] sarr = new int[sCnt][2];
		for(int i=0; i<sCnt; i++) {
			sarr[i][0] = sc.nextInt();
			sarr[i][1] = sc.nextInt();
		}
		for(int i=0; i<sCnt; i++) {
			if(sarr[i][0] ==1) {
				for(int j=0; j<arr.length; j++) {
					if((j+1)%sarr[i][1]==0) {
						if(arr[j]==1) {
							arr[j]=0;
						}else {
							arr[j]=1;
						}
					}
					
				}
			}else {
				if(arr[sarr[i][1]-1]==1) {
					arr[sarr[i][1]-1]=0;
				}else {
					arr[sarr[i][1]-1]=1;
				}
				int j=1;
				while(sarr[i][1]-1-j>=0&&sarr[i][1]-1+j<arr.length&&arr[sarr[i][1]-1-j]==arr[sarr[i][1]-1+j]) {
					if(arr[sarr[i][1]-1-j]==0) {
						arr[sarr[i][1]-1-j]=1;
						arr[sarr[i][1]-1+j]=1;
					}else {
						arr[sarr[i][1]-1-j]=0;
						arr[sarr[i][1]-1+j]=0;
					}
					j++;
				}
				
			}
		}
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]);
			if(i==arr.length-1) return;
			if ((i+1)%20==0) {
				System.out.println();
			}else {
				System.out.print(" ");				
			}
		}
	}

}
