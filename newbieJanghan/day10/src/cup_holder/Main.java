package cup_holder;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] chars = sc.next().toCharArray();

		int lCount = 0;
		for (char c : chars) {
			if (c == 'L') {
				lCount++;
			}
		}
		int result; 
		if (N < N + 1 - (lCount / 2)) {
			result = N;
		} else {
			result = N + 1 - (lCount / 2);
		}
		System.out.println(result);
	}
}
