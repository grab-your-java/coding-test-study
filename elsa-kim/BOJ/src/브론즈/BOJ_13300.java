package 브론즈;

import java.util.Scanner;

public class BOJ_13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int maxCnt = sc.nextInt();
		int[][] arr = new int[6][2];
		int a=0;
		int b=0;
		for(int i=0; i<cnt; i++) {
			a=sc.nextInt();
			b=sc.nextInt();
			arr[b-1][a]++;
		}
		int sum=0;
		for(int i=0; i<6; i++) {
			if(arr[i][0]%maxCnt!=0) {
				sum++;
			}
			if(arr[i][1]%maxCnt!=0) {
				sum++;
			}
			sum+=arr[i][0]/maxCnt;
			sum+=arr[i][1]/maxCnt;
		}
		System.out.println(sum);
		
	}
}
