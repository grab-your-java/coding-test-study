package Sugar;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 5000;
		for (int q = 0; q <= N / 5; q++) {
			int remain = N - (5 * q);
			if (remain % 3 == 0) {
				result = Math.min(result, q + (remain / 3));
			} 
		}
		if (result == 5000) {
			result = -1;
		}
		System.out.println(result);
	}
}
