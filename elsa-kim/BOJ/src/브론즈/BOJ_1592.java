package 브론즈;

import java.util.Scanner;

public class BOJ_1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 사람수
		int pcnt = sc.nextInt();
		// 공 받는 최대 횟수
		int max = sc.nextInt();
		// idx 옆에 있는 사람한테 공 토스
		int idx = sc.nextInt();
		
		int[] arr = new int[pcnt];
		arr[0] = 1;
		int now=0;
		int cnt = 0;
		while(arr[now]<max) {
			cnt++;
			if(arr[now]%2==1) {
				now+=idx;
				if(now>=pcnt) now-=pcnt;
			}else {
				now-=idx;
				if(now<0) now+=pcnt;
			}
			arr[now]++;			
		}
		System.out.println(cnt);
	}
}
