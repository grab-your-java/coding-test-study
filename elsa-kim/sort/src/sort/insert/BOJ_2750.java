package sort.insert;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size;
		size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i=0;i<size; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i=1; i<size; i++) {
			int idx = 0;
			for (int j=0; j<i; j++) {
				if(arr[i]<arr[j]) {
					idx = j;
					break;
				}
				else {
					idx++;
				}
			}
			int[] sortingArr = Arrays.copyOfRange(arr, idx,i);
			arr[idx] = arr[i];
			
			for(int j=0;j<sortingArr.length;j++) {
				arr[idx+1+j] = sortingArr[j];
			}
		}
		for(int i=0; i<size; i++) {
			System.out.println(arr[i]);
		}
	}
}
