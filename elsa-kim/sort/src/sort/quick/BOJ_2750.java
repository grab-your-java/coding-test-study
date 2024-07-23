package sort.quick;

import java.util.Scanner;

public class BOJ_2750 {
public static int[] getSortedList(int[] arr, int size) {
		
		int f = arr[0];
		int Lcnt = 0;
		int Rcnt = 0;
		for (int i=0; i<size; i++) {
			if(arr[i]>arr[0]) {
				Rcnt++;
			}else if(arr[i]<arr[0]) {
				Lcnt++;
			}
		}
		int[] LArr = new int[Lcnt];
		int[] RArr = new int[Rcnt];
		for (int i=0, lidx=0, ridx=0; i<size; i++) {
			if(arr[i]>arr[0]) {
				RArr[ridx++] = arr[i];
			}else if(arr[i]<arr[0]) {
				LArr[lidx++] = arr[i];
			}
		}
		for(int i=0, idx=0; i<size; i++) {
			if(i<Lcnt) {
				arr[i]=getSortedList(LArr, Lcnt)[i];				
			}else if (i==Lcnt) {
				arr[i] = f;
			}else {
				arr[i] = getSortedList(RArr, Rcnt)[idx++];
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		
		arr = getSortedList(arr, size);
		
		for(int n:arr) {
			System.out.println(n);
		}
		
	}
}	
