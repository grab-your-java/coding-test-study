package 브론즈;

import java.util.Scanner;

public class BOJ_2851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i=0; i<10; i++) {
			arr[i] = sc.nextInt();
		}
		int sum=0;
		for(int i=0; i<10; i++) {
			if(sum+arr[i]>100) {
				if(100-sum>=sum+arr[i]-100) {
					sum=sum+arr[i];
				}
				break;
			}else{
				sum+=arr[i];				
			}
		}
		System.out.println(sum);
	}
}
