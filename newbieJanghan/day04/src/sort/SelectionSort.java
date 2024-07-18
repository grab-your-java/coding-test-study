package sort;

import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] list = new int[N];
		
		// insert
		for (int i=0; i<N; i++) {
			list[i] = sc.nextInt();
		}
		
		// sort
		for (int i=0; i<N; i++) {
			int minIdx = i;
			for (int j=i+1; j<N; j++) {
				if (list[minIdx] > list[j]) {
					minIdx = j;
				}
			}
			int temp = list[i];
			list[i] = list[minIdx];
			list[minIdx] = temp;
		}
		
		// print
		for (int i=0; i<N; i++) {
			System.out.println(list[i]);
		}
		
	}
}
