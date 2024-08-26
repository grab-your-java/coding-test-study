package swea.D2;

import java.util.Scanner;

public class SWEA_1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int size = sc.nextInt();
			int[][] arr = new int[size][2];
			for(int i=0; i<size; i++) {
				arr[i][0] = sc.nextInt();
				if(arr[i][0]==0) continue;
				arr[i][1] = sc.nextInt();
			}
			int length = 0;
			int now = 0;
			for(int i=0; i<size; i++) {
				if(arr[i][0]==1) {
					length += arr[i][1]+now;
					now = arr[i][1]+now;
				}else if(arr[i][0]==0) {
					length += now;
				}else if(now-arr[i][1] > 0) {
					length += now-arr[i][1];
					now = now-arr[i][1];
				}else {
					now=0;
				}
			}
			System.out.println("#"+test_case+" "+length);
		}
	}
}
