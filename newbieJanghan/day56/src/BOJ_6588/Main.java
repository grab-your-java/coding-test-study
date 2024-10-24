package BOJ_6588;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean[] isOddPrime = new boolean[1000001];
	static {
		Arrays.fill(isOddPrime, true);
		isOddPrime[0] = false;
		isOddPrime[1] = false;
		for (int i = 1; i <= 500000; i++) {
			isOddPrime[i * 2] = false;
		}

		for (int i = 3; i <= 1000000; i++) {
			if (isOddPrime[i]) {
				for (int j = 2; j <= 1000000 / i; j++) {
					isOddPrime[i * j] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int number;
		while ((number = sc.nextInt()) != 0) {
			int a = 3;
			while (a < number) {
				if (isOddPrime[a] && isOddPrime[number - a]) {
					sb.append(number + " = " + a + " + " + (number -a) + "\n");
					break;
				} 
				a++;
			}

			if (a == number) {
				sb.append("Goldbach's conjecture is wrong.\n");
			}
		}

		System.out.println(sb);
	}

}
