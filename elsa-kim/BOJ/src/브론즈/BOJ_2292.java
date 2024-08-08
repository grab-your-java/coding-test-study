package 브론즈;

import java.util.Scanner;

public class BOJ_2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long target = sc.nextInt();
		int n=2;
		if(target==1) {
			System.out.println(1);
			return;
		}else {
			while(target>(3*(Math.pow(n, 2))-3*n + 1)) {
				n++;
			}
			System.out.println(n);
		}		
	}

}
