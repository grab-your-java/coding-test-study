package sort.merge;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2751 {
	public static int[] getsortedArr(int[] arr, int size) {
		if (size>1) {
			int left = arr.length/2;
			int right = arr.length - left;
			int[] larr = getsortedArr(Arrays.copyOf(arr, left), left);
			int[] rarr = getsortedArr(Arrays.copyOfRange(arr, left, size), right);
			for(int i=0, l=0, r=0; i<arr.length;i++) {
				if(l<left&&r<right&&larr[l]>rarr[r]) {
					arr[i] = rarr[r++];
				}else if(l<left&&r<right&&larr[l]<rarr[r]){
					arr[i] = larr[l++];
					
				}else if(l<left && r==right) {
					arr[i]=larr[l++];
				}else {
					arr[i]=rarr[r++];
				}
			}
			return arr;
		} else {
			return arr;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		
		getsortedArr(arr, size);
		
		for(int i=0; i<size; i++) {
			System.out.println(arr[i]);
		}
	}
}
