package sort.select;

import java.util.Scanner;

public class BOJ_2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		for(int j=0; j<size; j++) {
			
			int idx=j;
			int minIdx = idx;
			int temp;
			for (int i=idx+1; i<size; i++) {
				if(arr[i]<arr[minIdx]) minIdx = i;
			}
			temp = arr[idx];
			arr[idx] = arr[minIdx];
			arr[minIdx] = temp;
		}
		for(int i=0; i<size; i++) {
			System.out.println(arr[i]);
		}
		
	}
}
