package 실버;

import java.util.Scanner;

public class BOJ_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=n/5; i>=0; i--) {
			for(int j=0; j<=n/3; j++) {
				if(5*i+3*j ==n) {
					System.out.println(i+j);
					return;
				}
			}	
		}
		System.out.println(-1);
	}

}
