package ATM;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// input
		int[] minutes = new int[N];
		for (int i = 0; i < N; i++) {
			minutes[i] = sc.nextInt();
		}
		
		// sort ASC
		Arrays.sort(minutes);
		
		// calculate
		int result = 0;
		for (int i = 0; i < N; i++) {
			result += minutes[i] * (N - i);
		}
		System.out.println(result);
	}

}
