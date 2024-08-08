package 브론즈;

import java.util.Scanner;

public class BOJ_2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int max = sc.nextInt();
		int[] arr = new int[cnt];
		for(int i=0; i<cnt; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		int ans = 0;
		for(int i=0; i<cnt; i++) {
			for(int j=i+1; j<cnt; j++) {
				for(int k=j+1; k<cnt; k++) {
					sum += arr[i];
					sum += arr[j];
					sum += arr[k];
					if(sum>ans && sum<=max) {
						ans = sum;
					}
					sum=0;
				}
			}
		}
		System.out.println(ans);
	}

}
