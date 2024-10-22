package 실버;

import java.util.Scanner;

public class BOJ_1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		boolean[] check = new boolean[N + 1];
		next: for (int i = 2; i < check.length; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (!check[j])
					continue;
				if (i % j == 0)
					continue next;
			}
			check[i] = true;
			if (i < M)
				continue;
			System.out.println(i);

		}
	}

}
