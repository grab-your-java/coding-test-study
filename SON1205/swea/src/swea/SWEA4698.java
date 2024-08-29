package swea;

import java.util.Scanner;

public class SWEA4698 {
	static int[] arr = new int[1000001];

	static {
		for (int i = 1; i < arr.length; i++) {
			if (isPrime(i)) {
				arr[i]++;
			}
		}
	}

	static boolean isPrime(int num) {
		if (num == 1) {
			return false;
		}

		for (int j = 2; j <= (int) Math.sqrt(num); j++) {
			if (num % j == 0) {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int T = 1; T <= TC; T++) {
			int D = sc.nextInt();
			
			int start = sc.nextInt();
			
			int end = sc.nextInt();
			
			int cnt = 0;
			
			for (int i = start; i <= end; i++) {
				int tmp = i;

				if (arr[i] == 0) {
					continue;
				}

				while (tmp > 0) {
					if (tmp % 10 == D) {
						cnt++;
						break;
					}
					tmp /= 10;
				}
			}
			
			System.out.println("#" + T + " " + cnt);
		}
	}
}
