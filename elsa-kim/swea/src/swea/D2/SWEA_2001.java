package swea.D2;

import java.util.Scanner;

public class SWEA_2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int max = 0;
			int sum = 0;
			int arrSize = sc.nextInt();
			int killSize = sc.nextInt();
			
			int[][] arr = new int[arrSize][arrSize];
			
			for(int i=0; i<arrSize; i++) {
				for(int j=0; j<arrSize; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<=arrSize-killSize; i++) {
				for(int j=0; j<=arrSize-killSize; j++) {
					for(int m=0; m<killSize; m++) {
						for(int n=0; n<killSize; n++) {
							sum+=arr[i+m][j+n];
						}
					}
					if(sum>max) max = sum;
					sum = 0;
				}
			}
			System.out.println("#"+test_case+" "+max);
		}
	}
}
