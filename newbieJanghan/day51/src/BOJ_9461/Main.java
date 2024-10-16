package BOJ_9461;

import java.util.Scanner;

public class Main {
	static long[] arr = new long[100+1];
	static {
		for (int i=1; i<=100; i++) {
			if (i <= 3) {
				arr[i] = 1;
			} else if (i <=5) {
				arr[i] = 2;
			} else {
				arr[i] = arr[i-1] + arr[i-5];
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int tc = sc.nextInt();
		while (tc-- >0) {
			sb.append(arr[sc.nextInt()]).append("\n");
		}
		
		System.out.println(sb);
	}
}
