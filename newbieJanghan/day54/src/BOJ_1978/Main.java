package BOJ_1978;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] primes = new boolean[1001];
		Arrays.fill(primes, true);
		primes[1] = false;

		for (int i = 2; i <= 1000; i++) {
			if (primes[i]) {
				for (int j = 2; j <= 1000/i; j++) {
					primes[i * j] = false;
				}
			}
		}
		
		int N = sc.nextInt(), answer = 0;
		for (int i=0; i<N; i++) {
			if (primes[sc.nextInt()]) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
