package BOJ_2875;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt(), answer = 0;

		while (N >= 2 && M >= 1) {
			N -= 2;
			M--;
			answer++;
		}

		K -= (N + M);
		while (K >= 1 && answer >= 1) {
			K -= 3;
			answer -= 1;
		}
		
		System.out.println(answer);
	}
}
