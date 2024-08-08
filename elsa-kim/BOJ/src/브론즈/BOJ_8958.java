package 브론즈;

import java.util.Scanner;

public class BOJ_8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test_case=1; test_case<=t; test_case++) {
			String test = sc.next();
			String[] arr = test.split("");
			int sum=0;
			for(int i=0; i<arr.length; i++) {
				if (arr[i].equals("X")) continue;
				for(int j=0; j<=i; j++) {
					if(arr[i-j].equals("X")) break;
					sum++;
				}
			}
			System.out.println(sum);
		}
	}
}
