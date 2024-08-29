package sort;

import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] list = new int[N];
		
		// insert
		for (int i=0; i<N; i++) {
			list[i] = sc.nextInt();
		}
		
		// sort
		int c = N;
		while (c > 1) {
			for (int i=0; i<c-1; i++) {
				if (list[i] > list[i+1]) {
					int temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
				}
			}
			c--;
		}
		
		// print
		for (int i=0; i<N; i++) {
			System.out.println(list[i]);
		}
		
	}
}
