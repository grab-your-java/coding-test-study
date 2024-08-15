package SWEA;

import java.util.Scanner;

public class SWEA_4012_요리사 {
	static boolean[] check;
	static int[] res;
	static boolean[] half;
	static int[][] arr;
	static int size;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			size = sc.nextInt();
			arr = new int[size][size];
			half = new boolean[size];
			min = 20000;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			res = new int[size/2];
			check = new boolean[size];
			com(0, 0);
			System.out.println("#"+tc+" "+min);
		}
	}

	private static void com(int cnt, int start) {
		if(cnt == size/2) {
			int sum1 = 0;
			int sum2 = 0;
			half = new boolean[size];
			for(int i=0; i<cnt; i++) {
				half[res[i]] = true;
			}
			for(int i=0; i<size; i++) {
				if(half[i]) {
					for(int j=0; j<size; j++) {
						if(half[j]) {
							sum1+=arr[i][j];
						}
					}
					
				}else {
					for(int j=0; j<size; j++) {
						if(!half[j]) {
							sum2+=arr[i][j];
						}
					}
				}
				
			}
			if(Math.abs(sum1-sum2)<min)min=Math.abs(sum1-sum2);
			return;
		}
		for(int i=start; i<size; i++) {
			if(!check[i]) {
				check[i] = true;
				res[cnt] = i;
				com(cnt+1, i+1);
				check[i] = false;
			}
		}
		
	}

}
