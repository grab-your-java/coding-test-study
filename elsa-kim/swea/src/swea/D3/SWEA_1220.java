package swea.D3;

import java.util.Scanner;

public class SWEA_1220 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
	
		for(int test_case = 1; test_case <= T; test_case++) {
			int size = sc.nextInt();
			int[][] arr = new int[size][size];
			
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int cnt = 0;
			boolean now = false;
			for(int i = 0; i<size; i++) {
				for(int j=0; j<size; j++) {
					if (arr[j][i]==1) {
						now=true;
					}else if(arr[j][i]==2 && now) {
						cnt++;
						now = false;
					}
				}
				now=false;
			}
			System.out.println("#"+test_case+" "+cnt);
			
		}
	}
	

}
