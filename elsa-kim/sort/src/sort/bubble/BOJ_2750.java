package sort.bubble;

import java.util.Scanner;

public class BOJ_2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for (int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		for(int j=1; j<size; j++) {
			for(int i=0; i<size-j; i++) {
				if(arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
		for(int i=0; i<size; i++) {
			System.out.println(arr[i]);
		}
	}
}
