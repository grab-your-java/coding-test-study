package room;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] boys = new int[6];
		int[] girls = new int[6];

		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();
			int grade = sc.nextInt();
			if (S == 0) {
				girls[grade - 1]++;
			} else {
				boys[grade - 1]++;
			}
		}

		int result = 0;
		for (int boy : boys) {
			result += (int) Math.ceil((double) boy / (double) K);
		}
		for (int girl : girls) {
			result += (int) Math.ceil((double) girl / (double) K);
		}
		System.out.println(result);
	}
}
