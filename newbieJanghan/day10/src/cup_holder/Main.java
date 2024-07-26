package cup_holder;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] chars = sc.next().toCharArray();

		// Count char 'L'
		int lCount = 0;
		for (char c : chars) {
			if (c == 'L') {
				lCount++;
			}
		}
		
		// Supposing every 'S' and pair of 'L' use left side cup-holder
		// and also supposing every pair of 'L' needs one more cup-holder,
		// always right side cup-holder of last man is available.
		// Greedy Calculation = N - (count of 'L' / 2 ) + the last cup-holder 
		int result; 
		if (N < N + 1 - (lCount / 2)) {
			result = N;
		} else {
			result = N + 1 - (lCount / 2);
		}
		System.out.println(result);
	}
}
