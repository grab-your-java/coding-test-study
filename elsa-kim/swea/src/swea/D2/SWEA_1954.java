package swea.D2;

import java.util.Scanner;

public class SWEA_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int size = sc.nextInt();
			int[][] arr = new int[size][size];
			int num = 1;
			int j=0;
			out:while(num<=size*size) {
				
				for(int i=0+j; i<size-j; i++) {
					if (num>size*size) break out;
					arr[0+j][i] = num++;
				}
				for(int i=1+j; i<size-j; i++) {
					if (num>size*size) break out;
					arr[i][size-1-j] = num++;
				}
				for(int i=1+j; i<size-j; i++) {
					if (num>size*size) break out;
					arr[size-1-j][size-1-i] = num++;
				}
				for(int i=1+j; i<size-j-1; i++) {
					if (num>size*size) break out;
					arr[size-i-1][0+j] = num++;
				}
				j++;				
			}
			
			System.out.println("#"+test_case);
			for(int i=0; i<size; i++) {
				for(int k=0; k<size; k++) {
					System.out.print(arr[i][k]);
					if(k==size-1) continue;
					System.out.print(" ");
				}
				System.out.println();
			}
			
		}
	}
}
