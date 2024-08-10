package 브론즈;

import java.util.Scanner;

public class BOJ_3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int[] cntArr = new int[10];
		for(int i=0; i<10; i++) {
			arr[i] = sc.nextInt();
			cntArr[i] = 42;
		}
		for(int i=0; i<10; i++) {
			arr[i] = arr[i] % 42;
		}
		for(int i=0, idx=0; i<10; i++) {
			boolean canAdd = true;
			for(int j=0; j<10; j++) {
				if(arr[i]==cntArr[j]) {
					canAdd=false;
				}
			}
			if(canAdd) {
				cntArr[idx++] = arr[i];
			}
		}
		int cnt=0;
		for(int i=0; i<10; i++) {
			if(cntArr[i]!=42) cnt++;
		}
		System.out.println(cnt);
	}
}
