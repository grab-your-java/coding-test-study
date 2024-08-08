package 브론즈;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		Arrays.sort(arr);
		int not1=0;
		int not2=0;
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum-arr[i]-arr[j]==100) {
					not1 = i;
					not2 = j;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			if(i == not1||i==not2) continue;
			System.out.println(arr[i]);
		}
	}
}
