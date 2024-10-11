package BOJ_1463;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];

		for (int number = 2; number <= N; number++) {
			arr[number] = arr[number - 1] + 1;
			if (number % 3 == 0) {
				arr[number] = Math.min(arr[number / 3] + 1, arr[number]);
			}
			if (number % 2 == 0) {
				arr[number] = Math.min(arr[number / 2] + 1, arr[number]);
			}
		}
		
		System.out.println(arr[N]);
	}
}
