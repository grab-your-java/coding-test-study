package modular;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 42;
		int[] remains = new int[N];
		int result = 0;
		
		int inputsCount = 10;
		while (inputsCount-- > 0) {
			int remain = sc.nextInt() % N;
			if (remains[remain] == 0) {
				result++;
			}
			remains[remain]++;
		}
		
		System.out.println(result);
	}
}