package sort;

import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] list = new int[N];
		
		// insert
		for (int i=0; i<N; i++) {
			list[i] = sc.nextInt();
		}
		
		// sort
		for (int i=1; i<N; i++) {
			int current = list[i];
			int j = i-1;
			while (j>=0 && list[j] > current) {
				list[j+1] = list[j];
				j--;
			}
			list[j+1] = current;
		}
		
		// print
		for (int i=0; i<N; i++) {
			System.out.println(list[i]);
		}
		
	}
}
