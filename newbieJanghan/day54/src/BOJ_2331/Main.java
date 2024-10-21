package BOJ_2331;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(), P = sc.nextInt();
		
		int[] counts = new int[236197]; // 236196 + 1
		
		while (counts[A] != 2) {
			counts[A]++;
			A = cal(A, P);
		}
		
		int answer = 0;
		for (int cnt: counts) {
			if (cnt == 1) answer++;
		}
		
		System.out.println(answer);
	}
	
	static int cal(int number , int P) {
		int result = 0;
		
		String[] strArr = String.valueOf(number).split("");
		for (String str: strArr) {
			result += Math.pow(Integer.parseInt(str), P);  
		}
		
		return result;
	}
}
