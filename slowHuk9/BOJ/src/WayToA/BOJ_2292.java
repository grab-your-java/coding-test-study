package WayToA;

import java.util.Scanner;

public class BOJ_2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int i = 1;
		int end = 1;
		
		while (n>end) {
			end = end + 6 * i;
			i++;
		}
		System.out.println(i);
		
		sc.close();
		
	}

}
